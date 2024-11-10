package Practice;

import java.util.*;

public class FcfsPrac{
    public static void fcfs(int[] pageReferences, int numFrames){
        ArrayList<Integer> frames = new ArrayList<>(numFrames);
        int pageFaults = 0;
        int pageHits = 0;

        for(int page: pageReferences){
            if(frames.contains(page)){
                pageHits++;
            } else{ 
                if(frames.size() >= numFrames){
                    frames.remove(0);
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
        fcfs(pageReferences, numFrames);
    }
}