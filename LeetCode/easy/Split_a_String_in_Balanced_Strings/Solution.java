package easy.Split_a_String_in_Balanced_Strings;

import util.Predicate;

/**
 * Runtime : 0ms(100.00%)
 * Memory : 37.6mb(100.00%)
 */
public class Solution implements Predicate<Integer, Object> {
    private static final char R = 'R';
    @Override
    public Integer test(Object... params) {
        return balancedStringSplit((String)params[0]);
    }

    public int balancedStringSplit(String s) {
        if(s == null || s.isEmpty()) return 0;

        int cnt = 0;
        int totalCnt = 0;
        for(char word : s.toCharArray()) {
            cnt += word == R ? 1 : -1;

            if(cnt == 0) {
                totalCnt++;
            }
        }

        return totalCnt;
    }
}
