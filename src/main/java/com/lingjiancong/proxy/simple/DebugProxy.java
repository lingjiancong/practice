package com.lingjiancong.proxy.simple;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lingjiancong
 */
public class DebugProxy implements InvocationHandler {

    private Object object;

    public DebugProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;

        try {
            System.out.println("before method " + method.getName());
            result = method.invoke(object, args);
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        } catch (Exception e) {
            throw new RuntimeException("unexpected invocation exception: " + e.getMessage());
        } finally {
            System.out.println("after method: " + method.getName());
        }
        return result;
    }

    public static Object newInstance(Object obj) {
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(), new DebugProxy(obj));
    }

    public static void main(String[] args) {
       Foo foo = (Foo) DebugProxy.newInstance(new FooImpl());
       foo.doSomething();
    }
}
