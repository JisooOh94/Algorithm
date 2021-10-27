import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

/**
 * Time Complexity : O(nlogn)
 */
public class Solution_3 {
	@Test
	public void test() {
		String inputAdress = "255255255255";
		int[] addresses = new int[4];
		List<String> resultList = new LinkedList<>();
		recursion(0, inputAdress, 0, addresses, resultList);
		for(String address : resultList) {
			System.out.println(address);
		}
	}

	private static void recursion(int curIdx, String str, int curPart, int[] adresses, List<String> resultList) {
		if(curPart == 4 && curIdx == str.length()) {
			resultList.add(adresses[0] + "." + adresses[1] + "." + adresses[2] + "." + adresses[3]);
			return;
		} else if ((curPart == 4 && curIdx != str.length()) || (curPart != 4 && curIdx == str.length())) {
			return;
		}

		if (str.charAt(curIdx) == '0') {
			adresses[curPart] = 0;
			recursion(curIdx + 1, str, curPart + 1, adresses, resultList);
		} else {
			if (curIdx + 3 <= str.length() && (str.charAt(curIdx) == '1' || str.charAt(curIdx) == '2')) {
				int address = Integer.parseInt(str.substring(curIdx, curIdx + 3));
				if (address <= 255) {
					adresses[curPart] = address;
					recursion(curIdx + 3, str, curPart + 1, adresses, resultList);
				}
			}

			if (curIdx + 2 <= str.length()) {
				adresses[curPart] = Integer.parseInt(str.substring(curIdx, curIdx + 2));
				recursion(curIdx + 2, str, curPart + 1, adresses, resultList);
			}

			adresses[curPart] = Character.getNumericValue(str.charAt(curIdx));
			recursion(curIdx + 1, str, curPart + 1, adresses, resultList);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inputAdress = sc.next();

		int[] addresses = new int[4];
		List<String> resultList = new LinkedList<>();
		recursion(0, inputAdress, 0, addresses, resultList);
		Collections.sort(resultList);
		System.out.println(resultList.size());
		for(String address : resultList) {
			System.out.println(address);
		}
	}
}
