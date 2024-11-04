package Practice;

import java.util.Scanner;

public class FcfsPrac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of process: ");
        int n = sc.nextInt();
        int p[] = new int[n];
        int at[] = new int[n];
        int bt[] = new int[n];
        int ct[] = new int[n];
        int tat[] = new int[n];
        int wt[] = new int[n];
        float avgwt = 0, avgta = 0;

        for(int i = 0; i < n; i++){
            p[i] = i + 1;
            System.out.println("Enter arrival time for process " + (i+1) + ": ");
            at[i] = sc.nextInt();
            System.out.println("Enter burst time for process " + (i+1) + ": ");
            bt[i] = sc.nextInt();
        }

        for(int i = 0; i < n; i++){
            if(i == 0 || at[i] > ct[i - 1]){
                ct[i] = at[i] + bt[i];

            } else {
                ct[i] = ct[i - 1] + bt[i];
            }

            tat[i] = ct[i] - at[i];
            wt[i] = tat[i] - bt[i];
            avgwt += wt[i]; // total waiting time
            avgta += tat[i]; // to

        }

        System.out.println("\npid  arrival  brust  complete turn waiting");
        for (int i = 0; i < n; i++) {
            System.out.println(i+1 + "  \t " + at[i] + "\t" + bt[i] + "\t" + ct[i] + "\t" + tat[i] + "\t" + wt[i]);
        }
        sc.close();
        System.out.println("\naverage waiting time: " + (avgwt / n)); // printing average waiting time.
        System.out.println("average turnaround time:" + (avgta / n)); // printing average turnaround time.
    }
}
