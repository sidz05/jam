import java.util.Scanner;

public class Ass5 {

    static int xmove[] = { 2, 2, -2, -2, 1, 1, -1, -1 };
    static int ymove[] = { 1, -1, 1, -1, 2, -2, 2, -2 };
    static int board[][];

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of board: ");
        int n = sc.nextInt();

        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = -1;
            }
        }

        System.out.println("Enter the starting position: ");
        int startX = sc.nextInt();
        int starty = sc.nextInt();

        // Validate starting position
        if (startX < 0 || startX >= n || starty < 0 || starty >= n) {
            System.out.println("Invalid starting position. Please provide coordinates within the board.");
            sc.close();
            return;
        }

        board[startX][starty] = 0;

        if (knight(startX, starty, 1)) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(board[i][j] + "   ");
                }
                System.out.println();
            }
        } else {
            System.out.println("No solution exists for the given starting position.");
        }

        sc.close();
    }

    public static boolean valid(int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board.length && board[x][y] == -1;
    }

    public static boolean knight(int currX, int currY, int movecount) {
        if (movecount == board.length * board.length) {
            return true;
        }

        for (int i = 0; i < 8; i++) {
            int nextmoveX = currX + xmove[i];
            int nextmoveY = currY + ymove[i];

            if (valid(nextmoveX, nextmoveY)) {
                board[nextmoveX][nextmoveY] = movecount;

                if (knight(nextmoveX, nextmoveY, movecount + 1)) {
                    return true;
                }

                // Backtrack
                board[nextmoveX][nextmoveY] = -1;
            }
        }

        return false;
    }
}
