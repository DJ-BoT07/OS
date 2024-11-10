package Practice;
import java.util.*;

public class NextFitPrac{
    public static void nextFit(int[] blocks, int numBlocks, int[] processes, int numProcesses){
        int[] alloc = new int[numProcesses];
        Arrays.fill(alloc, -1);
        int lastBlock = 0;

        for(int i = 0; i < numProcesses; i++){
            int j = lastBlock;
            while(true){
                if(blocks[j] >= processes[i]){
                    alloc[i] = j;
                    blocks[j] -= processes[i];
                    lastBlock = j;
                    break;
                }
                j = (j + 1) % numBlocks;
                if(j == lastBlock) break;
            }
        }
        System.out.println("\nProcess No.\tProcess Size\tBlock no.");
        for(int i = 0; i < numProcesses; i++){
            System.out.println((i+1) + "\t\t" + processes[i] + "\t\t" + (alloc[i] + 1));
        }
    }

    public static void main(String[] args) {
        nextFit(new int[]{100, 500, 200, 300, 600}, 5, new int[]{212, 417, 112, 426}, 4);
    }
}
