package Practice;

import java.util.*;

public class FifoPrac{
    public static void fifo(int[] pageRef, int numFrames){
        ArrayList<Integer> frames = new ArrayList<>(numFrames);
        int pageFault = 0;
        int pageHits = 0;

        for(int page: pageRef){
            if(frames.contains(page)){
                pageHits++;
            } else {
                if(frames.size() >= numFrames){
                    frames.remove(0);
                }
                frames.add(page);
                pageFault++;
            }
            System.out.println("Page " + page + ": Frames: " + frames);
        }
        System.out.println("Page Faults: " + pageFault + ", Page Hits: " + pageHits);
    }

    public static void main(String[] args) {
        System.out.println("FIFO Page Replacement");
        fifo(new int[]{1,2,3,4,1,2,5,1,2,3,4,5}, 3);
        
    }
}