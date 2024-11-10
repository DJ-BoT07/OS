import java.util.*;

public class shortest_job_first {
    private static final int[] at = {0, 1, 2, 4}; // Arrival times
    private static final int[] bt = {5, 3, 4, 1}; // Burst times
    private static final int n = at.length;       // Number of processes
    
    public static void main(String[] args) {
        int[] pid = new int[n];
        int[] ct = new int[n];
        int[] tat = new int[n];
        int[] wt = new int[n];
        
        for (int i = 0; i < n; i++) {
            pid[i] = i + 1;
        }

        int currentTime = 0;
        boolean completed[] = new boolean[n];
        int[] remainingTime = new int[n];
        System.arraycopy(bt, 0, remainingTime, 0, n);

        int count = 0;
        while(count < n){
            int idx = -1;
            int minRt = Integer.MAX_VALUE;
            for(int i = 0; i < n; i++){
                if(at[i] <= currentTime && !completed[i] && remainingTime[i] < minRt){
                    minRt = remainingTime[i];
                    idx = i;
                }
            }

            if(idx != -1){
                remainingTime[idx]--;
                currentTime++;
                
                if (remainingTime[idx] == 0) {
                    ct[idx] = currentTime;
                    tat[idx] = ct[idx] - at[idx];
                    wt[idx] = tat[idx] - bt[idx];
                    completed[idx] = true;
                    count++;
                }
            } else {
                currentTime++;
            }
        }

        System.out.println("\nPID  Arrival  Burst  Complete  TurnAround  Waiting");
        float avgTat = 0, avgWt = 0;
        for (int i = 0; i < n; i++) {
            avgTat += tat[i];
            avgWt += wt[i];
            System.out.printf("%d\t%d\t%d\t%d\t%d\t%d%n", pid[i], at[i], bt[i], ct[i], tat[i], wt[i]);
        }

        System.out.printf("\nAverage Turnaround Time: %.2f%n", avgTat / n);
        System.out.printf("Average Waiting Time: %.2f%n", avgWt / n);
    }
}
