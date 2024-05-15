package PerfectTicTacToe;
public class GenTree {
    public static void main(String[] args) {
        ArrayTree<TicTacToePosition> gameTree = new ArrayTree<>(9, 500_000_000);

        TicTacToePosition rootPosition = new TicTacToePosition("         ");
        gameTree.addRoot(rootPosition);

        TicTacToePosition.populateTree(gameTree, rootPosition, 0, 'X', 0);

        for (int i = 0; i < 100; i++) {
            TicTacToePosition t = gameTree.get(i);
            if (t != null)
                System.out.printf("%2d) %s\n", i, t.board);
            else
                System.out.printf("%2d) Empty\n", i);
        }
    }
}

 class TicTacToePosition {
    public String board;
    public int evaluation;

    public TicTacToePosition(String s) {
        this.board = s;
        this.evaluation = evaluatePosition();
    }

    private int evaluatePosition() {
        if (isWin()) {
            return 1;
        } else if (isLose()) {
            return -1;
        } else if (isDraw()) {
            return 0;
        } else {
            return 2;
        }
    }

    private boolean isWin() {
        return false;
    }

    private boolean isDraw() {
        return false;
    }

    private boolean isLose() { return false; }

    public static void populateTree(ArrayTree<TicTacToePosition> gameTree, TicTacToePosition parentPosition, int parentIndex, char currentPlayer, int childIndex) {
        if (childIndex >= gameTree.getCapacity()) {
            return;
        }

        String board = parentPosition.board;

        for (int i = 0; i < board.length(); i++) {
            if (board.charAt(i) == ' ') {
                StringBuilder newBoard = new StringBuilder(board);
                newBoard.setCharAt(i, currentPlayer);

                TicTacToePosition childPosition = new TicTacToePosition(newBoard.toString());

                gameTree.addChild(parentIndex, i, childPosition);

                char nextPlayer = (currentPlayer == 'X') ? 'O' : 'X';

                int newChildIndex = gameTree.child(parentIndex, i);

                populateTree(gameTree, childPosition, newChildIndex, nextPlayer, 0);
            }
        }
    }
}

