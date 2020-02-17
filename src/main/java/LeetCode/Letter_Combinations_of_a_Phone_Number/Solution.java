package LeetCode.Letter_Combinations_of_a_Phone_Number;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import util.Predicate;

/**
 * Time Compelxity :
 */
public class Solution implements Predicate<List<String>, Object> {
	public List<String> test(Object... params) {
		return letterCombinations((String)params[0]);
	}

	private static char[][] charData = new char[][] {
			{'a','b','c'},
			{'d','e','f'},
			{'g','h','i'},
			{'j','k','l'},
			{'m','n','o'},
			{'p','q','r','s'},
			{'t','u','v'},
			{'w','x','y','z'},
	};

	private static List<String> result;
	private static int[] sampleDigits;
	private static final List<String> EMPTY_LIST = new ArrayList<>();

	public static List<String> letterCombinations(String sample) {
		if(sample == null || sample == "" || sample.isEmpty()) {
			return EMPTY_LIST;
		}
		result = new LinkedList<>();

		sampleDigits = Stream.of(sample.split(""))
				.mapToInt(Integer::parseInt)
				.toArray();

		StringBuilder builder = new StringBuilder();
		recursion(0, builder);
		//recursion(0, "");

		return result;
	}

	public static void recursion(int idx, StringBuilder builder) {
		if(idx == sampleDigits.length) {
			result.add(builder.toString());
			return;
		}

		int charIdx = sampleDigits[idx] - 2;
		for(int i = 0; i < charData[charIdx].length; i++) {
			builder.append(charData[charIdx][i]);
			recursion(idx + 1, builder);
			builder.deleteCharAt(builder.length() - 1);
		}
	}

	public static void recursion(int idx, String str) {
		if(idx == sampleDigits.length) {
			result.add(str);
			return;
		}

		int charIdx = sampleDigits[idx] - 2;
		for(int i = 0; i < charData[charIdx].length; i++) {
			recursion(idx + 1, str + charData[charIdx][i]);
		}
	}
}
