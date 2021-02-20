package medium.Matchsticks_to_Square;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * Runtime : 3ms(85.69%)
 * Memory : 36.4mb(89.50%)
 * Time Complexity : O(nlogn)
 */
public class Solution {
	@Test
	public void execute() {
//		int[] nums = new int[]{1, 1, 2, 2, 2};
		int[] nums = new int[]{3,3,3,3,4};
		System.out.println(makesquare(nums));
	}
	private boolean recursion(int curEdge, int curIdx, int edgeCnt, int targetEdge, List<int[]> edgeList) {
		if(edgeCnt == 4) return true;

		if(curEdge == 0) {
			for(int i = 0; i < edgeList.size(); i++) {
				int[] edge = edgeList.get(i);
				if(0 < edge[1]) {
					edge[1]--;
					if(edge[0] == targetEdge && recursion(0, i, edgeCnt + 1, targetEdge, edgeList)) return true;
					else if(recursion(edge[0], i, edgeCnt, targetEdge, edgeList)) return true;
					edge[1]++;
					break;
				}
			}
		} else {
			for(int i = curIdx; i < edgeList.size(); i++) {
				int[] edge = edgeList.get(i);
				if(0 < edge[1] && curEdge + edge[0] <= targetEdge) {
					edge[1]--;
					if(curEdge + edge[0] == targetEdge && recursion(0, i, edgeCnt + 1, targetEdge, edgeList)) return true;
					else if(recursion(curEdge + edge[0], i, edgeCnt, targetEdge, edgeList)) return true;
					edge[1]++;
				}
			}
		}

		return false;
	}

	public boolean makesquare(int[] nums) {
		if(nums == null || nums.length < 4) return false;
		Map<Integer, int[]> map = new HashMap<>();
		int sum = 0;
		for(int num : nums) {
			if(!map.containsKey(num)) map.put(num, new int[]{num, 1});
			else map.get(num)[1]++;
			sum += num;
		}

		if(sum % 4 != 0) return false;
		int targetEdge = sum / 4;
		List<int[]> edgeList = map.values().stream().sorted((e1, e2) -> e1[0] > e2[0] ? -1 : e1[0] < e2[0] ? 1 : 0).collect(Collectors.toList());

		return recursion(0, 0, 0, targetEdge, edgeList);
	}
}
