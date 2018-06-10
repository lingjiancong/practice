package com.lingjiancong.rxjava;

import org.junit.Test;

import io.reactivex.Observable;


/**
 * @author lingjiancong
 */
public class RxJavaUnitTest {

    String result = "";

    @Test
    public void returnAValue() {
        Observable<String> observer = Observable.just("Hello");
        observer.subscribe(s -> result = s);
    }
}
