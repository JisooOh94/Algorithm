package medium.Counting_Bits;

import org.junit.Test;

/**
 * Runtime : 2ms(37.77%)
 * Memory : 45.6mb(5.01%)
 */
public class Solution {
    @Test
    public void execute() {
        int nrr = 15;
        int[] result = countBits(nrr);
        for(int num : result) {
            System.out.print(num);
        }
    }
    public int[] countBits(int num) {
        int record[] = new int[num + 1];

        int loop = 1;
        int recordIdx = 1;
        while(loop < num + 1) {
            int loopCnt = loop * 2 > num ? (num + 1) - loop : loop;

            for(int i = 0; i < loopCnt; i++) {
                record[recordIdx++] = record[i] + 1;
            }

            loop *= 2;
        }
        return record;
    }
}
