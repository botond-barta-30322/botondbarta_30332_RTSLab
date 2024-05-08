package Application_3;

public class Main {

	public static void main(String[] args) {
Integer monitor8 = new Integer(1);

new ExecutionThread(monitor8, 3,6,5).start();
new ExecutionThread(monitor8, 4,7,3).start();
new ExecutionThread(monitor8, 5,7,6).start();
	}

}
