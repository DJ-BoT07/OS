package Practice;
import java.util.*;

public class FIFO{
    public static void fifo(int[] pageRef, int numFrames){
        ArrayList<Integer> frames = new ArrayList<>(numFrames);
        int faults= 0;
        int hits = 0;

        for(int i = 0; i < pageRef.length; i++){
            int page = pageRef[i];
            if(frames.contains(page)){
                hits++;
            } else {
                if(frames.size() >= numFrames){
                    frames.remove(0);
                }
                frames.add(page);
                faults++;
            }
            System.out.println("Page " + page + ": Frames: " + frames);
        }
        System.out.println("Page Faults: " + faults);
        System.out.println("Page Hits: " + hits);
    }
    public static void main(String[] args){
        int[] pageRef = {1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5};
        int numFrames = 3;
        fifo(pageRef, numFrames);
    }
}