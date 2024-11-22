import java.util.*;

public class Ass2 {

    int id;
    int profit;
    int dead;

    Ass2(int idd, int d, int pro) {
        this.id = idd;
        this.profit = pro;
        this.dead = d;
    }

    public static void jobs(Vector<Ass2> arr, int n, int t) {

        Collections.sort(arr, (a, b) -> b.profit - a.profit);

        int maxprofit = 0;

        boolean slot[] = new boolean[t];
        for (int i = 0; i < t; i++) {
            slot[i] = false;
        }

        int result[] = new int[t];
        for (int i = 0; i < t; i++) {
            result[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            int min_deathline = Math.min(t, arr.get(i).dead);
            for (int j = min_deathline - 1; j >= 0; j--) {
                if (slot[j] == false) {
                    result[j] = arr.get(i).id;
                    slot[j] = true;
                    maxprofit += arr.get(i).profit;
                    break;
                }
            }
        }

        System.out.println("The Jobs are: ");
        for (int i = 0; i < t; i++) {
            System.out.println("Job:" + result[i]);
        }

        System.out.println("The Profit is: " + maxprofit);

    }

    public static void main(String[] args) {
        Vector<Ass2> arr = new Vector<>();
        arr.add(new Ass2(1, 3, 120));
        arr.add(new Ass2(2, 2, 20));
        arr.add(new Ass2(3, 3, 620));
        arr.add(new Ass2(4, 1, 220));
        arr.add(new Ass2(5, 2, 120));

        jobs(arr, 5, 3);

    }

}