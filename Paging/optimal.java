import java.util.*;

public class optimal {
    public static void optimal_func(int[] pageReferences, int numFrames) {
        ArrayList<Integer> frames = new ArrayList<>(numFrames);
        int pageFaults = 0;
        int pageHits = 0;

        // Iterate through each page reference
        for(int i = 0; i < pageReferences.length; i++) {
            int page = pageReferences[i];
            
            // Check if page is already in frames (cache hit)
            if(frames.contains(page)) {
                pageHits++;
            } else {
                // Page fault occurred
                if(frames.size() >= numFrames) {
                    // Need to replace a page since frames are full
                    int indexToReplace = 0;
                    int maxFutureIndex = i + 1;
                    
                    // For each frame, find when its page will be used next
                    for(int j = 0; j < frames.size(); j++) {
                        // Default to end of references if page won't be used again
                        int nextUse = pageReferences.length; 
                        
                        // Search future references to find next use of this frame's page
                        for(int k = i + 1; k < pageReferences.length; k++) {
                            if(pageReferences[k] == frames.get(j)) {
                                nextUse = k;
                                break;
                            }
                        }
                        
                        // Replace the page that will be used furthest in the future
                        // This is the optimal page to remove since it won't be needed for longest
                        if(nextUse > maxFutureIndex) {
                            maxFutureIndex = nextUse;
                            indexToReplace = j;
                        }
                    }
                    // Replace the selected page with new page
                    frames.set(indexToReplace, page);
                } else {
                    // Frames not full yet, just add the new page
                    frames.add(page);
                }
                pageFaults++;
            }
            
            // Print current state after handling this page
            System.out.println("Page " + page + ": Frames: " + frames);
        }

        // Print final statistics
        System.out.println("Page Faults: " + pageFaults);
        System.out.println("Page Hits: " + pageHits);
    }

    public static void main(String[] args) {
        int pageReferences[] = {1,2,3,4,1,2,5,1,2,3,4,5};
        int numFrames = 3;

        System.out.println("\nOptimal Page Replacement:");
        optimal_func(pageReferences, numFrames);
    }
}
