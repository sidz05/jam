import java.util.Scanner;

public class BranchAndBoundAssignment {
    static int finalResult = Integer.MAX_VALUE;
    static int[] bestAssignment;

    static void branchAndBound(int[][] costMatrix, boolean[] assigned, int currentCost, int level, int[] assignment, int n) {
        if (level == n) {
            if (currentCost < finalResult) {
                finalResult = currentCost;
                System.arraycopy(assignment, 0, bestAssignment, 0, n);
            }
            return;
        }

        for (int j = 0; j < n; j++) {
            if (!assigned[j]) {
                assigned[j] = true;
                assignment[level] = j;
                int bound = currentCost + costMatrix[level][j];
                if (bound < finalResult) {
                    branchAndBound(costMatrix, assigned, bound, level + 1, assignment, n);
                }
                assigned[j] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students (and clubs): ");
        int n = sc.nextInt();

        int[][] costMatrix = new int[n][n];
        System.out.println("Enter the cost matrix row by row (space-separated values):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                costMatrix[i][j] = sc.nextInt();
            }
        }

        boolean[] assigned = new boolean[n];
        int[] assignment = new int[n];
        bestAssignment = new int[n];

        branchAndBound(costMatrix, assigned, 0, 0, assignment, n);

        System.out.println("The minimum assignment cost is: " + finalResult);
        System.out.println("Assignments:");
        for (int student = 0; student < n; student++) {
            System.out.println("Student " + (student + 1) + " -> Club " + (bestAssignment[student] + 1) +
                               " (cost " + costMatrix[student][bestAssignment[student]] + ")");
        }

        sc.close();
    }
}
