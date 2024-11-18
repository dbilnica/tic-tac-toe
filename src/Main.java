import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] matrix2D = new char[3][3];
        initializeBoard(matrix2D);
        boolean player = true, ended = false;
        String player1Name, player2Name;
        Scanner scanner = new Scanner(System.in);
        int row = 0, col = 0;

        System.out.println("Enter first player name: ");
        player1Name = scanner.nextLine();
        System.out.println("Player " + player1Name + " has been set symbol 'X'");
        System.out.println("Enter second player name: ");
        player2Name = scanner.nextLine();
        System.out.println("Player " + player2Name + " has been set symbol '0'");

        while (!ended) {
            clearConsole();
            String hitEnter = "Please hit ENTER to continue...";
            char symbol;

            if (player) {
                symbol = 'X';
                System.out.println("It's " + player1Name + "'s turn!");
            } else {
                symbol = 'O';
                System.out.println("It's " + player2Name + "'s turn!");
            }
            printBoard(matrix2D);
            try{
                System.out.println("Enter row in matrix (1-3)");
                row = scanner.nextInt();
                System.out.println("Enter column in matrix (1-3)");
                col = scanner.nextInt();
                if(row < 0 || row > 3 || col < 0 || col > 3) {
                    System.out.println(hitEnter);
                    scanner.nextLine();
                    System.out.println();
                    scanner.nextLine();
                    continue;
                }
                if (positionUsed(matrix2D, row, col)) {
                    scanner.nextLine();
                    System.out.println(hitEnter);
                    scanner.nextLine();
                    continue;
                }
            } catch(InputMismatchException e){
                System.out.println("Invalid input. Please enter numbers only.");
                scanner.nextLine();
                System.out.println(hitEnter);
                scanner.nextLine();
                continue;
            }

            player = makeMove(row, col, matrix2D, player, symbol);
            ended = playerWin(matrix2D, symbol, player1Name, player2Name);
            if (isDraw(matrix2D)) {
                clearConsole();
                printBoard(matrix2D);
                System.out.println("It's a draw!");
            }
        }

    }

    public static void printBoard(char[][] matrix2D) {
        for (int i = 0; i < matrix2D.length; i++) {
            for (int j = 0; j < matrix2D.length; j++) {
                if (j == 1) {
                    System.out.print("| " + matrix2D[i][j] + " |");
                } else {
                    System.out.print(" " + matrix2D[i][j] + " ");
                }

            }
            if (i < matrix2D.length - 1) {
                System.out.println("\n" + "---+---+---");
            }
        }
        System.out.println("\n");
    }

    public static boolean positionUsed(char[][] matrix2D, int row, int col) {
        if (matrix2D[row - 1][col - 1] != ' ') {
            System.out.println("This game field is already in use! \n You have to choose different one!");
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
                if ((j == 0 && matrix2D[i][j] == symbol
                        && matrix2D[i][j + 1] == symbol
                        && matrix2D[i][j + 2] == symbol) || (i == 0 && matrix2D[i][j] == symbol
                        && matrix2D[i + 1][j] == symbol
                        && matrix2D[i + 2][j] == symbol)) {
                    clearConsole();
                    printBoard(matrix2D);
                    winnerName(symbol, player1Name, player2Name);
                    return true;
                }

                if ((i == 0 && j == 0
                        && matrix2D[i][j] == symbol
                        && matrix2D[i + 1][j + 1] == symbol
                        && matrix2D[i + 2][j + 2] == symbol) || (i == 0 && j == 2
                        && matrix2D[i][j] == symbol
                        && matrix2D[i + 1][j - 1] == symbol
                        && matrix2D[i + 2][j - 2] == symbol)) {
                    clearConsole();
                    printBoard(matrix2D);
                    winnerName(symbol, player1Name, player2Name);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isDraw(char[][] matrix2D) {
        for (int i = 0; i < matrix2D.length; i++) {
            for (int j = 0; j < matrix2D.length; j++) {
                if (matrix2D[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void winnerName(char symbol, String player1Name, String player2Name) {
        if (symbol == 'X') {
            System.out.println("The Winner is: " + player1Name);
        } else System.out.println("The Winner is: " + player2Name);
    }

    public static void initializeBoard(char[][] matrix2D) {
        for (int i = 0; i < matrix2D.length; i++) {
            for (int j = 0; j < matrix2D.length; j++) {
                matrix2D[i][j] = ' ';
            }
        }
    }

    public static void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

}