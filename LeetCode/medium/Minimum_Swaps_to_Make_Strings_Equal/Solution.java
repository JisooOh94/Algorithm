package medium.Minimum_Swaps_to_Make_Strings_Equal;

import org.junit.Test;
import util.PerformanceUtil;
import util.Predicate;

/**
 * Runtime : 0ms(100.00%)
 * Memory : 37.2mb(73.72%)
 */
public class Solution implements Predicate<Integer, Object> {
    @Test
    public void execute() {
        String s1 = "xx";
        String s2 = "xy";

        PerformanceUtil.calcPerformance(new Solution(), s1, s2);
    }
    @Override
    public Integer test(Object... params) {
        return minimumSwap((String)params[0], (String)params[1]);
    }

    public int minimumSwap(String s1, String s2) {
        int[] diffCnt = new int[2];

        int length = s1.length();

        for(int i = 0; i < length; i++) {
            char s1Char = s1.charAt(i);
            char s2Char = s2.charAt(i);

            if(s1Char != s2Char) {
                diffCnt[s1Char - 'x']++;
            }
        }
        int result = 0;
        int left = 0;
        for(int cnt : diffCnt) {
            result += cnt / 2;
            left += cnt % 2;
        }
        if(left % 2 != 0) return -1;
        result += left;

        return result;
    }
}
