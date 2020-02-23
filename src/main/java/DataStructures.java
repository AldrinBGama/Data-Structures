public class DataStructures {
    int width, height;
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

    public DataStructures(int width, int height) {
        this.width = width;
        this.height = height;
    }
    // Function to print next generation
    static void nextGeneration(int board[][], int height, int width) {
        int[][] future = new int[height][width];
        // Loop through every cell
        int l = 1;
        while (l < height - 1) {
            int m = 1;
            while (m < width - 1) {
                // finding no Of Neighbours that are alive
                int aliveNeighbours = 0;
                int i = -1;
                while (i <= 1) {
                    int j = -1;
                    while (j <= 1){
                        aliveNeighbours += board[l + i][m + j];
                        j++;
                    }
                    i++;
                }
                // The cell needs to be subtracted from its neighbours as it was counted before.
                aliveNeighbours -= board[l][m];

                // Implementing the Rules of Life

                // Cell is lonely and dies
                if ((board[l][m] == 1) && (aliveNeighbours < 2))
                    future[l][m] = 0;

                    // Cell dies due to over population
                else if ((board[l][m] == 1) && (aliveNeighbours > 3))
                    future[l][m] = 0;

                    // A new cell is born
                else if ((board[l][m] == 0) && (aliveNeighbours == 3))
                    future[l][m] = 1;

                    // Remains the same
                else
                    future[l][m] = board[l][m];
                m++;
            }
            l++;
        }

        System.out.println("Next Generation");
        for (int i = 0; i < height; i++) {
            System.out.print("/");
            for (int j = 0; j < width; j++) {
                if (future[i][j] == 0)
                    System.out.print("+");
                else
                    System.out.print("#");
            }
            System.out.println();
        }
    }

    public void printBoard() {
        System.out.println("Initial Generation");
        for (int i = 0; i < height; i++) {
            System.out.print("/");
            for (int j = 0; j < width; j++) {
                if (board[i][j] == 0)
                    System.out.print("+");
                else
                    System.out.print("#");
            }
            System.out.println();
        }
        System.out.println();
        nextGeneration(board, height, width);
    }
}


