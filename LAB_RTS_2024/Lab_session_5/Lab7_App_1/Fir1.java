package Lab7_App_1;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

class Fir1 extends Thread {
    int name, delay, permit, activity_min, activity_max, activity_min2, activity_max2;
    Semaphore s9, s10;
    CyclicBarrier barrier;

    Fir1(int n, Semaphore sa, Semaphore s10, CyclicBarrier barrier, int delay, int permit, int activity_min, int activity_max, int activity_min2, int activity_max2) {
        this.name = n;
        this.s9 = sa;
        this.s10 = s10;
        this.barrier = barrier;
        this.delay = delay;
        this.permit = permit;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.activity_min2 = activity_min2;
        this.activity_max2 = activity_max2;
    }

    public void run() {


        System.out.println("Fir " + name + " State 1");
        int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }

        try {
            this.s9.acquire(this.permit);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Fir " + name + " took a token from the semaphore 9");
        System.out.println("Fir " + name + " State 2");
        k = (int) Math.round(Math.random() * (activity_max2 - activity_min2) + activity_min2);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }
        // try lock
        try {
            this.s10.acquire(this.permit);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Fir " + name + " took a token from the semaphore 10");
        System.out.println("Fir " + name + " State 3");

        this.s9.release();
        System.out.println("Semaphore 9 has been released");
        this.s10.release();
        System.out.println("Semaphore 10 has been released");
        try {
            Thread.sleep(this.delay * 500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Fir " + name + " State 4");


        try {
            barrier.await(); // Wait for the other thread to reach the barrier
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }

        System.out.println("T8 has been reached by Fir " + name);

}
}