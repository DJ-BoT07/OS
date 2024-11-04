package Practice;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

class PCMutexS {
    private static final int BUFFER_SIZE = 5;
    private static Queue<Integer> buffer = new LinkedList<>();
    private static Semaphore empty = new Semaphore(BUFFER_SIZE);
    private static Semaphore full = new Semaphore(0);
    private static Semaphore mutex = new Semaphore(1);

    public static void main(String[] args) {
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
    }

    static class Producer implements Runnable {
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    empty.acquire(); // Wait for empty slot
                    mutex.acquire(); // Lock buffer
                    buffer.add(i);   // Produce item
                    System.out.println("Produced: " + i);
                    mutex.release(); // Unlock buffer
                    full.release();  // Signal that an item is produced
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    static class Consumer implements Runnable {
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    full.acquire();  // Wait for full slot
                    mutex.acquire(); // Lock buffer
                    int item = buffer.poll(); // Consume item
                    System.out.println("Consumed: " + item);
                    mutex.release(); // Unlock buffer
                    empty.release(); // Signal that an item is consumed
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
