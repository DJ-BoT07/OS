import java.util.Arrays;

public class worst_fit {
    static void implimentWorstFit(int[] blocks, int numBlocks, int[] processes, int numProcesses) {
        int[] alloc = new int[numProcesses];
        Arrays.fill(alloc, -1);

        for(int i = 0; i < numProcesses; i++) {
            int maxWaste = -1;
            int worstBlockIndex = -1;
            
            for(int j = 0; j < numBlocks; j++) {
                if(blocks[j] >= processes[i]) {
                    int waste = blocks[j] - processes[i];
                    if(waste > maxWaste) {
                        maxWaste = waste;
                        worstBlockIndex = j;
                    }
                }
            }

            if(worstBlockIndex != -1) {
                alloc[i] = worstBlockIndex;
                blocks[worstBlockIndex] -= processes[i];
            }
        }

        System.out.println("\nProcess No.\tProcess Size\tBlock no.");
        for(int i = 0; i < numProcesses; i++) {
            System.out.println((i+1) + "\t\t" + processes[i] + "\t\t" + 
                (alloc[i] != -1 ? (alloc[i] + 1) : "Not Allocated"));
        }
    }

    public static void main(String[] args) {
        int[] blocks = {100, 300, 500};
        int[] processes = {122, 70, 280};
        implimentWorstFit(blocks, blocks.length, processes, processes.length);
    }
}
