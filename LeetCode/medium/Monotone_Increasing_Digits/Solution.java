package medium.Monotone_Increasing_Digits;

import org.junit.Test;

/**
 * Runtime : 4ms(18.18%)
 * Memory : 36.7mb(32.74%)
 */
public class Solution {
    @Test
    public void test() {
        int N = 123454321;
        int result = monotoneIncreasingDigits(N);
        System.out.print(result);
    }
    public int monotoneIncreasingDigits(int N) {
        if(N / 10 == 0) return N;
        int[] numArr = String.valueOf(N).chars().toArray();

        int frNum;
        int reNum;
        int chIdx = -1;
        int lastIdx = numArr.length - 1;
        int charToInt = '0';
        numArr[lastIdx] -= charToInt;

        reNum = numArr[lastIdx];
        for(int i = lastIdx - 1; 0 <= i; i--) {
            numArr[i] -= charToInt;

            frNum = numArr[i];
            if(frNum > reNum) {
                chIdx = i;
                frNum--;
            }
            reNum = frNum;
        }

        if(chIdx == -1) return N;

        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < chIdx; i++) {
            builder.append(numArr[i]);
        }
        builder.append(numArr[chIdx] - 1);
        for(int i = chIdx + 1; i <= lastIdx; i++) {
            builder.append(9);
        }

        return Integer.parseInt(builder.toString());
    }
}
