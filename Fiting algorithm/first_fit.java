//! FIRST FIT ALGORITHM
/*
 * memory is divided into blocks. it can be divided into fix or variable size blocks.
 * First block is assigned to the OS.
 * We scan the memory from start, where we find the first hole assign the memory to that process if size of process is <= block size
 */

import java.util.Arrays;

class first_fit
{
    

    public static void implimentFirstFit(int blockSize[], int blocks, int processSize[], int processes) {
        // Array to store block allocation for each process
        int[] allocation = new int[processes];
        
        // Initialize all allocations to -1 (not allocated)
        Arrays.fill(allocation, -1);
        
        // For each process, find first block that fits
        for(int i = 0; i < processes; i++) {
            for(int j = 0; j < blocks; j++) {
                if(blockSize[j] >= processSize[i]) {
                    allocation[i] = j;
                    blockSize[j] -= processSize[i];
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

    public static void main (String[]args)
    {

        int blockSize[] = {100, 50, 30, 120, 35};
        int processSize[] = {20, 60, 70, 40};
        int m = blockSize.length;
        int n = processSize.length;
        implimentFirstFit(blockSize, m, processSize, n);
    }
}