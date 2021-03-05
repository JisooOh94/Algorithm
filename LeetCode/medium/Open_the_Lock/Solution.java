package medium.Open_the_Lock;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Runtime : 23ms(92.78%
 * Memory : 39.8mb(92.45%)
 */
public class Solution {
	public int openLock(String[] deadends, String target) {
		if(target.equals("0000")) return 0;
		boolean[][][][] visited = new boolean[10][10][10][10];
		visited[0][0][0][0] = true;

		int[] targetCode = new int[]{target.charAt(0) - '0', target.charAt(1) - '0', target.charAt(2) - '0', target.charAt(3) - '0'};

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[]{0,0,0,0});

		for(String dead : deadends) {
			if(dead.equals("0000")) return -1;
			visited[dead.charAt(0) - '0'][dead.charAt(1) - '0'][dead.charAt(2) - '0'][dead.charAt(3) - '0'] = true;
		}

		int turnCnt = 0;
		while(!queue.isEmpty()) {
			turnCnt++;
			int nodeCnt = queue.size();
			for(int loop  = 0; loop < nodeCnt; loop++) {
				int[] cur = queue.poll();
				for(int i = 0; i < 4; i++) {
					int[] newCodeAdd = getModifCode(cur, i, 1);
					int[] newCodeSub = getModifCode(cur, i, -1);
					if(!visited[newCodeAdd[0]][newCodeAdd[1]][newCodeAdd[2]][newCodeAdd[3]]) {
						if(Arrays.equals(newCodeAdd, targetCode)) return turnCnt;
						visited[newCodeAdd[0]][newCodeAdd[1]][newCodeAdd[2]][newCodeAdd[3]] = true;
						queue.offer(newCodeAdd);
					}
					if(!visited[newCodeSub[0]][newCodeSub[1]][newCodeSub[2]][newCodeSub[3]]) {
						if(Arrays.equals(newCodeSub, targetCode)) return turnCnt;
						visited[newCodeSub[0]][newCodeSub[1]][newCodeSub[2]][newCodeSub[3]] = true;
						queue.offer(newCodeSub);
					}
				}
			}
		}
		return -1;
	}

	private int[] getModifCode(int[] cur, int idx, int delta) {
		int[] newCode = Arrays.copyOf(cur, cur.length);
		if(newCode[idx] == 0 && delta == -1) {
			newCode[idx] = 9;
		} else if(newCode[idx] == 9 && delta == 1) {
			newCode[idx] = 0;
		} else {
			newCode[idx] += delta;
		}
		return newCode;
	}
}
