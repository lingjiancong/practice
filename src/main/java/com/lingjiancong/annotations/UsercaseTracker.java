package com.lingjiancong.annotations;

import java.lang.reflect.Method;

/**
 * Created by lenovo on 2016/9/5.
 */
public class UsercaseTracker {

    public static void trackUseCases(Class<?> cl) {
        for (Method m : cl.getDeclaredMethods()) {
            UseCase uc;
            uc = m.getAnnotation(UseCase.class);
            if (uc != null) {
                System.out.println("Found Use Case: " + uc.id()
                        + " " + uc.description());
            }
        }
    }

    public static void main(String[] args) {
        trackUseCases(PasswordUtils.class);

    }
}
