package com.simon.rxjava;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.observables.GroupedObservable;

/**
 * Description:     创建型操作符
 * Author:          simondai
 * Version:         V1.0
 * Date:            2017/10/11 11:55
 */

public class CreatingObservable {


    /**
     * create 操作符
     */
    @Test
    public void createCreating() {

        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("simon");
            }
        }).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        });

    }


    /**
     * just
     */
    @Test
    public void justCreating() {

        Observable.just(1, 2, 3, 4).buffer(2).subscribe(new Action1<List<Integer>>() {
            @Override
            public void call(List<Integer> integers) {
                System.out.println(integers);
            }
        });

    }


    /**
     * from
     */
    @Test
    public void fromCreating() {

        List<String> list = new ArrayList<>();

        list.add("simon");
        list.add("jack");
        list.add("apple");
        list.add("auto");
        list.add("mac");
        list.add("pack");
        list.add("good");

        Observable.from(list).groupBy(new Func1<String, String>() {
            @Override
            public String call(String s) {
                return s.contains("a") ? "a" : "o";
            }
        }).subscribe(new Action1<GroupedObservable<String, String>>() {
            @Override
            public void call(final GroupedObservable<String, String> stringStringGroupedObservable) {
                stringStringGroupedObservable.subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println(stringStringGroupedObservable.getKey() + ":" + s);
                    }
                });
            }
        });


        Observable.from(list).groupBy(new Func1<String, Integer>() {
            @Override
            public Integer call(String s) {
                return s.contains("a") ? 0 : 1;
            }
        }).subscribe(new Action1<GroupedObservable<Integer, String>>() {
            @Override
            public void call(final GroupedObservable<Integer, String> integerStringGroupedObservable) {
                integerStringGroupedObservable.subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println(integerStringGroupedObservable.getKey() + ":" + s);
                    }
                });
            }
        });

    }


    /**
     * defer
     * <p>
     * 知道subscribe的时候才会去创建observable对象
     */
    @Test
    public void deferCreating() {

        final List<String> list = new ArrayList<>();

        list.add("simon");
        list.add("jack");
        list.add("apple");
        list.add("auto");
        list.add("mac");
        list.add("pack");
        list.add("good");

//        String value = "";
//
//        Observable observable = Observable.defer(new Func0<Observable<String>>() {
//            @Override
//            public Observable<String> call() {
//                return Observable.just(value);
//            }
//        });
//
//        value = "simon";
//
//        observable.subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//
//            }
//        });


        Observable.defer(new Func0<Observable<String>>() {
            @Override
            public Observable<String> call() {
                return Observable.from(list);
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println(s);
            }
        });


    }


    /**
     * Empty
     * 直接走Complete
     */
    @Test
    public void emptyCreating() {

        Observable.empty().subscribe(new Subscriber<Object>() {
            @Override
            public void onCompleted() {
                System.out.println("c");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Object o) {
                System.out.println(o);
            }
        });
    }


    /**
     * never 不会发射
     */
    @Test
    public void neverCreating() {

        Observable.never().subscribe(new Subscriber<Object>() {
            @Override
            public void onCompleted() {
                System.out.println("c");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println(e);
            }

            @Override
            public void onNext(Object o) {
                System.out.println(o);
            }
        });

    }


    /**
     * Throw
     * 对应的是error
     * 始终走onError回调
     */
    @Test
    public void throwCreating() {

        Observable.error(new Throwable()).subscribe(new Subscriber<Object>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                System.out.println(e);
            }

            @Override
            public void onNext(Object o) {

            }
        });

    }


    /**
     * interval
     */
    @Test
    public void intervalCreating() {

//        Observable.just(123).timeInterval()
        Observable.interval(1, TimeUnit.SECONDS).subscribe(new Subscriber<Long>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Long aLong) {

            }
        });

    }


    /**
     * range
     */
    @Test
    public void rangeCreating() {

        Observable.range(1, 4).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {

            }
        });

    }


    /**
     * repeat
     */
    @Test
    public void repeatCreating() {

        Observable.range(1, 6).repeat(2).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.println(integer);
            }
        });

    }


    /**
     * start
     * <p>
     * <p>
     * 2
     * 1
     * 2
     * 3
     * *****
     * 2
     * 4
     * 5
     * 6
     * 7
     * 1
     * 2
     * 3
     * 4
     * 5
     * 6
     * 7
     * 8
     * 9
     */

    @Test
    public void startCreating() {

        Observable.range(1, 3).startWith(2).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.println(integer);
            }
        });

        System.out.println("******");

        Observable.range(1, 9).startWith(2, 4, 5, 6, 7).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.println(integer);
            }
        });

    }


    /**
     * timer
     */
    @Test
    public void timerCreating() {


        Observable.range(1, 6).timer(2, TimeUnit.SECONDS).subscribe(new Action1<Long>() {
            @Override
            public void call(Long aLong) {

            }
        });


    }
}



























