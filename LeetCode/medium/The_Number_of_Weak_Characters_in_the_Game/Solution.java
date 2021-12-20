package medium.The_Number_of_Weak_Characters_in_the_Game;

import java.util.Arrays;

import org.junit.Test;

/**
 * Runtime : 97ms(39.51%)
 * Memory : 85.8mb(86.32%)
 * Time Complexity : O(nlogn)
 * Subject : greedy
 */
public class Solution {
	@Test
	public void init() {
//		int[][] props = new int[][]{{5,5}, {6,3}, {3,6}};
//		int[][] props = new int[][]{{2,2}, {3,3}};
		int[][] props = new int[][]{{1,5}, {10,4}, {4,3}};

		System.out.println(numberOfWeakCharacters(props));
	}
	public int numberOfWeakCharacters(int[][] props) {
		Arrays.sort(props, (e1, e2) -> e1[0] < e2[0] ? 1 : e1[0] > e2[0] ? -1 : e1[1] < e2[1] ? -1 : e1[1] > e2[1] ? 1 : 0);

		int biggest = 0;
		int cnt = 0;
		for(int i = 1; i < props.length; i++) {
			if(props[biggest][0] == props[i][0]) biggest = props[biggest][1] < props[i][1] ? i : biggest;
			else if(props[biggest][1] < props[i][1]) biggest = i;
			else if(props[i][1] < props[biggest][1]) cnt++;
		}
		return cnt;
	}
}
