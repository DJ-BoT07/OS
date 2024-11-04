package Practice;

import java.util.Arrays;

public class BestFitPrac {
    public static void bestFit(int[] blocks, int numBlocks, int[] processes, int numProcesses){
        int[] alloc = new int[numProcesses];
        Arrays.fill(alloc, -1);

        for(int i = 0; i < numProcesses; i++){
            int minWaste = Integer.MAX_VALUE;
            int bestBlockIndex = -1;
            
            for(int j = 0; j < numBlocks; j++){
                if(blocks[j] >= processes[i]){
                    int waste = blocks[j] - processes[i];
                    if(waste < minWaste){
                        minWaste = waste;
                        bestBlockIndex = j;
                    }
                }
            }

            if(bestBlockIndex != -1){
                alloc[i] = bestBlockIndex;
                blocks[bestBlockIndex] -= processes[i];
            }
        }

        System.out.println("\nProcess No.\tProcess Size\tBlock no.");
        for(int i = 0; i < numProcesses; i++){
            System.out.println((i+1) + "\t\t" + processes[i] + "\t\t" + (alloc[i] + 1));
        }
    }
    public static void main(String[] args) {
        int blocks[] = {150, 500, 200, 300, 600};
        int processes[] = {212, 417, 112, 426};
        bestFit(blocks, blocks.length, processes, processes.length);
    }
}
