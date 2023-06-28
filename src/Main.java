public class Main {
    public static void main(String[] args) {
        System.out.println("Start main thread!");

        // Way 1
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("thread 1 > " + i);
            }
        });
        thread1.start();

        // Way 2
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("thread 2 > " + i);
            }
        }).start();

        // Way 3
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("thread 3 > " + i);
            }
        }).start();

        // Way 4
        ThreadOne threadOne = new ThreadOne();
        threadOne.start();

        System.out.println("End main thread");
    }
}
