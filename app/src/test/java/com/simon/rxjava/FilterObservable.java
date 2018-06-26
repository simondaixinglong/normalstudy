package com.simon.rxjava;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Description:     过滤型操作符
 * Author:          simondai
 * Version:         V1.0
 * Date:            2017/10/11 17:46
 */

public class FilterObservable {


    /**
     * debounce
     * <p>
     * 在1秒之后发送
     */
    @Test
    public void debounceFilter() {

        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {


                try {
                    for (int i = 0; i < 10; i++) {
                        Thread.sleep(100);
                        subscriber.onNext(i);
                    }
                    subscriber.onCompleted();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    subscriber.onError(e);
                }
            }
        }).debounce(1, TimeUnit.SECONDS).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("completed");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println(e);
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(integer);
            }
        });

    }


    /**
     * dislinct
     * 去重
     */
    @Test
    public void dislinctFilter() {

        Observable.just(1, 2, 3, 3, 3, 3).distinct().subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.println(integer);
            }
        });

    }


    /**
     * elementAt
     * 取指定位置上面的元素
     */
    @Test
    public void elementAtFilter() {
        Observable.just(1, 2, 3, 4, 5, 6).elementAt(3).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.println(integer);
            }
        });
    }


    /**
     * filter
     * 条件过滤
     */
    @Test
    public void filterFilter() {

        Observable.just(1, 2, 3, 4, 5, 2, 3).distinct().filter(new Func1<Integer, Boolean>() {
            @Override
            public Boolean call(Integer integer) {
                return integer > 2;
            }
        }).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.println(integer);
            }
        });

    }


    /**
     * first
     * 取第一个元素
     */
    @Test
    public void firstFilter() {

        Observable.just(2, 4, 5, 6).distinct().first().subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.println(integer);
            }
        });
    }


    /**
     * ignoreElements
     * <p>
     * 直接走异常或complete
     */
    @Test
    public void ignoreElementsFilter() {

        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {

                subscriber.onNext("a");
//                throw new NullPointerException();
                subscriber.onCompleted();

            }
        }).ignoreElements().subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("complete");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println(e);
            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        });

    }


    /**
     * last
     * 取最后一个元素
     */
    @Test
    public void lastFilter() {

        Observable.just(1, 3, 4).last().subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.println(integer);
            }
        });

    }


    /**
     * sample采样
     * 每隔多长时间采样数据，输出
     */
    @Test
    public void sampleFilter() {

        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {

                try {

                    for (int i = 0; i < 10; i++) {
                        Thread.sleep(1000);
                        subscriber.onNext(i);
                    }
                    subscriber.onCompleted();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    subscriber.onError(e);
                }

            }
        }).sample(4, TimeUnit.SECONDS).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("Complete");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println(e);

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(integer);

            }
        });


    }


    /**
     * skip
     * 跳过前几个
     * 跳过后几个
     */
    @Test
    public void skipFilter(){

        Observable.just(1,2,2,2,3,4,5,56,6,7).skip(2).skipLast(2).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.println(integer);
            }
        });
    }


    /**
     * take
     * 取前几项
     * 取后几项
     */
    @Test
    public void takeFilter(){

        Observable.just(1,1,1,2,2,3,4,5,6).take(3).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.println(integer);
            }
        });


        Observable.just(1,1,1,2,2,3,4,5,6).takeLast(3).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.println(integer);
            }
        });
    }

}







































