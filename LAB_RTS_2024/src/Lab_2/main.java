package Lab_2;

import java.util.ArrayList;

public class main {
    private static final int noOfThreads = 10;
    private static final int processorLoad = 1000000;

    public static void main(String[] args) {
        Window win = new Window(noOfThreads);
        ArrayList<Fir> threads = new ArrayList<>();

        for (int i = 0; i < noOfThreads; i++) {
            Fir fir = new Fir(i, i + 2, win, processorLoad);
            fir.addObserver(win);
            threads.add(fir);
            Thread thread = new Thread(fir);
            thread.start();
        }
    }
}