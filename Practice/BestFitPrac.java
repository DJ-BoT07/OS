package Practice;
 import java.util.*;

 public class BestFitPrac{
    public static void best(int[] blocks, int numBlocks, int[] process, int numProcess){
        int[] allocation = new int[numProcess];
        Arrays.fill(allocation, -1);

        for(int i = 0; i < numProcess; i++){
            int minWaste = Integer.MAX_VALUE;
            int bestBlockIndex = -1;
            for(int j = 0; j < numBlocks; j++){
                if(blocks[j] >= process[i]){
                    int waste = blocks[j] - process[i];
                    if(waste < minWaste){
                        minWaste = waste;
                        bestBlockIndex = j;
                    }
                }
            }
            if(bestBlockIndex != -1){
                allocation[i] = bestBlockIndex;
                blocks[bestBlockIndex] -= process[i];
            }
        }

        for(int i = 0; i < numProcess; i++){
            System.out.println("Process " + (i + 1) + " is allocated to block " + (allocation[i] + 1) + " with size " + process[i]);
        }
    }
    public static void main(String[] args) {
        int[] blocks = {100, 500, 200, 300, 600};
        int[] process = {212, 417, 112, 426};
        best(blocks, 5, process, 4);
    }

 }
