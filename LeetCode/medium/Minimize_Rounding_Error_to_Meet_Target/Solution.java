package medium.Minimize_Rounding_Error_to_Meet_Target;

import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.Test;

/**
 * Runtime : 30ms(15.38%)
 * Memory : 41.1mb(14.29%)
 */
public class Solution {
	@Test
	public void test() {
		//int target = 8; String[] prices = new String[]{"0.700","2.800","4.900"};
		//int target = 10; String[] prices = new String[]{"1.500","2.500","3.500"};
		int target = 11; String[] prices = new String[]{"2.000","2.000","2.000","2.000","2.000"};

		System.out.println(minimizeError(prices, target));
	}

	public String minimizeError(String[] prices, int target) {
		PriorityQueue<Double> errorQueue = new PriorityQueue<>(Comparator.comparingDouble(val -> val));

		int minSum = 0;
		int maxSum = 0;

		for(String price : prices) {
			double val = Double.parseDouble(price);
			double underVal = Double.parseDouble(String.format("%.3f",val % 1));

			minSum += val;
			maxSum += underVal == 0.0 ? val : val + 1;

			if(underVal != 0.0)
				errorQueue.offer(underVal);
		}

		if(minSum > target || target > maxSum) return "-1";

		int floorCnt = maxSum - target;

		double errorSum = 0.0;
		for(int i = 0; i < floorCnt; i++) {
			errorSum += errorQueue.poll() ;
		}

		while(!errorQueue.isEmpty()) {
			errorSum += 1.0 - errorQueue.poll();
		}

		return String.format("%.3f",errorSum);
	}
}
