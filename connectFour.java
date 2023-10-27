import java.util.Scanner;

public class connectFour {
    private static final int ROWS = 6;
    private static final int COLUMNS = 7;
    private static final char EMPTY = ' ';
    private static char[][] board = new char[ROWS][COLUMNS];
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        initializeBoard();
        displayBoard();

        boolean gameWon = false;
        while (!gameWon) {
            int col = getPlayerMove();
            dropPiece(col);

            displayBoard();
            gameWon = checkForWin();
            if (gameWon) {
                System.out.println("Player " + currentPlayer + " wins!");
            } else if (isBoardFull()) {
                System.out.println("It's a draw!");
                break;
            }

            // Switch players
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    private static void initializeBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                board[row][col] = EMPTY;
            }
        }
    }

    private static void displayBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                System.out.print("| " + board[row][col] + " ");
            }
            System.out.println("|");
        }
        System.out.println("  1   2   3   4   5   6   7");
    }

    private static int getPlayerMove() {
        Scanner scanner = new Scanner(System.in);
        int col;
        while (true) {
            System.out.print("Player " + currentPlayer + ", enter column (1-7): ");
            if (scanner.hasNextInt()) {
                col = scanner.nextInt();
                if (col >= 1 && col <= 7 && board[0][col - 1] == EMPTY) {
                    break;
                }
            }
            System.out.println("Invalid move. Try again.");
            scanner.nextLine();
        }
        return col - 1;
    }

    private static void dropPiece(int col) {
        for (int row = ROWS - 1; row >= 0; row--) {
            if (board[row][col] == EMPTY) {
                board[row][col] = currentPlayer;
                break;
            }
        }
    }

    private static boolean checkForWin() {
      
        return false;
    }

    private static boolean isBoardFull() {
        for (int col = 0; col < COLUMNS; col++) {
            if (board[0][col] == EMPTY) {
                return false;
            }
        }
        return true;
    }
}