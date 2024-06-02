package Lab7_App_2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String args[]) {
        Lock l9 = new ReentrantLock();
        Lock l10 = new ReentrantLock();

        Fir1 f1, f3;
        Fir2 f2;
        while(true) {
            CountDownLatch latch = new CountDownLatch(4);
            f1 = new Fir1(1, l9, 4, 2, 4, latch);
            f2 = new Fir2(2, l9, l10, 3, 3, 6, latch);
            f3 = new Fir1(3, l10, 5, 2, 5, latch);


            f1.start();
            f2.start();
            f3.start();

            try {
                // Wait for all threads to complete
                latch.countDown();
                latch.await();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}