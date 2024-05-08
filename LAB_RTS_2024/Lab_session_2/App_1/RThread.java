package App_1;

public class RThread extends Thread {
    private FileService service;

    public RThread(FileService service) {
        this.service = service;
    }

    public void run() {
        while (!Main.isStopThreads()) {
            try {
                synchronized (service) {
                    String readMsg = service.read();
                    System.out.println(readMsg);
                }
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
