import java.util.Scanner;


public class prioritypeermitive {
    public static void main(String[] args) {
        int n, BT[], WT[], TAT[], CT[], AT[], P[], temp;
        String process[];
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of processes: ");
        n = sc.nextInt();
        BT = new int[n];// burst time array
        WT = new int[n]; // waiting time for each process
        TAT = new int[n]; // turn around time
        CT = new int[n]; // compilation time
        AT = new int[n]; // arrival time
        P = new int[n]; // priority
        process = new String[n]; // process names

        for (int i = 0; i < n; i++) {
            System.out.println("\nProcess " + (i + 1) + " name: ");
            process[i] = sc.next();
            System.out.print("Burst Time :");
            BT[i] = sc.nextInt();
            System.out.print("Arrival Time :");
            AT[i] = sc.nextInt();
            System.out.print("priority :");
            P[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (P[i] < P[j]) {
                    // Swap all values between i and j
                    temp = P[i]; P[i] = P[j]; P[j] = temp;
                    String a = process[i]; process[i] = process[j]; process[j] = a;
                    int t = AT[i]; AT[i] = AT[j]; AT[j] = t;
                    int b = BT[i]; BT[i] = BT[j]; BT[j] = b;
                }
            }
        }

        CT[0] = BT[0] + AT[0];
        TAT[0] = CT[0] - AT[0]; 
        WT[0] = TAT[0] - BT[0];
        
        for(int k = 1; k < n; k++) {
            CT[k] = CT[k-1] + BT[k];
            TAT[k] = CT[k] - AT[k];
            WT[k] = TAT[k] - BT[k];
        }

        // diplay
        System.out.println("\nprocess  arrival  brust  priority   compilation   waiting   turn around");
        for (int i = 0; i < n; i++) {
            System.out.println(process[i] + "  \t " + AT[i] + "\t" + BT[i] + "\t" + P[i] + "\t" + CT[i] + "\t" + WT[i]
                    + "\t" + TAT[i]);
        }

    }
}
