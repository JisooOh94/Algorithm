package medium.Prison_Cells_After_N_Days;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import util.Predicate;

/**
 * Runtime : 4ms(37.63%)
 * Memory : 39.4mb(7.14%)
 */
public class Solution implements Predicate<int[], Object> {
	public int[] test(Object... params) {
		int[] result = prisonAfterNDays((int[])params[0], (int)params[1]);

		for(int i = 0; i < 8; i++) {
			System.out.print(result[i] + " ");
		}

		return null;
	}

	private static final int OCCUPIED = 1;
	private static final int VACANT = 0;

	public int[] prisonAfterNDays(int[] cells, int N) {
		Set<String> set = new HashSet<>();
		List<int[]> cellList = new LinkedList<>();
		if(init(cells)) N--;

		set.add(Arrays.toString(cells));
		cellList.add(cells);

		while(true) {
			updatePrisonStatus(cells, 0);
			if(set.contains(Arrays.toString(cells))) { break; }
			set.add(Arrays.toString(cells));
			cellList.add(Arrays.copyOf(cells, cells.length));
		}

		int leftOver = N % set.size();

		return cellList.get(leftOver);
	}

	private boolean init(int[] cells) {
		if(cells[0] != 0 || cells[7] != 0) {
			updatePrisonStatus(cells, cells[0]);
			cells[0] = cells[7] = 0;
			return true;
		}
		return  false;
	}

	private void updatePrisonStatus(int[] cells, int initial) {
		int prev = initial;
		for(int i = 1; i < 7; i++) {
			int temp = cells[i];
			cells[i] = prev == cells[i + 1] ? OCCUPIED : VACANT;
			prev = temp;
		}
	}

}
