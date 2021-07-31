package medium.Maximum_Average_Pass_Ratio;

import java.util.Iterator;
import java.util.PriorityQueue;

import org.junit.Test;

/**
 * Runtime : 267ms(99.26ms)
 * Memory : 94.2mb(79.26%)
 * Time Complexity : O(n)
 * Subject : greedy
 */
public class Solution {
	@Test
	public void execute() {
//		int[][] classes = new int[][]{{1,2}, {3,5}, {2,2}};

		int[][] classes = new int[][]{
				{2,4},
				{3,9},
				{4,5},
				{2,10}
		};

		int extraStudents = 4;

		System.out.println(maxAverageRatio(classes, extraStudents));
	}
	private double getDiff(double fromC, double fromP) {
		return ((fromC + 1) / (fromP + 1)) - (fromC / fromP);
	}
	public double maxAverageRatio(int[][] classes, int extraStudents) {
		PriorityQueue<double[]> queue = new PriorityQueue<>((e1, e2) -> e1[2] > e2[2] ? -1 : e1[2] < e2[2] ? 1 : 0);
		for(int[] classInfo : classes) {
			queue.offer(new double[]{classInfo[0], classInfo[1], getDiff(classInfo[0], classInfo[1])});
		}

		for(int i = 0; i < extraStudents; i++) {
			double[] cur = queue.poll();
			cur[0] += 1;
			cur[1] += 1;
			cur[2] = getDiff(cur[0], cur[1]);

			queue.offer(cur);
		}

		double sum = 0;
		for(Iterator<double[]> iter = queue.iterator(); iter.hasNext();) {
			double[] cur = iter.next();
			sum += cur[0] / cur[1];
		}
		return sum / classes.length;
	}
}
