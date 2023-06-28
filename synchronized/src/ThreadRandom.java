import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadRandom extends Thread {
    ShareData shareData;

    ThreadRandom(ShareData shareData) {
        this.shareData = shareData;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            synchronized (shareData) {
                int rad = random.nextInt(20) + 1;
                shareData.setRad(rad);
                System.out.println("Random: " + rad);

                try {
                    shareData.notifyAll();
                    shareData.wait();
                } catch (InterruptedException e) {
                    Logger.getLogger(ThreadRandom.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }
}
