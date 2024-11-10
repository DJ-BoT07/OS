package Practice;
import java.util.*;

public class RRPrac{
    public static void main(String[] args) {
        int n = 4;
        int quantum = 2;
        int[] at = {0, 1, 2, 3};
        int[] bt = {5, 3, 4, 1};
        int[] ct = new int[n];
        int[] tat = new int[n];
        int[] wt = new int[n];
        float avgTat = 0, avgWt = 0;

        int time = 0;
        int rt[] = bt.clone();
        while(true){
            boolean done = true;
            for(int i = 0; i < n; i++){
                if(rt[i] > 0 && at[i] <= time){
                    done = false;
                    if(rt[i] > quantum){
                        rt[i] -= quantum;
                        time += quantum;
                    } else {
                        time += rt[i];
                        ct[i] = time;
                        tat[i] = ct[i] - at[i];
                        wt[i] = tat[i] - bt[i];
                        rt[i] = 0;
                    }
                }
            }
            if(done) break;
        }

        for(int i = 0; i < n; i++){
            avgTat += tat[i];
            avgWt += wt[i];
        }
        avgTat /= n;
        avgWt /= n;

        System.out.println("Process\tBurst Time\tArrival Time\tCompletion Time\tWaiting Time\tTurnaround Time");
        for(int i = 0; i < n; i++){
            System.out.println(i + "\t\t" + bt[i] + "\t\t" + at[i] + "\t\t" + ct[i] + "\t\t" + wt[i] + "\t\t" + tat[i]);
        }
        System.out.println("Average Waiting Time: " + avgWt);
        System.out.println("Average Turnaround Time: " + avgTat);
    }

}

