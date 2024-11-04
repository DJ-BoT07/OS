package Practice;

import java.util.Arrays;
public class FirstFitPrac {
    public static void firstFit(int[] blocks, int numBlocks, int[] processes, int numProcesses){
        int[] alloc = new int[numProcesses];
        Arrays.fill(alloc, -1);

        for(int i = 0; i < numProcesses; i++){
            for(int j = 0; j < numBlocks; j++){
                if(blocks[j] >= processes[i]){
                    alloc[i] = j;
                    blocks[j] -= processes[i];
                    break;
                }
            }
        }
        System.out.println("\nProcess No.\tProcess Size\tBlock no.");
        for(int i = 0; i < numProcesses; i++){
            System.out.println((i+1) + "\t\t" + processes[i] + "\t\t" + (alloc[i] + 1));
        }
    }

    public static void main(String[] args) {
        int[] blocks = {100, 50, 30, 120, 35};
        int[] processes = {20, 60, 70, 40};
        firstFit(blocks, blocks.length, processes, processes.length);
    }
}
