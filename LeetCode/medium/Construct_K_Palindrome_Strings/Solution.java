package medium.Construct_K_Palindrome_Strings;

import org.junit.Test;
import util.PerformanceUtil;
import util.Predicate;

/**
 * Runtime : 9ms(46.87%)
 * Memory : 39.8mb(90.47%)
 */
public class Solution implements Predicate<Boolean, Object> {
    @Test
    public void execute() {
        String s = "leetcode";
        int k = 3;
        PerformanceUtil.calcPerformance(new Solution(), s, k);
    }
    @Override
    public Boolean test(Object... params) {
        return canConstruct((String)params[0], (Integer)params[1]);
    }
    public boolean canConstruct(String s, int k) {
        if(s.length() == 1) return k == 1;

        boolean exist[] = new boolean[26];

        int singleCnt = 0;
        int doubleCnt = 0;

        for(char ch : s.toCharArray()) {
            if(exist[ch - 'a']) {
                exist[ch - 'a'] = false;
                singleCnt--;
                doubleCnt++;
            } else {
                exist[ch - 'a'] = true;
                singleCnt++;
            }
        }

        if(doubleCnt != 0) {
            return singleCnt <= k && k <= (doubleCnt * 2) + singleCnt;
        } else {
            return singleCnt == k;
        }
    }
}
