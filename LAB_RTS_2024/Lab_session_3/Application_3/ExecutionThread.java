package Application_3;

public class ExecutionThread extends Thread{
	Integer monitor8;
	int sleep, activity_min, activity_max;
	public ExecutionThread(Integer monitor8, int activity_min,int activity_max, int sleep) {
		this.monitor8 = monitor8;	
		this.activity_max = activity_max;
		this.activity_min=activity_min;
		this.sleep=sleep;
		}
	
		public void run() {
			while(true) {
			System.out.println(this.getName()+ " - STATE 1- START"); //P17, P0, P4	
			
			
			synchronized (monitor8) {
			System.out.println(this.getName()+ " - STATE 2 - P8 engaged"); //P18 etc
			int k = (int) Math.round(Math.random()*(activity_max - activity_min) + activity_min); 
	        for (int i = 0; i < k * 100000; i++) {
	            i++; i--;
			}
									} // monitor8 off
			
			System.out.println(this.getName()+ " - STATE 3 - P8 disengaged"); //P19 
			
			try {
	            Thread.sleep(Math.round(Math.random() * sleep * 500)); // T18
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
			
			System.out.println(this.getName()+ " - STATE 4 - RESTART"); //P20
			// restart ad infinitum
			}// exit infinite loop
}
}