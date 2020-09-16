package com.roderick.syn.staticFunction.demo1;

import static java.lang.System.*;

public class SynchronizedDemo implements Runnable {
    //共享资源
    static int i =0;
    /**
     * synchronized 修饰static静态方法
     */
    public static synchronized void increase(){
        i++;
    }
    @Override
    public void run(){
        for (int j =0 ; j<10000;j++){
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new SynchronizedDemo());
        Thread t2 = new Thread(new SynchronizedDemo());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        out.println(i);
    }
    //分析：由例子可知，两个线程实例化两个不同的对象。
    // 但是访问的方法是静态的，两个线程发生了互斥（即一个线程访问，另一个线程只能等着），因为静态方法是依附于类而不是对象的，当synchronized修饰静态方法时，锁是class对象。
}
