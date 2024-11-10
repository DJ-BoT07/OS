import java.util.Arrays;

public class Least_Recently_Used {

    public static void lru(int[] pageReferences, int numFrames) {
        int[] frames = new int[numFrames];
        int[] accessCounter = new int[numFrames];
        int pageFaults = 0;
        int pageHits = 0;

        for(int i=0;i<numFrames;i++){
            accessCounter[i]=-1;
            frames[i]=-1;
        }
        for (int i = 0; i < pageReferences.length; i++) {
            int page = pageReferences[i];
            boolean pageFound = false;

            for (int j = 0; j < numFrames; j++) {
                if (frames[j] == page) {
                    pageFound = true;
                    pageHits++;
                    accessCounter[j] = i;
                    break;
                }
            }

            if (!pageFound) {
                int index = 0;
                for (int j = 1; j < numFrames; j++) {
                    if (accessCounter[j] < accessCounter[index]) {
                        index = j;
                    }
                }
                frames[index] = page;
                accessCounter[index] = i;
                pageFaults++;
            }
            System.out.println("Page " + page + ": Frames: " + Arrays.toString(frames) + " :Accesscounter: "+Arrays.toString(accessCounter));
        }
        System.out.println("Page Faults: " + pageFaults);
        System.out.println("Page Hits: " + pageHits);
    }
    public static void main(String[] args) {
        int[] pageReferences = {2,1,2,4,7,3,4,3,5,2}; // Example page reference sequence
        int numFrames = 3;

        System.out.println("\nLRU Page Replacement:");
        lru(pageReferences, numFrames);
    }
}
