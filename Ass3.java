import java.util.*;

public class Ass3 {
    public static void allpair(int graph[][], int V) {
        int dist[][] = new int[10][10];

        // taking input
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    dist[i][j] = Math.min(dist[i][j], (dist[i][k] + dist[k][j]));
                }
            }
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();

        }

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Heyy Siddhesh!!!");
        System.out.println();
        System.out.println("Enter the no. of vertices: ");
        int n = sc.nextInt();

        int arr[][] = new int[10][10];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        allpair(arr, n);
        sc.close();

    }

}