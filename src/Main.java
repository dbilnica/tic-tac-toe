import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] matrix2D = new char[3][3];
        for (int i = 0; i < matrix2D.length; i++) {
            for (int j = 0; j < matrix2D.length; j++) {
                matrix2D[i][j] = ' ';
            }
        }
        boolean player = true, ended = false;
        String player1Name, player2Name;
        Scanner scanner = new Scanner(System.in);
        int row = 0, col = 0;
        System.out.println("Enter first player name: ");
        player1Name = scanner.nextLine();
        System.out.println("Player " + player1Name + " has been setted symbol 'X'");
        System.out.println("Enter second player name: ");
        player2Name = scanner.nextLine();
        System.out.println("Player " + player2Name + " has been setted symbol '0'");
        while (ended == false) {
            printMatrix(matrix2D);
            System.out.println("Enter row in matrix");
            row = scanner.nextInt();
            System.out.println("Enter column in matrix");
            col = scanner.nextInt();
            if (positionUsed(matrix2D, row, col)) {
                continue;
            }
            char symbol;
            if (player) {
                symbol = 'X';
            } else {
                symbol = 'O';
            }
            player = makeMove(row, col, matrix2D, player, symbol);
            ended = playerWin(matrix2D, symbol, player1Name, player2Name);
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
            if (i < matrix2D.length - 1) {
                System.out.println("\n" + " - + - + -");
            }
        }
        System.out.println("\n");
    }

    public static boolean positionUsed(char[][] matrix2D, int row, int col) {
        if (matrix2D[row - 1][col - 1] != ' ') {
            System.out.println("This field is already in use!");
            return true;
        }
        return false;
    }

    public static boolean makeMove(int row, int col, char[][] matrix2D, boolean player, char symbol) {
        if (row < (matrix2D.length + 1) && col < (matrix2D.length + 1)) {
            matrix2D[row - 1][col - 1] = symbol;
            return !player;
        }
        return player;
    }

    public static boolean playerWin(char[][] matrix2D, char symbol, String player1Name, String player2Name) {
        for (int i = 0; i < matrix2D.length; i++) {
            for (int j = 0; j < matrix2D.length; j++) {
                if (j == 0 && matrix2D[i][j] == symbol
                        && matrix2D[i][j + 1] == symbol
                        && matrix2D[i][j + 2] == symbol) {
                    winnerName(symbol, player1Name, player2Name);
                    return true;
                }
                if (i == 0 && matrix2D[i][j] == symbol
                        && matrix2D[i + 1][j] == symbol
                        && matrix2D[i + 2][j] == symbol) {
                    winnerName(symbol, player1Name, player2Name);
                    return true;
                }
                if (i == 0 && j == 0
                        && matrix2D[i][j] == symbol
                        && matrix2D[i + 1][j + 1] == symbol
                        && matrix2D[i + 2][j + 2] == symbol) {
                    winnerName(symbol, player1Name, player2Name);
                    return true;
                }
                if (i == 0 && j == 2
                        && matrix2D[i][j] == symbol
                        && matrix2D[i + 1][j - 1] == symbol
                        && matrix2D[i + 2][j - 2] == symbol) {
                    winnerName(symbol, player1Name, player2Name);
                    return true;
                }
            }
        }
        return false;
    }

    public static void winnerName(char symbol, String player1Name, String player2Name) {
        if (symbol == 'X') {
            System.out.println("The Winner is: " + player1Name);
        } else System.out.println("The Winner is: " + player2Name);
    }
}