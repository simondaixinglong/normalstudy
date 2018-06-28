package com.simon.rxjava;

import org.junit.Test;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func2;


/**
 * Description:     组合型Observable
 * Author:          simondai
 * Version:         V1.0
 * Date:            2017/10/12 11:00
 */

public class CombiningObservable {


    /**
     * zip
     * 用来合并两个Observable并发射数据项，根据Func2函数生产一个新的值并发射出去。当其中一个Observable结束或发生异常的时候，
     * 另个一Observable也将停止发射
     */
    @Test
    public void zipCombine() {

        Observable<Integer> observable1 = Observable.just(1, 2, 3);
        Observable<Integer> observable2 = Observable.just(5, 6, 7, 8);

        Observable.zip(observable1, observable2, new Func2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        }).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(integer);
            }
        });

    }


    /**
     * merge
     * 将两个Observable发射的事件序列组合合并成一个事件序列，好像是一个Observable发射的一样。
     * 参考数据产生时间节点作为合并后的先后顺序
     */
    @Test
    public void mergeCombine() {

        Observable<Integer> observable1 = Observable.just(1, 2, 3);
        Observable<Integer> observable2 = Observable.just(5, 6, 7, 8);

        Observable.merge(observable1, observable2).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.print(integer);
            }
        });

    }


    /**
     * startWith
     * 用于在原Observable发射数据源前插入数据。使用startWith(Iterable</>)我们还可以在
     * 源Observable发射的数据源前插入Iterable
     */
    @Test
    public void startWithCombine() {

        Observable<Integer> observable1 = Observable.just(1, 2, 3);
        Observable<Integer> observable2 = Observable.just(5, 6, 7, 8);

        observable1.startWith(observable2).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.print(integer);
            }
        });
    }


    /**
     * combineLast
     * 将两个Observable最近发射的数据源通过Func2函数规则组合
     * 8
     * 9
     * 10
     * 11
     *
     * 3是1的最后一个，跟2的每个相加
     */
    @Test
    public void combineLastCombine() {

        Observable<Integer> observable1 = Observable.just(1, 2, 3);
        Observable<Integer> observable2 = Observable.just(5, 6, 7, 8);

        observable1.combineLatest(observable1, observable2, new Func2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        }).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.println(integer);
            }
        });

    }


}














































