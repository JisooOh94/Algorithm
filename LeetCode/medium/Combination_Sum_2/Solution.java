package medium.Combination_Sum_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import util.Predicate;

/**
 * Runtime : 2ms(99.31%)
 * Memory : 39.9mb(40.0%)
 */
public class Solution implements Predicate<List<List<Integer>>, Object> {
	public List<List<Integer>> test(Object... params) {
		return combinationSum((int[])params[0], (int)params[1]);
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		if(target < candidates[0]) {
			return Collections.EMPTY_LIST;
		}

		Stack<Integer> numList = new Stack<>();
		List<List<Integer>> resultList = new LinkedList<>();

		recursion(target, -1, numList, resultList, candidates);

		return resultList;
	}

	private void recursion(int targetNum, int curIdx, Stack<Integer> numList, List<List<Integer>> resultList, int[] candidates) {
		if(targetNum == 0) {
			resultList.add(new ArrayList<>(numList));
			return;
		}

		for(int i = curIdx + 1; i < candidates.length && candidates[i] <= targetNum; i++) {
			if(curIdx + 1 < i && candidates[i - 1] == candidates[i]) continue;

			numList.push(candidates[i]);
			recursion(targetNum - candidates[i], i, numList, resultList, candidates);
			numList.pop();
		}
	}
}
