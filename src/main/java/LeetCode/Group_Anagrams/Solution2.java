package LeetCode.Group_Anagrams;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import util.Predicate;

/**
 * Runtime: 16ms(48.49%)
 * Memory: 44.7mb(40.35%)
 */
public class Solution2 implements Predicate<List<List<String>>, Object> {
	private static final int MAX_CHAR = 26;

	private String sortString(String str) {
		int letters[] = new int[MAX_CHAR];
		for (char x : str.toCharArray()) {
			letters[x - 'a']++;
		}

		return Arrays.toString(letters);
	}

	public List<List<String>> test(Object... params) {
		return groupAnagrams((String[]) params[0]);
	}

	private List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0) {
			return Collections.EMPTY_LIST;
		} else if (strs.length == 1) {
			return Arrays.asList(Arrays.asList(strs[0]));
		}

		Map<String, List<String>> groups = new HashMap<>();

		for (String str : strs) {
			String keyStr = sortString(str);

			List<String> list = groups.get(keyStr);

			if (list == null) {
				list = new LinkedList<>();
				list.add(str);
			} else {
				list.add(str);
			}

			groups.put(keyStr, list);
		}

		List<List<String>> resultList = new LinkedList<>();

		for (Map.Entry entry : groups.entrySet()) {
			resultList.add((List<String>) entry.getValue());
		}
		return resultList;
	}
}
