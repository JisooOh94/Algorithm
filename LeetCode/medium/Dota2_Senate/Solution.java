package medium.Dota2_Senate;

import org.junit.Test;

import java.util.*;

/**
 * Runtime : 7ms(81.42%)
 * Memory : 39.5mb(86.73%)
 */
public class Solution {
    private static final char A_TEAM = 'R';

    @Test
    public void test() {
        String senate = "RRRR";

        System.out.println(predictPartyVictory(senate));
    }
    public String predictPartyVictory(String senate) {
        List<Character> list = new LinkedList<>();
        int aCnt = 0;
        int bCnt = 0;

        for(char word : senate.toCharArray()) {
            list.add(word);
            if(word == A_TEAM) aCnt++;
            else bCnt++;
        }

        int aKill = 0;
        int bKill = 0;
        while(aCnt != 0 && bCnt != 0) {
            for(Iterator<Character> iter = list.iterator(); iter.hasNext();) {
                char team = iter.next();
                if(team == A_TEAM) {
                    if(aKill != 0) {
                        aCnt--;
                        aKill--;
                        iter.remove();
                    } else {
                        bKill++;
                    }
                } else {
                    if(bKill != 0) {
                        bCnt--;
                        bKill--;
                        iter.remove();
                    } else {
                        aKill++;
                    }
                }
            }
        }
        return aCnt == 0 ? "Dire" : "Radiant";
    }
}
