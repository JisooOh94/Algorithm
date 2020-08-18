package medium.Push_Dominoes;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/**
 * Runtime : 11ms(61.87%)
 * Memory : 46.1mb	(39.97%)
 */
public class Solution_2 {
	@Test
	public void execute() {
		String str = ".L.R...LR..L..";
//		String str = "RR.L";
		System.out.println(pushDominoes(str));
	}
	public String pushDominoes(String dominoes) {
		Queue<Integer> queue = new LinkedList<>();
		char[] arr = dominoes.toCharArray();
		int[] curModified = new int[arr.length];
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != '.') queue.offer(i);
		}

		int loop = 0;
		while(!queue.isEmpty()) {
			loop++;
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				int idx = queue.poll();
				int nextIdx = arr[idx] == 'L' ? idx - 1 : idx + 1;

				if(0 <= nextIdx && nextIdx < arr.length) {
					if(arr[nextIdx] == '.') {
						arr[nextIdx] = arr[idx];
						curModified[nextIdx] = loop;
						queue.offer(nextIdx);
					} else if(arr[nextIdx] != arr[idx] && curModified[nextIdx] == loop) {
						arr[nextIdx] = '.';
					}
				}
			}
		}
		return String.valueOf(arr);
	}
}
