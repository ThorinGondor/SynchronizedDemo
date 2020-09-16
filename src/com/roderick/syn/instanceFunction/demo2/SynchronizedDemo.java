package com.roderick.syn.instanceFunction.demo2;

import static java.lang.System.*;
import static java.lang.Thread.sleep;

public class SynchronizedDemo {
    public synchronized void method1() {
        out.println("Method 1 start");
        try {
            out.println("Method 1 execute...");
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        out.println("Method 1 end!");
    }

    public /*synchronized*/ void method2() {
        out.println("Method 2 start");
        try {
            out.println("Method 2 execute...");
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        out.println("Method 2 end!");
    }


    public static void main(String[] args) {
        final SynchronizedDemo instance = new SynchronizedDemo();

        new Thread(instance::method1).start();
        new Thread(instance::method2).start();
    }
    //结果分析：当线程1还在执行时，线程2也执行了，所以当其他线程来访问非synchronized修饰的方法时是可以访问的

}