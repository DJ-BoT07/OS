/*Enter the number of processes:
4
enter the arrival time of 1 : 
0
enter the burst time of 1 : 
5
enter the arrival time of 2 : 
1
enter the burst time of 2 : 
3
enter the arrival time of 3 : 
2
enter the burst time of 3 : 
4
enter the arrival time of 4 : 
4
enter the burst time of 4 :
1
pid  arrival  burst  complete turn waiting
1       0       5       9       9       4
2       1       3       4       3       0
3       2       4       13      11      7
4       4       1       5       1       0

average tat is 6.0
average wt is 2.75*/ 

import java.util.Scanner;


public class sjf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of processes: ");
        int n = sc.nextInt();
        int processID[] = new int[n];
        int arrivalTime[] = new int[n];
        int burstTime[] = new int[n];
        int completionTime[] = new int[n];
        int turnaroundTime[] = new int[n];
        int waitingTime[] = new int[n];
        int flag[] = new int[n];
        int remainingTime[] = new int[n];

        int currentTime = 0;
        int totalProcesses = 0;

        float avgWaitingTime = 0, avgTurnaroundTime = 0;

        for (int i = 0; i < n; i++) {
            processID[i] = i + 1;
            System.out.println("Enter the arrival time of process " + processID[i] + ": ");
            arrivalTime[i] = sc.nextInt();
            System.out.println("Enter the burst time of process " + processID[i] + ": ");
            burstTime[i] = sc.nextInt();
            remainingTime[i] = burstTime[i];
            flag[i] = 0;
        }

        while (true) {
            int minBurstTime = Integer.MAX_VALUE;
            int currentProcess = n;

            if (totalProcesses == n) {
                break;
            }

            for (int j = 0; j < n; j++) {
                if (arrivalTime[j] <= currentTime && flag[j] == 0 && remainingTime[j] < minBurstTime) {
                    minBurstTime = remainingTime[j];
                    currentProcess = j;
                }
            }

            if (currentProcess == n) {
                currentTime++;
            } else {
                remainingTime[currentProcess]--;
                currentTime++;

                if (remainingTime[currentProcess] == 0) {
                    flag[currentProcess] = 1;
                    completionTime[currentProcess] = currentTime;
                    totalProcesses++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            turnaroundTime[i] = completionTime[i] - arrivalTime[i];
            waitingTime[i] = turnaroundTime[i] - burstTime[i];
            avgWaitingTime += waitingTime[i];
            avgTurnaroundTime += turnaroundTime[i];
        }

        System.out.println("Process  Arrival  Burst  Completion  Turnaround  Waiting");
        for (int i = 0; i < n; i++) {
            System.out.println(processID[i] + "\t" + arrivalTime[i] + "\t" + burstTime[i] + "\t" +
                    completionTime[i] + "\t" + turnaroundTime[i] + "\t" + waitingTime[i]);
        }

        System.out.println("\nAverage Turnaround Time: " + (float) (avgTurnaroundTime / n));
        System.out.println("Average Waiting Time: " + (float) (avgWaitingTime / n));

        sc.close();
    }
}
