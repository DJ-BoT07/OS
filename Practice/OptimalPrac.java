package Practice;
import java.util.*;

public class OptimalPrac{
    public static void opt(int[] pageReferences, int numFrames){
        ArrayList<Integer> frames = new ArrayList<>();
        int pageFaults = 0;
        int pageHits = 0;

        for(int i = 0; i < pageReferences.length; i++){
            int page = pageReferences[i];
            if(frames.contains(page)){
                pageHits++;
            } else {
                if(frames.size() >= numFrames){
                    int nextToReplace = 0;
                    int maxFutureIndex = i + 1;
                    for(int j = 0; j < frames.size(); j++){
                        int nextUse = pageReferences.length;
                        for(int k = i + 1; k < pageReferences.length; k++){
                            if(pageReferences[k] == frames.get(j)){
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
                pageFaults++;

            }
            System.out.println("Page " + page + ": Frames: " + frames);

        }
    }
}


