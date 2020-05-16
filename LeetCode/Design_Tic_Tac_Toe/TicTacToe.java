package Design_Tic_Tac_Toe;

import java.util.*;

/**
 * Runtime : 5ms(27.46%)
 * Memory : 42.2mb(100.00%)
 */
public class TicTacToe {
    private int size = 0;
    private List<Map<Integer, Integer>> rowCand = Arrays.asList(new HashMap<>(), new HashMap<>());
    private List<Map<Integer, Integer>> colCand = Arrays.asList(new HashMap<>(), new HashMap<>());
    private List<Integer> upperDiagCand = Arrays.asList(0, 0);
    private List<Integer> lowerDiagCand = Arrays.asList(0, 0);

    public TicTacToe(int n) {
        size = n;
    }

    public int move(int row, int col, int player) {
        player -= 1;
        int cnt = 0;

        cnt = rowCand.get(player).getOrDefault(row, 0);
        if(cnt + 1 == size) return player + 1;
        else rowCand.get(player).put(row, cnt + 1);

        cnt = colCand.get(player).getOrDefault(col, 0);
        if(cnt + 1 == size) return player + 1;
        else colCand.get(player).put(col, cnt + 1);

        if(row == col) {
            cnt = lowerDiagCand.get(player);
            if(cnt + 1 == size) return player + 1;
            else lowerDiagCand.set(player, cnt + 1);
        }
        if(row + col == size - 1) {
            cnt = upperDiagCand.get(player);
            if(cnt + 1 == size) return player + 1;
            else upperDiagCand.set(player, cnt + 1);
        }

        return 0;
    }
}
