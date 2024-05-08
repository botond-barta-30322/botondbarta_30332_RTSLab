package ex_3;

public class Main {
    public static void main(String[] args) {
        JoinTestThread w1 = new JoinTestThread("Thread 1", null, 50001);
        JoinTestThread w2 = new JoinTestThread("Thread 2", w1, 20001);
        w1.start();
        w2.start();
    }
}
