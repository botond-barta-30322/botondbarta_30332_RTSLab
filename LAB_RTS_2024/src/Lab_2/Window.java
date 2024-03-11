package Lab_2;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class Window extends JFrame implements Observer {
    private final int noOfThreads;
    private final ArrayList<JProgressBar> bars = new ArrayList<>();

    public Window(int nrThreads) {
        this.noOfThreads = nrThreads;
        setLayout(null);
        setSize(450, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        init(nrThreads);
        setVisible(true);
    }

    private void init(int n) {
        for (int i = 0; i < n; i++) {
            JProgressBar bar = new JProgressBar();
            bar.setMaximum(1000);
            bar.setBounds(50, (i + 1) * 30, 350, 20);
            add(bar);
            bars.add(bar);
        }
    }

    public void update(Observable o, Object arg) {
        if (o instanceof Fir && arg instanceof Integer) {
            int id = ((Fir) o).getId();
            int value = (int) arg;
            setProgressValue(id, value);
        }
    }

    public void setProgressValue(int id, int val) {
        bars.get(id).setValue(val);
    }
}
