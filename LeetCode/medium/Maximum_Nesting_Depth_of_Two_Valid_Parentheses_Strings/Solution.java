package medium.Maximum_Nesting_Depth_of_Two_Valid_Parentheses_Strings;

import org.junit.Test;
import util.PerformanceUtil;
import util.Predicate;

/**
 * Runtime : 1ms(98.59%)
 * Memory : 39.3mb(100.00%)
 */
public class Solution implements Predicate<int[], Object> {
    @Test
    public void execute() {
//        String seq = "(()())";
        String seq = "()(())()";
        PerformanceUtil.calcPerformance(new Solution(), seq);
    }
    @Override
    public int[] test(Object... params){
        int[] result = maxDepthAfterSplit((String)params[0]);
        for(int num : result ) System.out.print(num);
        return result;
    }

    private static final char OPENER = '(';
    private static final char CLOSER = ')';
    public int[] maxDepthAfterSplit(String seq) {
        int aCnt = 0;
        int bCnt = 0;
        int[] resultArr = new int[seq.length()];

        for(int i = 0; i < seq.length(); i++) {
            if(seq.charAt(i) == OPENER) {
                if(aCnt <= bCnt) {
                    aCnt++;
                    resultArr[i] = 0;
                } else {
                    bCnt++;
                    resultArr[i] = 1;
                }
            } else {
                if(aCnt <= bCnt) {
                    bCnt--;
                    resultArr[i] = 1;
                } else {
                    aCnt--;
                    resultArr[i] = 0;
                }
            }
        }

        return resultArr;
    }
}
