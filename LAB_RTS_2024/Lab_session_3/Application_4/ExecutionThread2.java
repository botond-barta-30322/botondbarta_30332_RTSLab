package Application_4;


public class ExecutionThread2 extends Thread{
Integer monitor6;
int activity_min, activity_max;
ExecutionThread1 thread1;
public ExecutionThread2(Integer monitor6,int activity_min, int activity_max, ExecutionThread1 thread1)
{
this.monitor6=monitor6;		
this.activity_min=activity_min;		
this.activity_max=activity_max;	
}

public void run() {
	System.out.println(this.getName() + " - STATE 0");
    synchronized (monitor6) {
    	try {
    		 monitor6.wait();
    	
        System.out.println(this.getName() + " - waiting for token from T10");
       
    	} catch (InterruptedException e) {
    		throw new RuntimeException(e);
    	}
    }
    	 System.out.println(this.getName() + " - STATE 1");
        int k = (int) Math.round(Math.random()*(activity_max - activity_min) + activity_min); 
        for (int i = 0; i < k * 100000; i++) {
            i++; i--;
        									 }
    						
        System.out.println(this.getName() + " - STATE 2");
        
    	if (thread1!=null) {
    		try {
				thread1.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
}
}
