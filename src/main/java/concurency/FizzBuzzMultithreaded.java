package concurency;

import java.util.concurrent.*;
import java.util.function.IntConsumer;

class FizzBuzzMultithreaded {
    private final int n;
    private int counter;
    private final Semaphore sem;
    private final Semaphore sem3;
    private final Semaphore sem5;
    private final Semaphore sem15;

    public FizzBuzzMultithreaded(int n) {
        this.n = n;
        sem = new Semaphore(1);
        sem3 = new Semaphore(0);
        sem5 = new Semaphore(0);
        sem15 = new Semaphore(0);
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 3; i <= n; i += 3) {
            if (i % 5 != 0) { // skip multiples of 15.
                sem3.acquire();
                printFizz.run();
                sem.release();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 5; i <= n; i += 5) {
            if (i % 3 != 0) { // skip multiples of 15.
                sem5.acquire();
                printBuzz.run();
                sem.release();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 15; i <= n; i += 15) {
            sem15.acquire();
            printFizzBuzz.run();
            sem.release();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; ++i) {
            sem.acquire();
            if (i % 15 == 0) {
                sem15.release();
            }else if (i % 5 == 0) {
                sem5.release();
            }else if (i % 3 == 0) {
                sem3.release();
            }else {
                printNumber.accept(i);
                sem.release();
            }
        }
    }
}
