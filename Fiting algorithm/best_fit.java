import java.util.Arrays;

public class best_fit {
    public static void implimentBestFit(int[] blocks, int numBlocks, int[] processes, int numProcesses) {
        int[] allocation = new int[numProcesses];
        
        // Initialize all processes as unallocated (-1)
        Arrays.fill(allocation, -1);

        // Try all possible combinations of process-block allocations
        for (int i = 0; i < numProcesses; i++) {
            int minWaste = Integer.MAX_VALUE;
            int bestBlockIndex = -1;
            
            // Check every block for this process
            for (int j = 0; j < numBlocks; j++) {
                // If block can fit the process
                if (blocks[j] >= processes[i]) {
                    // Calculate wasted space if we use this block
                    int waste = blocks[j] - processes[i];
                    // Update if this gives less waste than previous best
                    if (waste < minWaste) {
                        minWaste = waste;
                        bestBlockIndex = j;
                    }
                }
            }
            
            // If we found a valid block
            if (bestBlockIndex != -1) {
                allocation[i] = bestBlockIndex;
                blocks[bestBlockIndex] -= processes[i]; // Reduce block size
            }
        }

        // Print results
        System.out.println("\nProcess No.\tProcess Size\tBlock no.");
        for (int i = 0; i < numProcesses; i++) {
            System.out.print((i + 1) + "\t\t" + processes[i] + "\t\t");
            if (allocation[i] != -1) {
                System.out.println((allocation[i] + 1));
            } else {
                System.out.println("Not Allocated");
            }
        }
    }

    public static void main(String[] args) {
        int[] blockSize = {1000, 30, 70, 80, 35};
        int[] processSize = {20, 60, 79, 40};
        implimentBestFit(blockSize.clone(), blockSize.length, processSize, processSize.length);
    }
}
