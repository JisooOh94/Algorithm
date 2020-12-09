package medium.Satisfiability_of_Equality_Equations;

import java.util.LinkedList;
import java.util.List;

/**
 * Runtime : 2ms(37.30%)
 * Memory : 39mb(18.29%)
 */
public class Solution {
	private int find(int cur, Integer[] parentList) {
		while(parentList[cur] != null) cur = parentList[cur];
		return cur;
	}
	private void union(int p, int c, Integer[] parentList) {
		int parent = find(p, parentList);
		int child = find(c, parentList);

		if(parent != child) parentList[child] = parent;
	}
	public boolean equationsPossible(String[] equations) {
		List<int[]> diffPair = new LinkedList<>();
		Integer[] parentList = new Integer[26];

		for(String equation : equations) {
			int p = equation.charAt(0) - 'a';
			int c = equation.charAt(3) - 'a';
			if(equation.charAt(1) == '!') {
				if(p == c) return false;
				diffPair.add(new int[]{p, c});
			} else {
				if(p != c) union(p, c, parentList);
			}
		}

		for(int[] diff : diffPair) {
			if(find(diff[0], parentList) == find(diff[1], parentList)) return false;
		}
		return true;
	}
}
