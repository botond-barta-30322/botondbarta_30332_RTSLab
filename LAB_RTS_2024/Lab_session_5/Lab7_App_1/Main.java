package Lab7_App_1;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String args[]) throws BrokenBarrierException, InterruptedException {
        Semaphore s9 = new Semaphore(1);
        Semaphore s10 = new Semaphore(1);
        CyclicBarrier barrier = new CyclicBarrier(3);
        Fir1 f1, f2, f3;
        while(true) {
            f1 = new Fir1(1, s9, s10, barrier, 4, 1, 2, 4, 4, 6);
            f2 = new Fir1(2, s9, s10, barrier, 5, 1, 3, 5, 5, 7);

            f1.start();
            f2.start();
            barrier.await();
            barrier.reset();
        }
    }
}