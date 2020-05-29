package medium.Check_If_a_String_Can_Break_Another_String;

import org.junit.Test;
import util.PerformanceUtil;
import util.Predicate;

/**
 * 천재인가..
 * Runtime : 5ms(99.44%)
 * Memory : 40.2mb(100.00%)
 */
public class Best implements Predicate<Boolean, Object> {
    @Test
    public void execute() {
//        String s1 = "abc";
//        String s2 = "xya";
        String s1 = "abe";
        String s2 = "acd";
//        String s1 = "leetcodee";
//        String s2 = "interview";
//        String s1= "yopumzgd";
//        String s2 = "pamntyya";
        PerformanceUtil.calcPerformance(new Best(), s1, s2);
    }

    @Override
    public Boolean test(Object... params) {
        return checkIfCanBreak((String)params[0], (String)params[1]);
    }

    public boolean checkIfCanBreak(String s1, String s2) {
        int[] count = new int[26];
        for (char c : s1.toCharArray()) count[c - 'a']++;
        for (char c : s2.toCharArray()) count[c - 'a']--;

        int sum = 0;
        boolean positive = false, negative = false;

        for (int c : count) {
            sum += c;
            if (sum > 0) positive = true;
            else if (sum < 0) negative = true;
        }
        return !positive || !negative;
    }
}
