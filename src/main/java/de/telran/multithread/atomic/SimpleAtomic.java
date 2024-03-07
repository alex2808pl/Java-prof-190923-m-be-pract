package de.telran.multithread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class SimpleAtomic {

    static volatile int count;
    static AtomicInteger count1 = new AtomicInteger();

    public static void main(String[] args) {

            count = 0;
            increment();
        System.out.println(count);

        // вычитали
        // набор изменений
        // записали

        System.out.println(count1.addAndGet(10));
        System.out.println(count1.compareAndSet(11, 12));
        System.out.println(count1.get());

        int ev, newEl;
        do {
            ev = count1.get();
            newEl = ev + 2;
        }
        while (!count1.compareAndSet(ev, newEl));



    }

    public static void increment() {
        count++;
    }
}

