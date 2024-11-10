package Practice;
import java.util.concurrent.Semaphore;

class RWPrac {
    private static final int READERS = 3;
    private static final int WRITERS = 2;
    private static int readCount = 0;
    private static Semaphore mutex = new Semaphore(1);
    private static Semaphore write = new Semaphore(1);

    public static void main(String[] args) {
        for(int i = 0; i < READERS; i++){
            new Thread(new Reader(i)).start();
        }
        for(int i = 0; i < WRITERS; i++){
            new Thread(new Writer(i)).start();
        }
    }

    static class Reader implements Runnable{
        int id;
        Reader(int id){
            this.id = id;
        }

        public void run(){
            try{
                while(true) {
                    mutex.acquire();
                    readCount++;
                    if(readCount == 1) write.acquire();
                    mutex.release();
                    System.out.println("Reader " + id + " is reading");
                    Thread.sleep(1000);

                    mutex.acquire();
                    readCount--;
                    if(readCount == 0) write.release();
                    mutex.release();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }

    static class Writer implements Runnable{
        int id;
        Writer(int id){
            this.id = id;
        }

        public void run(){
            try{
                while(true) {
                    write.acquire();
                    System.out.println("Writer " + id + " is writing");
                    Thread.sleep(1000);
                    write.release();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }
}
