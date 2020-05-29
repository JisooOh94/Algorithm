package medium.Check_If_a_String_Can_Break_Another_String;

import org.junit.Test;
import util.PerformanceUtil;
import util.Predicate;

import java.util.Arrays;

/**
 * Runtime : 8ms(84.30%)
 * Memory : 40.6mb(100.00%)
 */
public class Solution implements Predicate<Boolean, Object> {
    @Test
    public void execute() {
//        String s1 = "abc";
//        String s2 = "xya";
//        String s1 = "abe";
//        String s2 = "acd";
//        String s1 = "leetcodee";
//        String s2 = "leetcodee";
        String s1= "yopumzgd";
        String s2 = "pamntyya";
        PerformanceUtil.calcPerformance(new Solution(), s1, s2);
    }

    @Test
    public void performaceTest() {
        String sampleStr = "abcdefghijklmopqrstuv";
        StringBuilder builder_1 = new StringBuilder();
        StringBuilder builder_2 = new StringBuilder();

        for(int i = 0; i < 1000; i++) {
            builder_1.append(sampleStr);
            builder_2.append(sampleStr);
        }
        builder_1.append("z");
        builder_2.append("y");

        checkIfCanBreak(builder_1.toString(), builder_2.toString());
    }

    @Override
    public Boolean test(Object... params) {
        return checkIfCanBreak((String)params[0], (String)params[1]);
    }
    public boolean checkIfCanBreak(String s1, String s2) {
        if(s1.length() == 1) return true;
        char[] arr_1 = s1.toCharArray();
        char[] arr_2 = s2.toCharArray();

        Arrays.sort(arr_1);
        Arrays.sort(arr_2);

        int idx = 0;
        int direction = 0;

        while(idx < s1.length()) {
            if(arr_1[idx] > arr_2[idx]) {
                direction = 1;
                break;
            } else if(arr_1[idx] < arr_2[idx]) {
                direction = -1;
                break;
            }
            idx++;
        }

        if(direction == 1) {
            for(int i = idx + 1; i < s1.length(); i++) {
                if(arr_1[i] < arr_2[i]) return false;
            }
            return true;
        } else if(direction == -1) {
            for(int i = idx + 1; i < s1.length(); i++) {
                if(arr_1[i] > arr_2[i]) return false;
            }
            return true;
        } else {
            return true;
        }
    }
}
