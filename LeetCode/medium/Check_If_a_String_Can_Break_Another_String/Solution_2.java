package medium.Check_If_a_String_Can_Break_Another_String;

import org.junit.Test;
import util.PerformanceUtil;
import util.Predicate;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Runtime : 15ms(46.29%)
 * Memory : 40.1mb(100.00%)
 */
public class Solution_2 implements Predicate<Boolean, Object> {
    @Test
    public void execute() {
//        String s1 = "abc";
//        String s2 = "xya";
//        String s1 = "abe";
//        String s2 = "acd";
        /*String s1 = "leetcodee";
        String s2 = "interview";*/
        String s1= "yopumzgd";
        String s2 = "pamntyya";
        PerformanceUtil.calcPerformance(new Solution_2(), s1, s2);
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
        PerformanceUtil.afterTest4Print();
    }

    @Override
    public Boolean test(Object... params) {
        return checkIfCanBreak((String)params[0], (String)params[1]);
    }
    public boolean checkIfCanBreak(String s1, String s2) {
        if(s1.length() == 1) return true;
        int[] arr_1 = new int[26];
        int[] arr_2 = new int[26];
        List<Integer> idxList_1 = new LinkedList<>();
        List<Integer> idxList_2 = new LinkedList<>();

        for(int i = 0; i < s1.length(); i++) {
            if(arr_1[s1.charAt(i) - 'a'] == 0) {
                idxList_1.add(s1.charAt(i) - 'a');
            }

            if(arr_2[s2.charAt(i) - 'a'] == 0) {
                idxList_2.add(s2.charAt(i) - 'a');
            }
            arr_1[s1.charAt(i) - 'a']++;
            arr_2[s2.charAt(i) - 'a']++;
        }

        Collections.sort(idxList_1);
        Collections.sort(idxList_2);

        int idx_1 = 0;
        int idx_2 = 0;
        int prev = 0;

        while(idx_1 < idxList_1.size() && idx_2 < idxList_2.size()) {
            int char_1 = idxList_1.get(idx_1);
            int char_2 = idxList_2.get(idx_2);

            int dir = char_1 > char_2 ? 1 : char_1 < char_2 ? -1 : 0;

            if(prev != 0 && dir != 0 && dir != prev) return false;

            prev = dir == 0 ? prev : dir;

            arr_1[char_1]--;
            arr_2[char_2]--;

            if(arr_1[char_1] == 0) idx_1++;
            if(arr_2[char_2] == 0) idx_2++;
        }

        return true;
    }
}
