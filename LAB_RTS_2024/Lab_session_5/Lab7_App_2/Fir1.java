package Lab7_App_2;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;

public class Fir1 extends Thread{
    int name,sleep,activity_max,activity_min;
    Lock l;
    CountDownLatch latch;
    Fir1(int n, Lock l, int sleep, int activity_min, int activity_max, CountDownLatch latch) {
        this.name = n;
        this.l = l;
        this.sleep = sleep;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.latch = latch;
    }
    public void run() {
        while (true) {

            System.out.println("Fir " + name + " State 1");
            this.l.lock();
            System.out.println("Fir " + name + " acquired the lock" + l);

            System.out.println("Fir " + name + " State 2");
            int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
            try {
                Thread.sleep(sleep * 500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.l.unlock();
            System.out.println("Fir " + name + " released the lock" + l);


            System.out.println("Fir " + name + " State 3");

            latch.countDown();
            System.out.println("T8 has been reached by Fir "+ name);
            try {
                Thread.sleep(8 * 500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}