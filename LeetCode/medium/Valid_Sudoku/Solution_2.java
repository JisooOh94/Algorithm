package medium.Valid_Sudoku;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import util.Predicate;

/**
 * Runtime : 3ms(56.22%)
 * Memory : 41.1mb(97.10%)
 */
public class Solution_2 implements Predicate<Boolean, Object> {
	char[][] board = new char[][]{
			{'8', '3', '.', '.', '7', '.', '.', '.', '.'},
			{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
			{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
			{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
			{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
			{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
			{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
			{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
			{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
	};

	public Boolean test(Object... params) {
		return isValidSudoku(board);
	}

	private boolean isValidSudoku(char[][] board) {
		List<Set<Character>> vertical = new ArrayList<>(9);
		List<Set<Character>> horizontal = new ArrayList<>(9);
		List<Set<Character>> grid = new ArrayList<>(9);

		for(int i = 0; i < 9; i++) {
			vertical.add(new HashSet<>());
			horizontal.add(new HashSet<>());
			grid.add(new HashSet<>());
		}

		for(int y = 0; y < 9; y++) {
			for(int x = 0; x < 9; x++) {
				Character target = board[y][x];

				if(target != '.') {
					if (target < '1' || '9' < target) {
						return false;
					}
					int vertical_prev_size = vertical.get(x).size();
					int horizontal_prev_size = horizontal.get(y).size();
					int grid_prev_size = grid.get(y / 3 * 3 + x / 3).size();

					vertical.get(x).add(target);
					horizontal.get(y).add(target);
					grid.get(y / 3 * 3 + x / 3).add(target);

					if(vertical_prev_size == vertical.get(x).size() || horizontal_prev_size == horizontal.get(y).size() || grid_prev_size == grid.get(y / 3 * 3 + x / 3).size()) {
						return false;
					}
				}
			}
		}

		return true;
	}
}
