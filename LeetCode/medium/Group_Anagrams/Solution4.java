package medium.Group_Anagrams;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import util.Predicate;

/**
 * Runtime : 5ms(99.38%)
 * Memory : 42.5mb(86.55%)
 */
public class Solution4 implements Predicate<List<List<String>>, Object> {
	public List<List<String>> test(Object... params) {
		return groupAnagrams((String[]) params[0]);
	}

	private static final int MAX_CHAR = 26;

	private String sortString(String str) {
		int letters[] = new int[MAX_CHAR];
		for(int i = 0; i < str.length(); i++) {
			letters[str.charAt(i) - 'a']++;
		}

		return Arrays.toString(letters);
	}


	private List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0) {
			return Collections.EMPTY_LIST;
		} else if (strs.length == 1) {
			return Arrays.asList(Arrays.asList(strs[0]));
		}

		Map<String, List<String>> groups = new HashMap<>();
		List<List<String>> resultList = new LinkedList<>();

		for (String str : strs) {
			String keyStr = sortString(str);

			List<String> list = groups.get(keyStr);

			if (list == null) {
				list = new LinkedList<>();
				resultList.add(list);
				list.add(str);
			} else {
				list.add(str);
			}

			groups.put(keyStr, list);
		}

		return resultList;
	}
}
