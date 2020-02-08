public class Main {
    public static void main(String[] args) {
        DataStructure dataStructure = new DataStructure(10, 10);
        dataStructure.setAlive(2, 2);
        dataStructure.setAlive(3, 2);
        dataStructure.setAlive(4, 2);
        dataStructure.setAlive(5, 3);

        dataStructure.printBoard();
    }
}
