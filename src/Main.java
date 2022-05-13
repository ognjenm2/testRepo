import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    static int counter = 0;
    static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    for (int i = 1; i <= 10000; i++) {
                        Main.counter++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    for (int i = 1; i <= 10000; i++) {
                        Main.counter++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final value: " + Main.counter);
        //test minor version commit
        //test gitHub commit
    }
}