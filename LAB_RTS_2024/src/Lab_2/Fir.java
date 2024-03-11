package Lab_2;

import java.util.Observable;

public class Fir extends Observable implements Runnable {
    private int id;
    private int priority;
    private Window win;
    private int processorLoad;

    // Constructor
    public Fir(int id, int priority, Window win, int processorLoad) {
        this.id = id;
        this.priority = priority;
        this.win = win;
        this.processorLoad = processorLoad;
    }

 
    public int getId() {
        return id;
    }

    public int getPriority() {
        return priority;
    }

    public Window getWindow() {
        return win;
    }

    public int getProcessorLoad() {
        return processorLoad;
    }

    public void run() {
        int c = 0;
        while (c < 1000) {
            for (int j = 0; j < this.processorLoad; j++) {
                j++;
                j--;
            }
            c++;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setChanged();
            notifyObservers(c);
        }
    }
}