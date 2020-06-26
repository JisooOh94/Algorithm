package medium.Split_Array_into_Fibonacci_Sequence;

import org.junit.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Runtime : 1ms(99.63%)
 * Memory : 37.9mb(86.49%)
 */
public class Solution {
    @Test
    public void test() {
        //String str = "123456579";
        //String str = "11235813";
        //String str = "112358130";
        //String str = "0123";
        //String str = "1101111";
        //String str = "214748364721474836422147483641";
        String str = "539834657215398346785398346991079669377161950407626991734534318677529701785098211336528511";
        List<Integer> resultList = splitIntoFibonacci(str);
        for(int num : resultList) {
            System.out.println(num);
        }
    }

    private static final int intMax = 2147483647;
    public List<Integer> splitIntoFibonacci(String S) {
        if(S.length() < 3) return Collections.emptyList();
        List<Integer> resultList = new LinkedList<>();
        int strLength = S.length();
        int firstMaxRange = strLength % 2 == 0 ? strLength / 2 - 1 : strLength / 2;
        for(int firstIdx = 0; firstIdx < firstMaxRange; firstIdx++) {
            long firstNum = convertStr2Int(S, 0, firstIdx);
            if(firstNum > intMax) break;

            int secondIdx = firstIdx + 1;
            while(true) {
                long secondNum = convertStr2Int(S, firstIdx + 1, secondIdx);
                if(secondNum > intMax) break;

                else if(!(secondIdx < strLength - Math.max(firstIdx + 1, secondIdx - firstIdx))) break;
                int recursiveCnt = chkFibo(firstNum, secondNum, secondIdx + 1, S, 0);
                if(recursiveCnt != -1) {
                    resultList.add((int)firstNum);
                    resultList.add((int)secondNum);

                    for (int i = 0; i < recursiveCnt; i++) {
                        long nextNum = firstNum + secondNum;
                        resultList.add((int)nextNum);
                        firstNum = secondNum;
                        secondNum = nextNum;
                    }
                    return resultList;
                }
                secondIdx++;
            }
        }
        return resultList;
    }

    private int chkFibo(long firstNum, long secondNum, int startIdx, String str, int recursiveCnt) {
        if(startIdx == str.length()) return recursiveCnt;
        else if(firstNum > intMax / 2 && secondNum > intMax / 2) return - 1;

        String sumStr = String.valueOf(firstNum + secondNum);
        for(int i = startIdx; i < startIdx + sumStr.length(); i++) {
            if(sumStr.charAt(i - startIdx) !=  str.charAt(i)) {
                return -1;
            }
        }
        return chkFibo(secondNum, firstNum + secondNum, startIdx + sumStr.length(), str, recursiveCnt + 1);
    }

    private long convertStr2Int(String str, int startIdx, int endIdx) {
        return Long.parseLong(str.substring(startIdx, endIdx + 1));
    }
}
