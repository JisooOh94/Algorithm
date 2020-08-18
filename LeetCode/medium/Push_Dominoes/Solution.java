package medium.Push_Dominoes;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/**
 * Runtime : 12ms(58.42%)
 * Memory : 44.6mb(44.43%)
 */
public class Solution {
	@Test
	public void execute() {
//		String str = ".L.R...LR..L..";
		String str = "RR.L";
		System.out.println(pushDominoes(str));
	}
	public String pushDominoes(String dominoes) {
		Queue<Integer> queue = new LinkedList<>();
		char[] arr = dominoes.toCharArray();
		boolean[] curModified = new boolean[arr.length];
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != '.') queue.offer(i);
		}

		while(!queue.isEmpty()) {
			int size = queue.size();
			curModified = new boolean[arr.length];

			for(int i = 0; i < size; i++) {
				int idx = queue.poll();
				if(arr[idx] == 'L' && 0 < idx) {
					int nextIdx = idx - 1;
					if(arr[nextIdx] == '.') {
						arr[nextIdx] = 'L';
						curModified[nextIdx] = true;
						queue.offer(nextIdx);
					} else if(arr[nextIdx] == 'R' && curModified[nextIdx]) {
						arr[nextIdx] = '.';
					}
				} else if(arr[idx] == 'R' && idx < arr.length - 1) {
					int nextIdx = idx + 1;
					if(arr[nextIdx] == '.') {
						arr[nextIdx] = 'R';
						curModified[nextIdx] = true;
						queue.offer(nextIdx);
					} else if(arr[nextIdx] == 'L' && curModified[nextIdx]) {
						arr[nextIdx] = '.';
					}
				}
			}
		}

		return String.valueOf(arr);
	}
}
