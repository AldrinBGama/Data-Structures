public class DataStructs {
    int r, c;
    int [][] board = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
            { 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
    };

    public DataStructs(int r, int c) {
        this.r = r;
        this.c = c;
    }

    // all eight possible directions
    private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1,1}, {-1, -1}, {-1, 1}, {1, -1}};
    private static final int ALIVE = 1;
    private static final int DEAD = 0;
    private static final int DEADTOALIVE = 2;
    private static final int ALIVETODEAD = 3;

    public void gameOfLife(int[][] board) {
        // iterate through every cell in this 2D array
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                // keep track of the number of alive neighbors
                int alive = 0;

                // for each cell, check all possible 8 directions and count the number of alive neighbors
                for (int[] direction : directions) {
                    alive += isAlive(board, r + direction[0], c + direction[1]) ? 1 : 0;
                }

                // in case current cell is dead but has 3 live neighbors
                if (board[r][c] == DEAD) {
                    if (alive == 3) {
                        board[r][c] = DEADTOALIVE;
                    }
                }
                // in case current cell is alive
                else {
                    // in case, only 2 or 3 neighbors are alive
                    if (alive != 2 && alive != 3) {
                        board[r][c] = ALIVETODEAD;
                    }
                }
            }
        }

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == DEADTOALIVE) {
                    board[r][c] = ALIVE;
                    System.out.print("#");
                } else if (board[r][c] == ALIVETODEAD) {
                    board[r][c] = DEAD;
                    System.out.print("+");
                }
                System.out.println();
            }
        }
    }

    private boolean isAlive(int[][] board, int r, int c) {
        return r >= 0 && r < board.length && c >= 0 && c < board[0].length && (board[r][c] == ALIVE || board[r][c] == ALIVETODEAD);
    }

    public void printBoard() {
        System.out.println("Initial Generation");
        for (int i = 0; i < c; i++) {
            System.out.print("/");
            for (int j = 0; j < r; j++) {
                if (board[i][j] == 0)
                    System.out.print("+");
                else
                    System.out.print("#");
            }
            System.out.println();
        }
        System.out.println();
        gameOfLife(board);
    }
}
