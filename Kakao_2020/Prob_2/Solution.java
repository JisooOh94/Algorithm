package Prob_2;

import java.util.*;

import org.junit.Test;

public class Solution {
	@Test
	public void test() {
//		String[] orders = new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}; int[] course = new int[]{2, 3, 4};
//		String[] orders = new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}; int[] course = new int[]{2, 3, 5};
		String[] orders = new String[]{"XYZ", "XWY", "WXA"}; int[] course = new int[]{2, 3, 4};
		String[] result = solution(orders, course);
		for(String str : result) System.out.println(str);
	}
	private void recursion (StringBuilder builder, int idx, char[] str, int courseIdx, int[] course, Map<String, Integer> occured, List<String>[] candidateList) {
		if (builder.length() == course[courseIdx]) {
			String key = builder.toString();
			int cnt = occured.getOrDefault(key, 0) + 1;

			if(1 < cnt && candidateList[courseIdx] != null) {
				int maxCnt = occured.get(candidateList[courseIdx].get(0));
				if(maxCnt == cnt) candidateList[courseIdx].add(key);
				else if(maxCnt < cnt) {
					candidateList[courseIdx].clear();
					candidateList[courseIdx].add(key);
				}
			} else if(1 < cnt) {
				candidateList[courseIdx] = new LinkedList<>();
				candidateList[courseIdx].add(key);
			}
			occured.put(key, cnt);
			courseIdx++;
		}

		if (courseIdx == course.length || idx == str.length) return;

		recursion(builder, idx + 1, str, courseIdx, course, occured, candidateList);
		builder.append(str[idx]);
		recursion(builder, idx + 1, str, courseIdx, course, occured, candidateList);
		builder.deleteCharAt(builder.length() - 1);

		return;
	}
	public String[] solution(String[] orders, int[] course) {
		List<String>[] resultSet = new LinkedList[course.length];
		Map<String, Integer> occured = new HashMap<>();
		for(String order : orders) {
			char[] str = order.toCharArray();
			Arrays.sort(str);
			StringBuilder builder = new StringBuilder();

			recursion(builder, 0, str, 0, course, occured, resultSet);
		}

		List<String> result = new LinkedList<>();
		for(List<String> list : resultSet) {
			if(list != null)result.addAll(list);
		}
		String[] resultArr = new String[result.size()];
		result.toArray(resultArr);
		Arrays.sort(resultArr);
		return resultArr;
	}
}
