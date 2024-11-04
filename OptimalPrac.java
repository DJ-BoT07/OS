package Practice;

import java.util.ArrayList;

public class OptimalPrac {
    public static void optimalFunc(int[] pages, int framesCount){
        ArrayList<Integer> frames = new ArrayList<>();
        int fault = 0; int hits = 0;
        for(int i = 0; i < pages.length; i++){
            int page = pages[i];
            if(frames.contains(page)){
                hits++;
            } else {
                if(frames.size() >= framesCount){
                    int indexToReplace = 0;
                    int maxFutureIndex = i + 1;
                    for(int j = 0; j < frames.size() ; j++){
                        int nextUse = pages.length;
                        for(int k = i + 1; k < pages.length; k++){
                            if(pages[k] == frames.get(j)){
                                nextUse = k;
                                break;
                            }
                        }
                        if(nextUse > maxFutureIndex){
                            maxFutureIndex = nextUse;
                            indexToReplace = j;
                        }
                    }
                    frames.set(indexToReplace, page);
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
        int[] pages = {1,2,3,4,1,2,5,1,2,3,4,5};
        int framesCount = 3;
        optimalFunc(pages, framesCount);
    }
}
