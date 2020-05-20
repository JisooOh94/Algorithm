package medium._4_Keys_Keyboard;

import util.Predicate;

/**
 * Runtime : 1133ms(5.07%)
 * Memory : 35.9mb(25.00%)
 */
public class Solution implements Predicate<Integer, Object> {
    @Override
    public Integer test(Object... params) {
        return maxA((int)params[0]);
    }

//    private int recursion(int cur, int buffer, int left) {
//        if(left >= 3) {
//            if(buffer != 0) {
//                int bufferUpdateScore = cur + cur * (left - 2);
//                int notUpdateScore = cur + buffer * left;
//
//                return bufferUpdateScore > notUpdateScore ? recursion(cur * 2, cur, left - 3) : recursion(cur + buffer, buffer, left - 1);
//            } else {
//                int bufferUpdateScore = cur + cur * (left - 2);
//                int notUpdateScore = cur + left;
//
//                return bufferUpdateScore > notUpdateScore ? recursion(cur * 2, cur, left - 3) : recursion(cur + 1, 0, left - 1);
//            }
//        } else {
//            return buffer == 0 ? cur + left : cur + buffer * left;
//        }
//    }

    private int recursion(int cur, int buffer, int left) {
        if(left >= 3) {
            if(buffer != 0) {
                return Math.max(recursion(cur * 2, cur, left - 3), recursion(cur + buffer, buffer, left - 1));
            } else {
                return Math.max(recursion(cur * 2, cur, left - 3), recursion(cur + 1, 0, left - 1));
            }
        } else {
            int max = buffer == 0 ? cur + left : cur + buffer * left;
            if(max == 27) {
                int a = 0;
            }
            return buffer == 0 ? cur + left : cur + buffer * left;
        }
    }


    public int maxA(int N) {
        return recursion(1, 0, N - 1);
    }
}
