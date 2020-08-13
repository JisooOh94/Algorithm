package medium.Video_Stitching;

import java.util.Arrays;

import org.junit.Test;

/**
 * Runtime : 1ms(86.32%)
 * Memory : 37.2mb(58.38%)
 */
public class Solution {
	@Test
	public void execute() {
		int[][] clips = new int[][]{{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}}; int T = 10;
//		int[][] clips = new int[][]{{0,1},{6,8},{0,2},{5,6},{0,4},{0,3},{6,7},{1,3},{4,7},{1,4},{2,5},{2,6},{3,4},{4,5},{5,7},{6,9}}; int T = 9;
//		int[][] clips = new int[][]{{0,4},{2,8}}; int T = 5;
//		int[][] clips = new int[][]{{0,1},{1,2}}; int T = 5;
//		int[][] clips = new int[][]{{0,2}, {4,8}}; int T = 5;
		System.out.println(videoStitching(clips, T));
	}
	public int videoStitching(int[][] clips, int T) {
		Arrays.sort(clips, (e1, e2) -> e1[0] < e2[0] ? -1 : e1[0] > e2[0] ? 1 : e1[1] < e2[1] ? -1 : e1[1] > e2[1] ? 1 : 0);

		int prevMaxEnd = 0;
		int curMaxEnd = 0;
		int clipCnt = 0;
		for(int i = 0; i < clips.length; i++) {
			if(clips[i][0] <= prevMaxEnd) {
				curMaxEnd = Math.max(curMaxEnd, clips[i][1]);
			} else {
				prevMaxEnd = curMaxEnd;
				curMaxEnd = clips[i][1];
				clipCnt++;
				if(clips[i][0] - prevMaxEnd >= 1) return -1;
			}
			if(curMaxEnd >= T) return ++clipCnt;
		}

		return -1;
	}
}
