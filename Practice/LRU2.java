package Practice;
import java.util.*;

public class LRU2{
    public static void lru(int[] pageReferences, int numFrames){
        LinkedList<Integer> frames = new LinkedList<>();
        int pageFaults = 0;
        int pageHits = 0;

        for(int page: pageReferences){
            if(frames.contains(page)){
                pageHits++;
                frames.remove((Integer) page);
                frames.addLast(page);
            } else {
                if(frames.size() >= numFrames){
                    frames.removeFirst();
                }
                frames.addLast(page);
                pageFaults++;
            }
            System.out.println("Page " + page + ": " + frames);
        }
    }
    public static void main(String[] args) {
        int[] pageReferences = {1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5};
        int numFrames = 3;
        lru(pageReferences, numFrames);
    }
}

