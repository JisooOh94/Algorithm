package medium.Minimize_Hamming_Distance_After_Swap_Operations;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class Answer {
	@Test
	public void test() {
//		int[] source = new int[]{1,2,3,4};
//		int[] target = new int[]{2,1,4,5};
//		int[][] allowedSwaps = new int[][]{
//				{0,1},
//				{2,3}
//		};

//		int[] source = new int[]{5,1,2,4,3};
//		int[] target = new int[]{1,5,4,2,3};
//		int[][] allowedSwaps = new int[][]{{0,4},{4,2},{1,3},{1,4}};
		int[] source = new int[]{2,3,1};
		int[] target = new int[]{1,2,2};
		int[][] allowedSwaps = new int[][]{
				{0,2},
				{1,2}
		};
		System.out.println(minimumHammingDistance(source, target, allowedSwaps));
	}

	public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
		int N = source.length;

		int[] UNION = new int[N];
		for (int i = 0; i < N; ++i) UNION[i] = i;

		// union-find
		for (int[] swap : allowedSwaps) {
			int indexA = swap[0], indexB = swap[1];
			int parentA = find(UNION, indexA), parentB = find(UNION, indexB);
			// union A and B
			if (parentA != parentB) UNION[parentA] = parentB;
		}

		// count element for each union-find group -> key: root of each union group, value: map
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int i = 0; i < N; ++i) {
			int num = source[i];
			int root = find(UNION, i);

			map.putIfAbsent(root, new HashSet<>());
			Set<Integer> store = map.get(root);
			store.add(num);
		}

		// greedy fit the target, if not, diff++
		int res = 0;
		for (int i = 0; i < N; ++i) {
			int num = target[i];
			int root = find(UNION, i);

			Set<Integer> store = map.get(root);

			if(!store.contains(num)) res++;
		}

		return res;
	}

	// union-find helper
	private int find(int[] UNION, int node) {
		if (UNION[node] == node) return node;
		return UNION[node] = find(UNION, UNION[node]);
	}
}
