package medium.Toss_Strange_Coins;

import org.junit.Test;

/**
 * Runtime : 37ms(37.68%)
 * Memory : 60.9mb(30.44%)
 */
public class Solution {
	@Test
	public void execute() {
//		double[] prob = new double[]{0.5,0.5,0.5,0.5,0.5}; int target = 0;
//		double[] prob = new double[]{0.4}; int target = 1;
//		double[] prob = new double[]{0.2,0.8,0,0.3,0.5}; int target = 3;
		double[] prob = new double[]{1,1,1,1,1,1,1,1,1,1}; int target = 9;
		System.out.println(probabilityOfHeads(prob, target));
	}
	private double recursion(int leftHead, int curIdx, double[] prob, Double[][] record) {
		if(prob.length == curIdx && leftHead == 0) return 1.0;
		else if(record[curIdx][leftHead] != null) return record[curIdx][leftHead];

		double curProbUp = 0.0, curProbDown = 0.0;
		if(prob[curIdx] != 0.0 && leftHead != 0) {
			curProbUp = recursion(leftHead - 1, curIdx + 1, prob, record) * prob[curIdx];
		}
		if(prob[curIdx] != 1.0 && prob.length - curIdx > leftHead) {
			curProbDown = recursion(leftHead, curIdx + 1, prob, record) * (1.0 - prob[curIdx]);
		}

		record[curIdx][leftHead] = curProbUp + curProbDown;

		return curProbUp + curProbDown;
	}

	public double probabilityOfHeads(double[] prob, int target) {
		Double[][] record = new Double[prob.length][target + 1];
		return recursion(target, 0, prob, record);
	}
}
