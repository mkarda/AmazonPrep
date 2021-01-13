package concurency;

import java.util.concurrent.atomic.AtomicInteger;

public class PrintOrder {

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            try {
                third(() -> System.out.println("3"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                second(() -> System.out.println("2"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                first(() -> System.out.println("1"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


    }


    private static final AtomicInteger firstJobDone = new AtomicInteger(0);
    private static final AtomicInteger secondJobDone = new AtomicInteger(0);

    public PrintOrder() {}

    static void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first".
        printFirst.run();
        // mark the first job as done, by increasing its count.
        firstJobDone.incrementAndGet();
    }

    static void second(Runnable printSecond) throws InterruptedException {
        while (firstJobDone.get() != 1) {
//            System.out.println("2 is waiting");
            // waiting for the first job to be done.
        }
        // printSecond.run() outputs "second".
        printSecond.run();
        // mark the second as done, by increasing its count.
        secondJobDone.incrementAndGet();
    }

    static void third(Runnable printThird) throws InterruptedException {
        while (secondJobDone.get() != 1) {
//            System.out.println("3 is waiting");
            // waiting for the second job to be done.
        }
        // printThird.run() outputs "third".
        printThird.run();
    }
}
