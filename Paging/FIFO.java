import java.util.Arrays;
import java.util.ArrayList;

public class FIFO {
    public static void fifo(int pageReferences[], int numFrames) {
        ArrayList<Integer> frames = new ArrayList<>(numFrames);
        int pageFaults = 0;
        int pageHits = 0;
        
        for (int i = 0; i < pageReferences.length; i++) {
            int page = pageReferences[i];
            
            if (frames.contains(page)) {
                pageHits++;
            } else {
                if (frames.size() >= numFrames) {
                    frames.remove(0); // Remove oldest page
                }
                frames.add(page);
                pageFaults++;
            }
            System.out.println("Page " + page + ": Frames: " + frames);
        }
        System.out.println("Page Faults: " + pageFaults);
        System.out.println("Page Hits: " + pageHits);
    }

    public static void main(String[] args) {
        int[] pageReferences = {1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5}; 
        int numFrames = 3; 
        System.out.println("fifo Page Replacement:");
        fifo(pageReferences, numFrames);
    }
}
