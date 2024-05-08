package ex_3;

class JoinTestThread extends Thread {
    Thread t;
    String n;
    int number;
    static int sumOfDivisors = 0;

    JoinTestThread(String n, Thread t, int number) {
        this.setName(n);
        this.t = t;
        this.number = number;
        this.n = n;
    }

    public void run() {
        System.out.println("Thread " + n + " has entered the run() method");
        try {
            if (t != null)
                t.join();
            int sum = compute(number);


                sumOfDivisors += sum;
                System.out.println("Thread " + n + " calculated sum of divisors: " + sum);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int compute(int num) {
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
