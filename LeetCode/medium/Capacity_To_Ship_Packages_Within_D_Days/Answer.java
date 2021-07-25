package medium.Capacity_To_Ship_Packages_Within_D_Days;

import org.junit.Test;

/**
 * Runtime : 9ms(59.42%)
 * Memory : 41.8mb(89.29%)
 * Time Complexity : O(n)
 * Subject : binary search
 */
public class Answer {
	@Test
	public void execute() {
		int[] weights = new int[]{1,2,3,4,5,6,7,8,9,10};
		int D = 5;
		System.out.println(shipWithinDays(weights, D));
	}

	public int shipWithinDays(int[] weights, int D) {
		int left = 0, right = 0;
		for(int weight : weights) {
			left = Math.max(left, weight);
			right += weight;
		}

		int prevLeft = 0;
		int prevRight = 0;
		while (true) {
			int mid = (left + right) / 2;
			int need = 1;
			int curSum = 0;
			for(int weight : weights) {
				if(curSum + weight > mid) {
					need++;
					if(need > D) break;
					curSum = 0;
				}
				curSum += weight;
			}
			prevLeft = left;
			prevRight = right;

			if(need > D) left = mid;
			else right = mid;
			if(prevLeft == left && prevRight == right) return right;
		}
	}
}
