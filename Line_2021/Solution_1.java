import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * Time Complexity : O(n^2)
 */
public class Solution_1 {

	@Test
	public void test() {
		String str = "abc";
		String delims = "1";

		List<String> resultList = new LinkedList<>();
		LinkedList<Character> builder = new LinkedList<>();

		recursion(0, str.toCharArray(), delims.toCharArray(), builder, resultList);

		System.out.println(resultList.size());
		for(String result : resultList) {
			System.out.println(result);
		}
	}

	private static void recursion(int curIdx, char[] str, char[] delims, LinkedList<Character> builder, List<String> resultList) {
		builder.addLast(str[curIdx]);
		if(curIdx == str.length - 1) {
			String result = builder.stream()
					.map(String::valueOf)
					.collect(Collectors.joining());
			resultList.add(result);
		} else {
			for(char delim : delims) {
				builder.addLast(delim);
				recursion(curIdx + 1, str, delims, builder, resultList);
				builder.removeLast();
			}
		}
		builder.removeLast();
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String delims = sc.next();
		String str = sc.next();
		List<String> resultList = new LinkedList<>();
		LinkedList<Character> builder = new LinkedList<>();

		recursion(0, str.toCharArray(), delims.toCharArray(), builder, resultList);

		System.out.println(resultList.size());
		for(String result : resultList) {
			System.out.println(result);
		}
	}
}
