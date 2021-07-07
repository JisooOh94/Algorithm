package medium.Minimize_Hamming_Distance_After_Swap_Operations;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class Solution {
	@Test
	public void execute() {
		int[] source = new int[]{85, 91};
		int[] target = new int[]{77, 50};
		int[][] allowedSwaps = new int[][]{
				{1,0}
		};
		System.out.println(minimumHammingDistance(source, target, allowedSwaps));
	}

	private int find(int cur, Integer[] parentArr) {
		while(parentArr[cur] != null) cur = parentArr[cur];
		return cur;
	}
	private void union(int[] pair, Integer[] parentArr, boolean[] inGroup) {
		int parent = find(Math.min(pair[0], pair[1]), parentArr);
		int child = find(Math.max(pair[0], pair[1]), parentArr);

		parentArr[child] = parent;
		inGroup[parent] = inGroup[child] = true;
	}

	public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
		int diffCnt = 0;
		Integer[] parentArr = new Integer[source.length];
		boolean[] inGroup = new boolean[source.length];

		for(int[] pair : allowedSwaps) union(pair, parentArr, inGroup);

		Map<Integer, Set<Integer>> groups = new HashMap<>();
		for(int i = 0; i < parentArr.length; i++) {
			if(parentArr[i] != null) {
				int parent = find(i, parentArr);
				parentArr[i] = parent;
				Set<Integer> group = groups.getOrDefault(parent, new HashSet<>());
				if(group.isEmpty()) {
					groups.put(parent, group);
					group.add(source[parent]);
				}
				group.add(source[i]);
			}
		}

		for(int i = 0; i < parentArr.length; i++) {
			if(parentArr[i] != null) {
				int parent = find(i, parentArr);
				if(!groups.get(parent).contains(target[i])) diffCnt++;
			}
		}

		for(int i = 0; i < inGroup.length; i++) {
			if(!inGroup[i] && source[i] != target[i]) diffCnt++;
		}

		return diffCnt;
	}
}
