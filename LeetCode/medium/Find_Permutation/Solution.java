package medium.Find_Permutation;

import org.junit.Test;
import util.PerformanceUtil;
import util.Predicate;

/**
 * Runtime : 131ms(5.52%)
 * Memory : 40.9mb(33.33%)
 */
public class Solution implements Predicate<int[], Object> {
    @Test
    public void execute() {
        String s= "DDIIDI";
        PerformanceUtil.calcPerformance(new Solution(), s);
    }

    @Override
    public int[] test(Object... params) {
        int[] result = findPermutation((String)params[0]);
        for(int elem : result) System.out.print(elem + " - ");
        return result;
    }


    public int[] findPermutation(String s) {
        int[] resultArr = new int[s.length() + 1];
        resultArr[0] = 1;
        int max = 1;
        int lastIdx = 1;
        for(char sign : s.toCharArray()) {
            if(sign == 'D') {
                resultArr[lastIdx] = resultArr[lastIdx - 1];
                int modifIdx = lastIdx - 1;
                while(modifIdx >= 0) {
                    resultArr[modifIdx]++;
                    if(modifIdx > 0 && s.charAt(modifIdx - 1) == 'I') break;
                    modifIdx--;
                }
                max++;
                lastIdx++;
            } else if(sign == 'I') {
                resultArr[lastIdx++] = ++max;
            }
        }

        return resultArr;
    }
}
