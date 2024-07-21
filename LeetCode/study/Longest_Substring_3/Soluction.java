package study.Longest_Substring_3;

import java.util.HashMap;
import java.util.Map;

import util.Predicate;

/**
 * Time Complexity : O(n)
 */
public class Soluction implements Predicate<Integer, Object> {
	public Integer test(Object... params) {
		return lengthOfLongestSubstring((String)params[0]);
	}

	public int lengthOfLongestSubstring(String sampleStr) {
		if(sampleStr == null || sampleStr == "") {
			return 0;
		}

		int maxSize = 0;
		long strLength = sampleStr.length();
		Map<Character, Integer> map = new HashMap<Character, Integer>((int)strLength);

		long startIdx = 0;
		long lastIdx = 0;

		for(long i = 0; i< strLength; i++) {
			char curChar = sampleStr.charAt((int)i);

			if(map.containsKey(curChar)) {
				int value = map.get(curChar);
				if(value >= startIdx) {
					startIdx = map.get(curChar) + 1;
				}
			}
			lastIdx++;
			map.put(curChar, (int)i);

			if(lastIdx - startIdx > maxSize) {
				maxSize = (int)(lastIdx - startIdx);
			}
		}

		return maxSize;
	}
}
