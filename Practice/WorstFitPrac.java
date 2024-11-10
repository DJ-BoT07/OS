package Practice;

import java.util.Arrays;

public class WorstFitPrac {
    public static void worstFit(int[] blocks, int numBlocks, int[] processes, int numProcesses){
        int[] alloc = new int[numProcesses];
        Arrays.fill(alloc, -1);

        for(int i = 0; i < numProcesses; i++){
            int maxWaste = -1;
            int worstBlockIndex = -1;

            for(int j = 0; j < numBlocks; j++){
                if(blocks[j] >= processes[i]){
                    int waste = blocks[j] - processes[i];
                    if(waste > maxWaste){
                        maxWaste = waste;
                        worstBlockIndex = j;
                    }
                }
            }

            if(worstBlockIndex != -1){
                alloc[i] = worstBlockIndex;
                blocks[worstBlockIndex] -= processes[i];
            }
        }

        System.out.println("\nProcess No.\tProcess Size\tBlock no.");
        for(int i = 0; i < numProcesses; i++){
            System.out.println((i+1) + "\t\t" + processes[i] + "\t\t" + (alloc[i] + 1));
        }
    }

    public static void main(String[] args) {
        worstFit(new int[]{100, 500, 200, 300, 600}, 5, new int[]{212, 417, 112, 426}, 4);
    }
}
