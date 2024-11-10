package Practice;
import java.util.*;

public class Priority{
    public static void main(String[] args){
        int n = 4;
        int[] at = {0, 1, 2, 4};
        int[] bt = {5, 3, 4, 1};
        int[] pt = {3, 1, 4, 2};
        int[] ct = new int[n];
        int[] tat = new int[n];
        int[] wt = new int[n];
        float avgT = 0, avgW = 0;

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(pt[i] < pt[j]){
                    int temp = pt[i];
                    pt[i] = pt[j];
                    pt[j] = temp;

                    temp = at[i];
                    at[i] = at[j];
                    at[j] = temp;

                    temp = bt[i];
                    bt[i] = bt[j];
                    bt[j] = temp;
                }
            }
        }

        for(int i = 0; i < n; i++){
            if(i == 0 || at[i] > ct[i - 1]){
                ct[i] = at[i] + bt[i];
            } else {
                ct[i] = ct[i - 1] + bt[i];
            }
            tat[i] = ct[i] - at[i];
            wt[i] = tat[i] - bt[i];
            avgT += tat[i];
            avgW += wt[i];
        }
        avgT /= n;
        avgW /= n;

        System.out.println("Process\tArrival Time\tBurst Time\tPriority\tCompletion Time\tTurnaround Time\tWaiting Time");
        for(int i = 0; i < n; i++){
            System.out.println(i + "\t\t" + at[i] + "\t\t" + bt[i] + "\t\t" + pt[i] + "\t\t" + ct[i] + "\t\t" + tat[i] + "\t\t" + wt[i]);
        }
        System.out.println("Average Turnaround Time: " + avgT);
        System.out.println("Average Waiting Time: " + avgW);
    }
}