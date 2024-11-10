import java.util.*;

public class OptimalConsise {
    public static void main(String[] args) {
        int[] pageReferences = {1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5};
        int numFrames = 3;
        System.out.println("\nOptimal Page Replacement:");
        optimal_func(pageReferences, numFrames);
    }

    public static void optimal_func(int[] pages, int framesCount) {
        ArrayList<Integer> frames = new ArrayList<>(framesCount);
        int faults = 0, hits = 0;

        for (int i = 0; i < pages.length; i++) {
            int page = pages[i];
            if (frames.contains(page)) {
                hits++;
            } else {
                if (frames.size() < framesCount) {
                    frames.add(page);
                } else {
                    int farthestIndex = -1, replaceIndex = -1;
                    for (int j = 0; j < frames.size(); j++) {
                        int nextIndex = findNextOccurrence(pages, frames.get(j), i + 1);
                        if (nextIndex == -1) {
                            replaceIndex = j; break;
                        }
                        if (nextIndex > farthestIndex) {
                            farthestIndex = nextIndex; replaceIndex = j;
                        }
                    }
                    frames.set(replaceIndex, page);
                }
                faults++;
            }
            System.out.println("Page " + page + ": Frames: " + frames);
        }

        System.out.println("Page Faults: " + faults);
        System.out.println("Page Hits: " + hits);
    }

    public static int findNextOccurrence(int[] array, int target, int start) {
        for (int i = start; i < array.length; i++)
            if (array[i] == target) return i;
        return -1;
    }
}
