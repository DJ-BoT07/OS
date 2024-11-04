package Practice;

import java.util.Scanner;

public class RRPrac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int bt[] = new int[n];
        int wt[] = new int[n];
        int tat[] = new int[n];
        int rt[] = new int[n];

        for(int i = 0; i < n; i++){
            System.out.print("Enter burst time for P" + (i+1) + ": ");
            bt[i] = sc.nextInt();
            rt[i] = bt[i];
        }

        System.out.print("Enter time quantum: ");
        int quantum = sc.nextInt();

        int time = 0;
        while(true){
            boolean done  = true;
            for(int i = 0; i < n ; i++){
                if(rt[i] > 0){
                    done = false;
                    if(rt[i] > quantum){
                        rt[i] -= quantum;
                        time += quantum;
                    } else {
                        time += rt[i];
                        wt[i] = time - bt[i];
                        rt[i] = 0;
                        tat[i] = wt[i] + bt[i];
                    }
                }
            }
            if(done) break;
        }

        System.out.println("\nProcess\tBT\tWT\tTAT");
        float avgWt = 0, avgTat = 0;
        for(int i = 0; i < n; i++){
            avgWt += wt[i];
            avgTat += tat[i];
            System.out.println("P" + (i+1) + "\t" + bt[i] + "\t" + wt[i] + "\t" + tat[i]);
        }
    }
}
