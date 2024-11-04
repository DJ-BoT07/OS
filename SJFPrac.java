package Practice;

import java.util.Scanner;

public class SJFPrac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of processes: ");
        int n = sc.nextInt();
        int p[] = new int[n];
        int at[] = new int[n];
        int bt[] = new int[n];
        int ct[] = new int[n];
        int tat[] = new int[n];
        int wt[] = new int[n];

        for(int i = 0; i < n; i++) {
            p[i] = i+1;
            System.out.println("Enter arrival time for process " + (i+1) + ": ");
            at[i] = sc.nextInt();
            System.out.println("Enter burst time for process " + (i+1) + ": ");
            bt[i] = sc.nextInt();
        }

        int currentTime = 0;
        boolean completed[] = new boolean[n];
        int count = 0;
        while(count < n){
            int idx = -1;
            int minBt = Integer.MAX_VALUE;

            for(int i = 0; i < n; i++){
                if(at[i] <= currentTime && !completed[i] && bt[i] < minBt){
                    minBt = bt[i];
                    idx = i;
                }
            }

            if(idx != -1){
                currentTime += bt[idx];
                ct[idx] = currentTime;
                tat[idx] = ct[idx] - at[idx];
                wt[idx] = tat[idx] - bt[idx];
                completed[idx] = true;
                count++;
            } else {
                currentTime++;
            }
        }

        System.out.println("PID  Arrival  Burst  Complete  TurnAround  Waiting");
        float avgTat = 0, avgWt = 0;
        for(int i = 0; i < n; i++){
            avgTat += tat[i];
            avgWt += wt[i];
            System.out.printf("%d\t%d\t%d\t%d\t%d\t%d%n", p[i], at[i], bt[i], ct[i], tat[i], wt[i]);
        }       
        System.out.println("Average TurnAround Time: " + avgTat/n);
        System.out.println("Average Waiting Time: " + avgWt/n);
        sc.close();


    }
}
