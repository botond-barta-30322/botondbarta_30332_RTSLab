package Lab4_App_2;

public class ExecutionThread1 extends Thread {
	Integer monitor9, monitor10;
	int sleep, activity_min1, activity_max1,activity_min2, activity_max2;
	public ExecutionThread1(Integer monitor9, Integer monitor10, int activity_min1,int activity_max1, int activity_min2,int activity_max2, int sleep) {
		this.monitor10=monitor10;
		this.monitor9 = monitor9;	
		this.activity_max1 = activity_max1;
		this.activity_min1=activity_min1;
		this.activity_max2 = activity_max2;
		this.activity_min2=activity_min2;
		this.sleep=sleep;
		}

    public void run() {
    	System.out.println(this.getName()+ " - STATE 1"); //P1 
		int k1 = (int) Math.round(Math.random()*(activity_max1 - activity_min1) + activity_min1); 
        for (int i = 0; i < k1 * 100000; i++) {
            i++; i--;
        									 }

        synchronized (monitor9) {

            System.out.println(this.getName()+ " - STATE 2 - P9 engaged"); //P4
        	int k2 = (int) Math.round(Math.random()*(activity_max2 - activity_min2) + activity_min2); 
            for (int i = 0; i < k2 * 100000; i++) {
                i++; i--;
            						}

            synchronized (monitor10) {
            	System.out.println(this.getName()+ " - STATE 3 - P10 engaged"); //P6 
            	try {
                    Thread.sleep(Math.round(Math.random() * sleep* 500)); //T6
                	} 
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                monitor10.notify(); // Notify ExecutionThread2 that P10 is released
            }

            try {
                monitor9.wait(); // Wait for ExecutionThread2 to notify that P9 is released
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(this.getName()+ " - STATE 4 - monitors disengaged"); // P7
    }
}