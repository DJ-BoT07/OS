    import java.util.*;

    public class LRUConsise {
        public static void lru(int[] pages, int frames) {
            LinkedList<Integer> frameList = new LinkedList<>();
            int faults = 0, hits = 0;

            for (int page : pages) {
                if (frameList.contains(page)) {
                    frameList.remove((Integer) page);
                    frameList.addLast(page);
                    hits++;
                } else {
                    if (frameList.size() >= frames) {
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
