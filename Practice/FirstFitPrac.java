package Practice;
import java.util.*;

public class FirstFitPrac{
    public static void first(int[] blocks, int numBlocks, int[] process, int numProcess){
        int[] allocation = new int[numProcess];
        Arrays.fill(allocation, -1);

        for(int i = 0; i < numProcess; i++){
            for(int j = 0; j < numBlocks; j++){
              if(blocks[j] >= process[i]){
                    allocation[i] = j;
                    blocks[j] -= process[i];
                    break;
                }  
            }
        }

        for(int i = 0; i < numProcess; i++){
            System.out.println("Process " + (i+1) + " is allocated to block " + (allocation[i]+1) + " process size is " + process[i]);
        }
        
    }

    public static void main(String[] args) {
        int[] blocks = {100, 50, 30, 120, 35};
        int[] process = {20, 60, 70, 40};
        first(blocks, blocks.length, process, process.length);
    }
}
