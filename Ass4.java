import java.util.Scanner;

public class Ass4 {
    Scanner sc = new Scanner(System.in);

    public static int mindistance(int arr[], boolean visitedarr[], int V) {
        int min = Integer.MAX_VALUE;
        int min_index = -1;

        for (int i = 0; i < V; i++) {
            if (visitedarr[i] == false && arr[i] <= min) {
                min = arr[i];
                min_index = i;
            }
        }
        return min_index;
    }

    public static void singlepair(int graph[][], int src, int V) {

        int dist[] = new int[V];
        boolean visited[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        
        dist[src] = 0;

        for (int p = 0; p < V - 1; p++) {

            int u = mindistance(dist, visited, V);
            visited[u] = true;

            for (int v = 0; v < V; v++) {
                if (visited[v] == false && dist[v] > dist[u] + graph[u][v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }

        }

        System.out.println("The ans is: ");
        System.out.println();

        for (int i = 0; i < V; i++) {
            System.out.println(i + "-" + dist[i]);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Heyy Siddhesh");
        System.out.println("Enter the no. of vertices: ");
        int n = sc.nextInt();
        int arr[][] = new int[n][n];

        System.out.println("Enter the matrix elements: ");
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        singlepair(arr, 1, n);
        sc.close();

    }

}