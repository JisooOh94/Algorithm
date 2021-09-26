package medium.Maximum_Distance_in_Arrays;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Runtime : 21ms(17.98%)
 * Memory : 69.7mb(22.47%)
 * Time Complexity : O(n)
 * Subject : greedy
 */
public class Solution_2 {
	@Test
	public void execute() {
//		List<List<Integer>> list = Arrays.asList(Arrays.asList(1),Arrays.asList(1));
		List<List<Integer>> list = Arrays.asList(
				Arrays.asList(-1,1),
				Arrays.asList(-3,1,4),
				Arrays.asList(-2,-1,0,2));

		System.out.println(maxDistance(list));
	}

	public int maxDistance(List<List<Integer>> arrays) {
		List<Integer> firstMinList = null, firstMaxList = null, secondMinList = null, secondMaxList = null;

		for(List<Integer> list : arrays) {
			if(firstMinList == null && firstMaxList == null) {
				firstMinList = list;
				firstMaxList = list;
			} else {
				if(list.get(0) <= firstMinList.get(0)) {
					secondMinList = firstMinList;
					firstMinList = list;
				} else if(secondMinList == null || list.get(0) < secondMinList.get(0)) {
					secondMinList = list;
				}

				if(firstMaxList.get(firstMaxList.size() - 1) <= list.get(list.size() - 1)) {
					secondMaxList = firstMaxList;
					firstMaxList = list;
				} else if(secondMaxList == null || secondMaxList.get(secondMaxList.size() - 1) < list.get(list.size() - 1)) {
					secondMaxList = list;
				}
			}
		}

		return firstMaxList == firstMinList ? Math.max(Math.abs(firstMaxList.get(firstMaxList.size() - 1) - secondMinList.get(0)), Math.abs(secondMaxList.get(secondMaxList.size() - 1) - firstMinList.get(0))) : Math.abs(firstMaxList.get(firstMaxList.size() - 1) - firstMinList.get(0));
	}
}
