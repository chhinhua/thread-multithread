import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadSquare extends Thread {
    ShareData shareData;

    ThreadSquare(ShareData shareData) {
        this.shareData = shareData;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (shareData) {
                try {
                    shareData.notifyAll();
                    shareData.wait();
                } catch (InterruptedException e) {
                    Logger.getLogger(ThreadSquare.class.getName()).log(Level.SEVERE, null, e);
                }

                int square = shareData.getRad();
                square *= square;
                System.out.println("Square: " + square + "\n");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
