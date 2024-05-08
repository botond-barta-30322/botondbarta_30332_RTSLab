package Application_1;

public class Main {

	public static void main(String[] args) {
		Integer monitor9 = new Integer(1);
		Integer monitor10=new Integer(2);
		new ExecutionThread1(monitor9, 2, 4, 4).start();
		new ExecutionThread2(monitor9, monitor10, 3, 6, 3).start();
		new ExecutionThread3(monitor9, 2, 5, 5).start();
	}

}
