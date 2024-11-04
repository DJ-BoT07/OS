package Practice;
import java.util.concurrent.Semaphore;

class RW {
    private static final int NUM_READERS = 3;
    private static final int NUM_WRITERS = 2;
    private static int readCount = 0;
    private static Semaphore mutex = new Semaphore(1);
    private static Semaphore write = new Semaphore(1);

    public static void main(String[] args) {
        for (int i = 0; i < NUM_READERS; i++) {
            new Thread(new Reader(i)).start();
        }
        for (int i = 0; i < NUM_WRITERS; i++) {
            new Thread(new Writer(i)).start();
        }
    }

    static class Reader implements Runnable {
        private int id;
        Reader(int id) { this.id = id; }

        public void run() {
            try {
                while (true) {
                    mutex.acquire();
                    readCount++;
                    if (readCount == 1) write.acquire();
                    mutex.release();

                    System.out.println("Reader " + id + " reading");
                    Thread.sleep(2000);

                    mutex.acquire();
                    readCount--;
                    if (readCount == 0) write.release();
                    mutex.release();
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    static class Writer implements Runnable {
        private int id;
        Writer(int id) { this.id = id; }

        public void run() {
            try {
                while (true) {
                    write.acquire();
                    System.out.println("Writer " + id + " writing");
                    Thread.sleep(2000);
                    write.release();
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
