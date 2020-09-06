package easy.Ugly_Number;

/**
 * Runtime : 1ms(100.00%)
 * Memory : 37mb(58.38%)
 */
class Solution {
	public boolean isUgly(int num) {
		if(num < 1) return false;
		while(1 < num) {
			if(num % 2 == 0) {
				num /= 2;
				continue;
			} else if(num % 3 == 0) {
				num /= 3;
				continue;
			} else if(num % 5 == 0) {
				num /= 5;
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
}
