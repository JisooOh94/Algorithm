package medium.Closest_Dessert_Cost;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/**
 * Runtime : 39ms(19.43%
 * Memory : 43.9mb(8.62%)
 * Time Complexity : O(n^2)
 * Subject : Greedy
 */
public class Solution {
	@Test
	public void test() {
		int[] baseCosts = new int[]{2,9,10,5,4,9,8,8,1};
		int[] toppingCosts = new int[]{9,3,10,9};
		int target = 3;
		System.out.println(closestCost(baseCosts, toppingCosts, target));
	}
	private void recursion(int cur, int[] toppingCosts, Set<Integer> sums) {
		if(cur == toppingCosts.length) {
			sums.add(0);
			return;
		}

		recursion(cur + 1, toppingCosts, sums);
		Set<Integer> newSums = new HashSet<>();
		for(Iterator<Integer> iter = sums.iterator(); iter.hasNext();) {
			int curSum = iter.next();
			newSums.add(curSum + toppingCosts[cur]);
			newSums.add(curSum + toppingCosts[cur] * 2);
		}
		sums.addAll(newSums);
	}

	public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
		Set<Integer> sums = new HashSet<>();
		recursion(0, toppingCosts, sums);

		List<Integer> sumsList = new ArrayList<>(sums);
		Collections.sort(sumsList);
		Arrays.sort(baseCosts);

		int minGap = 999999;
		int minGapCost = 0;
		for(int base : baseCosts) {
			if(target < base) {
				minGapCost = base - target < minGap ? base : minGapCost;
				break;
			}

			int targetGap = target - base;
			int targetGapIdx = Collections.binarySearch(sumsList, targetGap);
			if(0 <= targetGapIdx) return target;

			int lowIdx = (targetGapIdx * -1) - 2;
			int highIdx = (targetGapIdx * -1) - 1;

			int curGapIdx = lowIdx < 0 ? highIdx : sumsList.size() <= highIdx ? lowIdx : sumsList.get(highIdx) - targetGap < targetGap - sumsList.get(lowIdx) ? highIdx : lowIdx;
			int curGap = Math.abs(targetGap - sumsList.get(curGapIdx));
			if(curGap < minGap || curGap == minGap && base + sumsList.get(curGapIdx) < minGapCost) {
				minGap = curGap;
				minGapCost = base + sumsList.get(curGapIdx);
			}
		}
		return minGapCost;
	}
}
