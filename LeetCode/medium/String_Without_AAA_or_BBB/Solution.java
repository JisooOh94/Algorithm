package medium.String_Without_AAA_or_BBB;

import org.junit.Test;

/**
 * Runtime : 0ms(100.00%)
 * Memory : 36.7mb(67.61%)
 */
public class Solution {
    @Test
    public void test() {
        int A = 0;
        int B = 1;
        System.out.println(strWithout3a3b(A, B));
    }


    public String strWithout3a3b(int A, int B) {
        char bigW = A >= B ? 'a' : 'b';
        char smallW = A < B ? 'a' : 'b';
        int bigCnt = A >= B ? A : B;
        int smallCnt = A < B ? A : B;

        int gap = bigCnt - smallCnt;

        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < smallCnt; i++) {
            builder.append(bigW);
            if(i < gap) builder.append(bigW);
            builder.append(smallW);
        }

        for(int i = smallCnt; i < gap; i++) {
            builder.append(bigW);
        }

        return builder.toString();
    }
}
