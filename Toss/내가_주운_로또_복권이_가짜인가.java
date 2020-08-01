import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;

import org.junit.Test;

public class 내가_주운_로또_복권이_가짜인가 {
	private static boolean isValid(String str) {
		if(str == null || str.length() == 0) return false;

		String[] nrr = str.split(" ");

		int prev = Integer.parseInt(nrr[0]);
		if(prev < 1 || 45 < prev) return false;

		for(int i = 1; i < nrr.length; i++) {
			int cur = Integer.parseInt(nrr[i]);
			if(cur <= prev || 45 < cur) return false;
			prev = cur;
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		System.out.println(isValid(input));
	}

	@Test
	public void test() {
//		String input = "1 2 4 5 6";
//		String input = "1 2 3 4 5 6";
//		String input = "46 1 3 5 7 9";
		String input = "46";
		System.out.println(isValid(input));
	}
}
