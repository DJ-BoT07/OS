import java.util.Scanner;

public class RoundRobin {
    private static final int[] bt = {24, 3, 3};  // Burst times
    private static final int n = bt.length;      // Number of processes
    private static final int quantum = 4;        // Time quantum
    
    public static void main(String[] args) {
        int[] wt = new int[n];
        int[] tat = new int[n];
        int[] rt = new int[n].clone();
        
        // Initialize remaining times
        for(int i = 0; i < n; i++) {
            rt[i] = bt[i];
        }
        
        int time = 0;
        while(true) {
            boolean done = true;
            for(int i = 0; i < n; i++) {
                if(rt[i] > 0) {
                    done = false;
                    if(rt[i] > quantum) {
                        time += quantum;
                        rt[i] -= quantum;
                    }
                    else {
                        time += rt[i];
                        wt[i] = time - bt[i];
                        rt[i] = 0;
                        tat[i] = time;
                    }
                }
            }
            if(done) break;
        }

        System.out.println("\nProcess\tBT\tWT\tTAT");
        float avgWt = 0, avgTat = 0;
        for(int i = 0; i < n; i++) {
            avgWt += wt[i];
            avgTat += tat[i];
            System.out.println("P" + (i+1) + "\t" + bt[i] + "\t" + wt[i] + "\t" + tat[i]);
        }
        
        System.out.println("\nAverage Waiting Time: " + avgWt/n);
        System.out.println("Average Turnaround Time: " + avgTat/n);
    }
}
