public class next_fit {


    static void implementNextFit(int blockSize[], int blocks, int processSize[], int processes) {
        // Array to store block allocation for each process
        int[] allocation = new int[processes];
        
        // Initialize all allocations to -1 (not allocated)
        for(int i = 0; i < processes; i++) {
            allocation[i] = -1;
        }
        
        // Keep track of last allocated block
        int lastBlock = 0;
        
        // For each process
        for(int i = 0; i < processes; i++) {
            // Start from last allocated block
            int j = lastBlock;
            
            // Search until we come back to starting point
            while(true) {
                // If block is big enough
                if(blockSize[j] >= processSize[i]) {
                    allocation[i] = j;
                    blockSize[j] -= processSize[i];
                    lastBlock = j;
                    break;
                }
                
                j = (j + 1) % blocks;
                
                // If we've searched all blocks
                if(j == lastBlock) {
                    break;
                }
            }
        }

        System.out.println("\nProcess No.\tProcess Size\tBlock no.");
        for (int i = 0; i < processes; i++) {
            System.out.print((i + 1) + "\t\t" + processSize[i] + "\t\t");
            System.out.println(allocation[i] != -1 ? (allocation[i] + 1) : "Not Allocated");
        }
    }

    public static void main(String[] args) {
        int blockSize[] = {100, 50, 30, 120, 35};
        int processSize[] = {20, 60, 70, 40};
        int m = blockSize.length;
        int n = processSize.length;
            implementNextFit(blockSize, m, processSize, n);
    }
}
