package Practice;

import java.util.LinkedList;

public class LRUPrac {
    public static void lru(int[] pageRef, int numFrames) {
        LinkedList<Integer> frameList = new LinkedList<>();
        int faults = 0, hits = 0;
        for(int page: pageRef){
            if(frameList.contains(page)){
                frameList.remove((Integer) page);
                frameList.addLast(page);
                hits++;
            } else{
                if(frameList.size() >= numFrames){
                    frameList.removeFirst();

                } 
                frameList.addLast(page);
                faults++;
            }
            System.out.println("Page " + page + ": " + frameList);
        }
        System.out.println("Faults: " + faults + ", Hits: " + hits);
    }

    public static void main(String[] args) {
        lru(new int[]{2, 1, 2, 4, 7, 3, 4, 3, 5, 2}, 3);
    }
}
