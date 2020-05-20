package medium.Design_Tic_Tac_Toe;

/**
 * Runtime : 3ms(100.00%)
 * Memory : 42.6mb(100.00%)
 */
public class TicTacToe_2 {
    private int size = 0;
    private int[][] rowCand;
    private int[][] colCand;
    private int[] upperDiagCand = new int[]{0, 0};
    private int[] lowerDiagCand = new int[]{0, 0};

    public TicTacToe_2(int n) {
        size = n;
        rowCand = new int[2][n];
        colCand = new int[2][n];
    }

    public int move(int row, int col, int player) {
        player -= 1;

        rowCand[player][row]++;
        if(rowCand[player][row] == size) return player + 1;

        colCand[player][col]++;
        if(colCand[player][col] == size) return player + 1;

        if(row == col) {
            lowerDiagCand[player]++;
            if(lowerDiagCand[player] == size) return player + 1;
        }
        if(row + col == size - 1) {
            upperDiagCand[player]++;
            if(upperDiagCand[player] == size) return player + 1;
        }

        return 0;
    }
}
