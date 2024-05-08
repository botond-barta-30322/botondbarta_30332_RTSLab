package Application_4;

public class Main {

	public static void main(String[] args) {
		Integer monitor6= new Integer(1);
		Integer monitor10= new Integer(2);
		ExecutionThread1 thread1 = new ExecutionThread1(monitor6,monitor10,2,3,7);
		thread1.start();
		new ExecutionThread2(monitor6,3,5, thread1).start();
		new ExecutionThread3(monitor10,4,6, thread1).start();
	}

}
