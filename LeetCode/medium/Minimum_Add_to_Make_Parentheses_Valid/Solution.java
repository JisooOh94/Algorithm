package medium.Minimum_Add_to_Make_Parentheses_Valid;

import org.junit.Test;
import util.PerformanceUtil;
import util.Predicate;

/**
 * Runtime : 0ms(100.0%)
 * Memory : 37mb(5.00%)
 */
public class Solution implements Predicate<Integer, Object> {
    private static final char OPENER = '(';

    @Test
    public void execute() {
        //String s = "()))((";
        String s = "()";
        PerformanceUtil.calcPerformance(new Solution(), s);
    }

    @Override
    public Integer test(Object... params) {
        return minAddToMakeValid((String)params[0]);
    }

    public int minAddToMakeValid(String S) {
        if(S == null || S.isEmpty()) return 0;
        else if(S.length() == 1) return 1;

        int waitForPair = 0;
        int exceedPair = 0;

        for(char word : S.toCharArray()) {
            if(word == OPENER) waitForPair++;
            else {
                if(waitForPair != 0) waitForPair--;
                else exceedPair++;
            }
        }

        return waitForPair + exceedPair;
    }
}
