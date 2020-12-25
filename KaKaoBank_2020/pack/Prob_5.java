package pack;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Prob_5 {
	@Test
	public void execute() {
		String num = "onesevenfive";
		System.out.println(solution(num));
	}

	private static final int NUM = 0;
	private static final int LEN = 1;

	public String solution(String number) {
		Map<String, int[]> map = new HashMap<>();
		map.put("ze", new int[]{0, 4});
		map.put("on", new int[]{1, 3});
		map.put("tw", new int[]{2, 3});
		map.put("th", new int[]{3, 5});
		map.put("fo", new int[]{4, 4});
		map.put("fi", new int[]{5, 4});
		map.put("si", new int[]{6, 3});
		map.put("se", new int[]{7, 5});
		map.put("ei", new int[]{8, 5});
		map.put("ni", new int[]{9, 4});

		int idx = 0;
		StringBuilder builder = new StringBuilder();
		while(idx < number.length()) {
			String key = number.substring(idx, idx + 2);
			int[] info = map.get(key);
			builder.append(info[NUM]);
			idx += info[LEN];
		}

		return builder.toString();
	}
}
