package Application_4;

public class ExecutionThread1 extends Thread{
Integer monitor6, monitor10;
int activity_min, activity_max, sleep;

public ExecutionThread1(Integer monitor6, Integer monitor10,int activity_min, int activity_max, int sleep )
{
this.monitor6=monitor6;	
this.monitor10=monitor10;		
this.activity_min=activity_min;		
this.activity_max=activity_max;	
this.sleep=sleep;	
}

public void run() {
	System.out.println(this.getName()+ " - STATE 0"); // P0 
	
	try {
        Thread.sleep(Math.round(Math.random() * sleep * 500)); // T5 waits
    } catch (InterruptedException e) {
        e.printStackTrace();
    }	
	
	System.out.println(this.getName()+ " - STATE 1"); //P1 works
	int k = (int) Math.round(Math.random()*(activity_max - activity_min) + activity_min); 
    for (int i = 0; i < k * 100000; i++) {
        i++; i--;
	}
    synchronized (monitor6) {
        System.out.println(this.getName() + " - P6 released"); //sends the token to P6
        monitor6.notify();
    }
    
    synchronized (monitor10) {
        System.out.println(this.getName() + " - P10 released"); //sends the token to P10
        monitor10.notify();
    }
    System.out.println(this.getName() + " - STATE 2");

}
}
