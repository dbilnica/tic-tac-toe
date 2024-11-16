import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] matrix2D = new char[3][3];
        for (int i = 0; i < matrix2D.length; i++) {
            for (int j = 0; j < matrix2D.length; j++) {
                matrix2D[i][j] = ' ';
            }
        }
        boolean player1, player2, ended = false;
        String player1Name, player2Name;
        char player1Symbol = 'X';
        char player2Symbol = 'O';
        Scanner scanner = new Scanner(System.in);
        int row, col = 0;
        System.out.println("Enter first player name: ");
        player1Name = scanner.nextLine();
        System.out.println("Player " + player1Name + " has been setted symbol 'X'");
        System.out.println("Enter second player name: ");
        player2Name = scanner.nextLine();
        System.out.println("Player " + player2Name + " has been setted symbol '0'");
        printMatrix(matrix2D);
        System.out.println("Enter row in matrix");
        row = scanner.nextInt();
        System.out.println("Enter column in matrix");
        col = scanner.nextInt();
        while (ended == false) {
            if (row < (matrix2D.length + 1) && col < (matrix2D.length + 1)) {
                matrix2D[row - 1][col - 1] = 'X';
                printMatrix(matrix2D);
                ended = true;
            }

        }

    }

    public static void printMatrix(char[][] matrix2D) {
        for (int i = 0; i < matrix2D.length; i++) {
            for (int j = 0; j < matrix2D.length; j++) {
                if (j == 1) {
                    System.out.print("| " + matrix2D[i][j] + " |");
                } else {
                    System.out.print(" " + matrix2D[i][j] + " ");
                }

            }
            if(i < matrix2D.length -1) {
                System.out.println("\n" + " - + - + -");
            }
        }
        System.out.println("\n");
    }
}