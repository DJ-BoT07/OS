package Practice;
import java.util.*;

public class Next2 {
    public static void nest(int[] blocks, int numBlocks, int[] processes, int numProcess){
        int[] allocation = new int[numProcess];
        Arrays.fill(allocation, -1);
        int lastBlock = 0;
        for(int i = 0; i < numProcess; i++){
            int j = lastBlock;
            while(true){
                if(blocks[j] >= processes[i]){
                    allocation[i] = j;
                    blocks[j] -= processes[i];
                    lastBlock = j;
                    break;
                }
                j = (j + 1) % numBlocks;
                if(j == lastBlock) break;
            }
        }
        System.out.println("\nProcess No.\tProcess Size\tBlock no.");
        for(int i = 0; i < numProcess; i++){
            System.out.println((i+1) + "\t\t" + processes[i] + "\t\t" + (allocation[i] + 1));
        }
    }   
    public static void main(String[] args) {
        nest(new int[]{100, 500, 200, 300, 600}, 5, new int[]{212, 417, 112, 426}, 4);
    } 
}
