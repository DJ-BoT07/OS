package Practice;
import java.util.concurrent.Semaphore;

class Dining {
    private static final int NUM_PHILOSOPHERS = 5;
    private static Semaphore[] forks = new Semaphore[NUM_PHILOSOPHERS];

    public static void main(String[] args) {
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            forks[i] = new Semaphore(1);
            final int id = i;
            new Thread(() -> {
                try {
                    while (true) {
                        think(id);
                        eat(id);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }).start();
        }
    }

    private static void think(int id) throws InterruptedException {
        System.out.println("Philosopher " + id + " is thinking.");
        Thread.sleep((long) (Math.random() * 1000));
    }

    private static void eat(int id) throws InterruptedException {
        forks[id].acquire(); // Pick up left fork
        forks[(id + 1) % NUM_PHILOSOPHERS].acquire(); // Pick up right fork
        System.out.println("Philosopher " + id + " is eating.");
        Thread.sleep((long) (Math.random() * 1000));
        forks[(id + 1) % NUM_PHILOSOPHERS].release(); // Put down right fork
        forks[id].release(); // Put down left fork
    }
}
