package Practice;

public class SJFPrac{
    public static void main(String[] args) {
        int n = 4;
        int[] at = {0, 1, 2, 3};
        int[] bt = {5, 3, 4, 1};
        int[] ct = new int[n];
        int[] tat = new int[n];
        int[] wt = new int[n];
        float avgTat = 0, avgWt = 0;

        int currentTime = 0;
        boolean completed[] = new boolean[n];
        int[] rt = bt.clone();

        int count = 0;
        while(count < n){
            int idx = -1;
            int minBT = Integer.MAX_VALUE;
            for(int i = 0; i < n; i++){
                if(at[i] <= currentTime && !completed[i] && bt[i] < minBT){
                    minBT = bt[i];
                    idx = i;
                }
            }

            if(idx != -1){
                currentTime += bt[idx];
                ct[idx] = currentTime;
                tat[idx] = ct[idx] - at[idx];
                wt[idx] = tat[idx] - bt[idx];
                avgTat += tat[idx];
                avgWt += wt[idx];
                completed[idx] = true;
                count++;
            }
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
