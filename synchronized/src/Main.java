public class Main {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();

        ThreadRandom threadRandom = new ThreadRandom(shareData);
        ThreadSquare threadSquare = new ThreadSquare(shareData);

        threadRandom.start();
        threadSquare.start();
    }
}