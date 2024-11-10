package Practice;
import java.util.*;

public class Optimal2{
    public static void opt(int[]pageRef, int numFrames){
        ArrayList<Integer> frames = new ArrayList<>();
        int fault = 0;
        int hits = 0;
        for(int i = 0; i < pageRef.length; i++){
            int page = pageRef[i];
            if(frames.contains(page)){
                hits++;
            }else {
                if(frames.size() >= numFrames){
                    int nextToReplace = 0;
                    int maxFutureIndex = i + 1;
                    for(int j =0; j < frames.size(); j++){
                        int nextUse = pageRef.length;
                        for(int k = i + 1; k < pageRef.length; k++){
                            if(pageRef[k] == frames.get(j)){
                                nextUse = j;
                                break;
                            }
                        }
                        if(nextUse > maxFutureIndex){
                            maxFutureIndex = nextUse;
                            nextToReplace = j;
                        }
                    }
                    frames.set(nextToReplace, page);
                } else {
                    frames.add(page);
                }
                fault++;
            }
            System.out.println("Page " + page + ": Frames: " + frames);
        }
        System.out.println("Faults: " + fault);
        System.out.println("Hits: " + hits);
    }
    public static void main(String[] args){
        int[] pageRef = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0};
        opt(pageRef, 3);
    }
}