import java.util.Arrays;
import java.util.Scanner;

public class TicTacToeOne {

    public static void main(String[] args) {
        TicTacToeOne one = new TicTacToeOne();
        TicTacToe ticTacToe = one.new TicTacToe();
        Scanner scanner = new Scanner(System.in);
        int x = 0, y = 0;
        do {
            System.out.println(TicTacToe.X == ticTacToe.getCurrentPlayer() ? "Player 1(X) enter move : " : "Player 2(O) enter move :");
            System.out.println("Enter x and y places");
            x = scanner.nextInt();
            y = scanner.nextInt();

            ticTacToe.playMove(x, y);

            System.out.println(ticTacToe);
            System.out.println("_________________________");

        } while (ticTacToe.isEmpty());

    }

    private class TicTacToe {
        public final static int X = 1, O = -1, EMPTY = 0;
        private int currentPlayer = X;
        private int[][] board = new int[3][3];
        private boolean isEmpty = true;
        private boolean isWinningMove = false;

        public int getCurrentPlayer() {
            return currentPlayer;
        }

        public void playMove(int x, int y) {
            if (x < 0 || x > 2 || y < 0 || y > 2) {
                System.out.println("Invalid board position");
                return;
            }
            if (board[x][y] != EMPTY) {
                System.out.println("Board position occupied");
                return;
            }

            board[x][y] = currentPlayer;
            isWinningMove = checkIfWinningMove();
            if(isWinningMove) {
                System.out.format("%s has won the game \n", X == currentPlayer ? "Player 1" : "Player 2" );
                isEmpty = false;
                return;
            }
            currentPlayer = -currentPlayer;
        }

        private boolean checkIfWinningMove() {
            if (isWin(X)) {
                System.out.println("\n X wins...!!");
                return true;
            } else if (isWin(O)) {
                System.out.println("\n O wins...!!");
                return true;
            } else {
                if (!isEmpty) {
                    System.out.println("its a tie");
                }
                return false;
            }
        }

        private boolean isWin(int player) {
            return ((board[0][0] + board[0][1] + board[0][2] == player * 3) ||
                    (board[1][0] + board[1][1] + board[1][2] == player * 3) ||
                    (board[2][0] + board[2][1] + board[2][2] == player * 3) ||
                    (board[0][0] + board[1][0] + board[2][0] == player * 3) ||
                    (board[0][1] + board[1][1] + board[2][1] == player * 3) ||
                    (board[0][2] + board[1][2] + board[2][2] == player * 3) ||
                    (board[0][0] + board[1][1] + board[2][2] == player * 3) ||
                    (board[2][0] + board[1][1] + board[0][2] == player * 3));
        }

        public boolean isEmpty() {
            return isEmpty;
        }

        @Override
        public String toString() {
            StringBuilder s = new StringBuilder();
            isEmpty = false;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    switch (board[i][j]) {
                        case X:
                            s.append(" X ");
                            break;
                        case O:
                            s.append(" O ");
                            break;
                        case EMPTY:
                            s.append("   ");
                            isEmpty = true;
                            break;
                    }
                    if (j < 2) {
                        s.append("|");
                    }

                }
                if (i < 2) {
                    s.append("\n-----------\n");
                }
            }
            isEmpty = isWinningMove ? false : isEmpty;
            return s.toString();
        }
    }
}




