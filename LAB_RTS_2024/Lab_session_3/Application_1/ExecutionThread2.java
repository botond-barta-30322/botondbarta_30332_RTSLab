package Application_1;

public class ExecutionThread2 extends Thread{
Integer monitor9, monitor10;
int sleep, activity_min, activity_max;
public ExecutionThread2(Integer monitor9, Integer monitor10, int activity_min,int activity_max, int sleep) {
	this.monitor10=monitor10;
	this.monitor9 = monitor9;	
	this.activity_max = activity_max;
	this.activity_min=activity_min;
	this.sleep=sleep;
	}
public void run() {
	System.out.println(this.getName()+ " - STATE 1"); //P11
	
	
	synchronized (monitor9) {
	System.out.println(this.getName()+ " - STATE 2 - P9 engaged"); //P12
		synchronized (monitor10) {
		System.out.println(this.getName()+ " - STATE 2 - P10 engaged"); //P12
		int k = (int) Math.round(Math.random()*(activity_max - activity_min) + activity_min); 
        for (int i = 0; i < k * 100000; i++) {
            i++; i--;
        									 }
        try {
            Thread.sleep(Math.round(Math.random() * sleep* 500)); //T12
        	} 
        catch (InterruptedException e) {
            e.printStackTrace();
        }
								}
							}
	
	System.out.println(this.getName()+ " - STATE 3 - monitors disengaged"); //P13
}

}