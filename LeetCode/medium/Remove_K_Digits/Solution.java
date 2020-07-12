package medium.Remove_K_Digits;

import org.junit.Test;

/**
 * Runtime : 33ms(16.89%)
 * Memory : 39.8mb(51.12%)
 */
public class Solution {
    @Test
    public void test() {
        //String num = "1432219"; int k = 3;
        String num = "10200"; int k = 1;
        //String num = "10"; int k = 2;
        //String num = "112"; int k = 1;
        System.out.println(removeKdigits(num, k));
    }

    public String removeKdigits(String num, int k) {
        if(num.length() == k) return "0";
        int fromIdx = 0, toIdx;
        StringBuilder builder = new StringBuilder();

        while(k != 0) {
            toIdx = fromIdx + k;
            int min = 1000, minIdx = 0;
            for(int i = fromIdx; i <= toIdx; i++) {
                if(num.charAt(i) < min) {
                    minIdx = i;
                    min = num.charAt(i);
                }
            }
            builder.append(num.charAt(minIdx));
            k -= minIdx - fromIdx;
            fromIdx = minIdx + 1;
            if(num.length() - fromIdx == k) return builder.toString();
        }

        String result = builder.toString() + num.substring(fromIdx);
        int zeroRemoveIdx = result.length() - 1;
        for(int i = 0; i < result.length(); i++) {
            if(result.charAt(i) != '0') {
                zeroRemoveIdx = i;
                break;
            }
        }

        return result.substring(zeroRemoveIdx);
    }
}
