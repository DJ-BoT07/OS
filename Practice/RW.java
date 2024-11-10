package Practice;
import java.util.concurrent.Semaphore;

class RW {
    // Number of reader threads to create
    private static final int NUM_READERS = 3;
    // Number of writer threads to create
    private static final int NUM_WRITERS = 2;
    // Counter to track number of active readers
    private static int readCount = 0;
    // Semaphore to protect readCount variable
    private static Semaphore mutex = new Semaphore(1);
    // Semaphore to control writer access
    private static Semaphore write = new Semaphore(1);

    public static void main(String[] args) {
        for (int i = 0; i < NUM_READERS; i++) {
            new Thread(new Reader(i)).start();
        }
        for (int i = 0; i < NUM_WRITERS; i++) {
            new Thread(new Writer(i)).start();
        }
    }

    // Reader class that implements Runnable interface to create reader threads
    // Each reader thread can read shared data concurrently with other readers
    // but must coordinate with writers using semaphores for thread safety
    static class Reader implements Runnable {
        private int id;
        Reader(int id) { this.id = id; }

        // This is a Reader thread that implements the readers part of the readers-writers problem
        // It uses semaphores to ensure thread safety when multiple readers access shared resources
        // - Uses mutex semaphore to protect the readCount variable
        // - Uses write semaphore to block writers when readers are reading
        // - Multiple readers can read simultaneously but writers need exclusive access
        public void run() {
            try {
                while (true) {
                    mutex.acquire();  // Lock access to readCount
                    readCount++;      // Increment number of readers
                    if (readCount == 1) write.acquire(); // First reader blocks writers
                    mutex.release();   // Release readCount access

                    System.out.println("Reader " + id + " reading");
                    Thread.sleep(2000);  // Simulate reading

                    mutex.acquire();     // Lock access to readCount
                    readCount--;         // Decrement number of readers
                    if (readCount == 0) write.release(); // Last reader allows writers
                    mutex.release();     // Release readCount access
                    Thread.sleep(2000);  // Wait before reading again
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    static class Writer implements Runnable {
        private int id;
        Writer(int id) { this.id = id; }

        // This is a Writer thread that implements the writers part of the readers-writers problem
        // It uses the write semaphore to ensure exclusive access when writing
        // - Writers must wait for all readers to finish before writing
        // - Only one writer can write at a time
        public void run() {
            try {
                while (true) {
                    write.acquire();    // Get exclusive writing access
                    System.out.println("Writer " + id + " writing");
                    Thread.sleep(2000); // Simulate writing
                    write.release();    // Release writing access
                    Thread.sleep(2000); // Wait before writing again
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
