package com.simon.rxjava;

import org.junit.Test;

import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.observables.GroupedObservable;

/**
 * Description:     RxJava操作符转化
 * Author:          simondai
 * Version:         V1.0
 * Date:            2017/10/11 11:19
 */

public class TransformingObservables {


    /**
     * map
     * <p>
     * 将A转换成B
     * <p>
     * 一对一
     */
    @Test
    public void mapTransform() {

        Observable.just(123).map(new Func1<Integer, String>() {
            @Override
            public String call(Integer integer) {
                return integer + "";
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.print(s);
            }
        });
    }


    /**
     * flatMap
     * <p>
     * 1对多
     * <p>
     * 应用于一个网络请求依赖于另个一网络请求
     */
    @Test
    public void flatMapTransform() {

        Observable.just(1, 2, 3, 4, 5).flatMap(new Func1<Integer, Observable<? extends String>>() {
            @Override
            public Observable<? extends String> call(Integer integer) {
                return Observable.just(integer + "");
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.print(s);
            }
        });
    }


    /**
     * 分组
     */

    @Test
    public void groupByTransform() {

        Observable.just(1, 2, 3, 4, 5).groupBy(new Func1<Integer, Integer>() {
            @Override
            public Integer call(Integer integer) {
                return integer % 2;
            }
        }).subscribe(new Observer<GroupedObservable<Integer, Integer>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(final GroupedObservable<Integer, Integer> integerIntegerGroupedObservable) {
                integerIntegerGroupedObservable.subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println(integerIntegerGroupedObservable.getKey() + ":" + integer);
                    }
                });
            }
        });

    }


    /**
     * 将数据组装打包
     * 几个打包一起
     * 2就是两个一起
     */
    @Test
    public void bufferTransform() {

        Observable.range(1, 5).buffer(2).subscribe(new Action1<List<Integer>>() {
            @Override
            public void call(List<Integer> integers) {

                System.out.print(integers);

            }
        });

    }


    /**
     * 每次发送的时候都会扫描
     * 自己定义每次扫描的规则
     * 例子中就是计算每次发送的时候数据的和
     */

    @Test
    public void scanTransform() {

        Observable.range(1, 5).scan(new Func2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer sum, Integer integer1) {
                return sum + integer1;
            }
        }).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.println(integer);
            }
        });

    }


    /**
     * 类似buffer，只是返回的是Observable对象
     */

    @Test
    public void windowTransform(){

        Observable.range(1, 5).window(2).subscribe(new Subscriber<Observable<Integer>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Observable<Integer> integerObservable) {
                integerObservable.subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        System.out.println(integer);
                    }
                });
            }
        });

    }

}



































