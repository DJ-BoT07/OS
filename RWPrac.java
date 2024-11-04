package Practice;
import java.io.Writer;
import java.util.concurrent.Semaphore;

public class RWPrac {
    private static int NUM_READER = 3;
    private static int NUM_WRITERS = 2;
    private static int readCount = 0;
    private static Semaphore mutex = new Semaphore(1);
    private static Semaphore write = new Semaphore(1);

    public static void main(String[] args) {
        for(int i = 0 ; i < NUM_READER; i++){
            new Thread(new Reader(i)).start();
        }
        for(int i = 0 ; i < NUM_WRITERS; i++){
            new Thread(new Writer(i)).start();
        }
    }

    static class Reader implements Runnable{
        private int id;
         Reader(int id){
            this.id  = id;
         }

         public void run(){
            try{
                while(true){
                    mutex.acquire();
                    readCount++;
                    if(readCount == 1) write.acquire();
                    mutex.release();

                    System.out.println();
                }
            }
         }
    }
}
