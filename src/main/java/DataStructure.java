public class DataStructure {
    int width, height;
    int [][] board;

    public DataStructure(int width, int height) {
        this.width = width;
        this.height = height;
        this.board = new int[width][height];
    }

    public void printBoard() {
         int y = 0;
        System.out.println("___");
        while (y < height) {
            int x = 0;
            String line = "/";
            while (x < width) {
                if (this.board[x][y] == 0) {
                    line += "+";
                } else {
                    line += "#";
                }
                x++;
            }
            y++;
            //line += "/";
            System.out.println(line);
        }
        System.out.println("___\n");
    }

    public void setAlive(int x, int y) {
        this.board[x][y] = 1;
    }

    public void setDead(int x, int y) {
        this.board[x][y] = 0;
    }

    public int countAliveNeighbours(int x, int y) {
        int count = 0;

        count =+ this.board[x - 1][y - 1];
        count =+ this.board[x - 1][y - 1];
        count =+ this.board[x - 1][y - 1];
        count =+ this.board[x - 1][y - 1];
        count =+ this.board[x - 1][y - 1];
        count =+ this.board[x - 1][y - 1];
        count =+ this.board[x - 1][y - 1];
        count =+ this.board[x - 1][y - 1];
        count =+ this.board[x - 1][y - 1];
        count =+ this.board[x - 1][y - 1];

        return count;
    }

    public void step() {
        
    }
}
