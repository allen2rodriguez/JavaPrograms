package PerfectTicTacToe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayTree<TicTacToePosition> gameTree = createGameTree();

        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("You are 'X', and the computer is 'O'.");
        System.out.println("Here's the initial game board:");
        printBoard("         ");

        TicTacToePosition currentPosition = gameTree.get(0); // Start with the root position.
        char currentPlayer = 'X'; // You start.

        while (true) {
            if (currentPlayer == 'X') {
                int humanMove = getHumanMove(scanner, currentPosition.board);
                currentPosition = gameTree.get(gameTree.child(gameTree.root(), humanMove));
            } else {
                int bestMove = getBestMove(currentPosition);
                currentPosition = gameTree.get(gameTree.child(gameTree.root(), bestMove));
            }

            printBoard(currentPosition.board);

            if (isWin()) {
                System.out.println(currentPlayer + " wins!");
                break;
            } else if (isDraw()) {
                System.out.println("It's a draw!");
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    private static ArrayTree<TicTacToePosition> createGameTree() {
        int capacity = 500_000_000;
        ArrayTree<TicTacToePosition> gameTree = new ArrayTree<>(9, capacity);

        TicTacToePosition rootPosition = new TicTacToePosition("         ");
        gameTree.addRoot(rootPosition);

        TicTacToePosition.populateTree(gameTree, rootPosition, 0, 'X', 0);

        return gameTree;
    }

    private static int getHumanMove(Scanner scanner, String board) {
        int move;
        while (true) {
            System.out.print("Enter your move (0-8): ");
            move = scanner.nextInt();
            if (isValidMove(move, board)) {
                return move;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    private static boolean isValidMove(int move, String board) {
        return (move >= 0 && move < board.length());
    }


    private static void printBoard(String board) {
        System.out.println(board.substring(0, 3));
        System.out.println(board.substring(3, 6));
        System.out.println(board.substring(6));
    }

    private static int getBestMove(TicTacToePosition currentPosition) {
        // Replace with your AI logic to choose the best move.
        // You can traverse the game tree and select the move with the highest evaluation.
        // For now, we return a random available move.
        String board = currentPosition.board;
        for (int i = 0; i < board.length(); i++) {
            if (board.charAt(i) == ' ') {
                return i;
            }
        }
        return -1; // No valid move found.
    }

    private static boolean isWin() {
        // Implement your win-checking logic here.
        // Return true if the player specified has won on the given board.
        // Replace with your actual win-checking logic.
        return false;
    }

    private static boolean isDraw() {
        // Implement your draw-checking logic here.
        // Return true if the game is a draw on the given board.
        // Replace with your actual draw-checking logic.
        return false;
    }
}
