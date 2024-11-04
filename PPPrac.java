package Practice;

import java.util.Scanner;

public class PPPrac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of process : ");
        int n = sc.nextInt();
        int at[] = new int[n];
        int bt[] = new int[n];
        int wt[] = new int[n];
        int ct[] = new int[n];
        int tat[] = new int[n];
        int P[] = new int[n];

        for(int i = 0; i < n; i++){
            System.out.print("Burst Time :"+ (i + 1) + " : ");
            bt[i] = sc.nextInt();
            System.out.print("Arrival Time :"+ (i + 1) + " : ");
            at[i] = sc.nextInt();
            System.out.print("priority :"+ (i + 1) + " : ");
            P[i] = sc.nextInt();
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(P[i] < P[j]){
                    int temp = P[i]; P[i] = P[j]; P[j] = temp;
                    temp = at[i]; at[i] = at[j]; at[j] = temp;
                    temp = bt[i]; bt[i] = bt[j]; bt[j] = temp;

                }
            }
        }

        ct[0] = bt[0] + at[0];
        tat[0] = ct[0] - at[0];
        wt[0] = tat[0] - bt[0];

        for(int i = 1; i < n; i++){
            ct[i] = ct[i - 1] + bt[i];
            tat[i] = ct[i] - at[i];
            wt[i] = tat[i] - bt[i];
        }

        System.out.println("Process\tArrival Time\tBurst Time\tPriority\tCompletion Time\tTurn Around Time\tWaiting Time");
        for(int i = 0; i < n; i++){
            System.out.println(i + 1 + "\t\t" + at[i] + "\t\t" + bt[i] + "\t\t" + P[i] + "\t\t" + ct[i] + "\t\t" + tat[i] + "\t\t" + wt[i]);
        }
        sc.close();
        
    }
}
