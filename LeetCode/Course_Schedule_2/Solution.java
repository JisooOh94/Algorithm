package Course_Schedule_2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import util.Predicate;

/**
 * Runtime : 40ms(6.18%)
 * Memory : 41.2mb(97.56%)
 */
public class Solution implements Predicate<int[], Object> {
	public int[] test(Object... params) {
		int[] result = findOrder((int)params[0], (int[][])params[1]);
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i]);
		}
		return null;
	}

	private static final int[] EMPTY_ARR = new int[0];

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		List<Integer> candidates = IntStream.range(0, numCourses).boxed().collect(Collectors.toList());
		Map<Integer, List<Integer>> parentList = new HashMap<>();
		Map<Integer, List<Integer>> childList = new HashMap<>();

		//0 : child, 1 : parent
		for(int[] pre : prerequisites) {
			parentList.putIfAbsent(pre[0], new LinkedList<>());
			childList.putIfAbsent(pre[1], new LinkedList<>());

			parentList.get(pre[0]).add(pre[1]);
			childList.get(pre[1]).add(pre[0]);
			candidates.remove((Object)pre[0]);
		}

		int[] order = new int[numCourses];
		if(recursion(candidates, 0, order, 0, parentList, childList, numCourses)) {
			return order;
		} else {
			return EMPTY_ARR;
		}
	}

	private boolean recursion(List<Integer> candidates, int candidateIdx, int[] order, int orderIdx, Map<Integer, List<Integer>> parentListMap, Map<Integer, List<Integer>> childListMap, int numCourses) {
		if(orderIdx == numCourses) {
			return true;
		} else if(candidates.size() == 0) {
			return false;
		}

		for(int i = candidateIdx; i < candidates.size(); i++) {
			Integer candidate = candidates.get(i);
			order[orderIdx] = candidate;

			List<Integer> childList = childListMap.get(candidate);
			if(childList != null) {
				for (Integer child : childList) {
					List<Integer> parentList = parentListMap.get(child);
					if (parentList != null) {
						parentList.remove(candidate);
						if (parentList.size() == 0) {
							candidates.add(child);
						}
					}
				}

				if(recursion(candidates, candidateIdx + 1, order, orderIdx + 1, parentListMap, childListMap, numCourses)) {
					return true;
				}

				candidates.remove(candidates.size() - 1);
				for (Integer child : childListMap.get(candidate)) {
					List<Integer> parentList = parentListMap.get(child);
					if (parentList != null) {
						parentList.add(candidate);
					}
				}
			} else {
				if(recursion(candidates, candidateIdx + 1, order, orderIdx + 1, parentListMap, childListMap, numCourses)) {
					return true;
				}
			}
		}
		return false;
	}
}
