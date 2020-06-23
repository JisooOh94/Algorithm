package medium.Boats_to_Save_People;

import org.junit.Test;

import java.util.Arrays;

/**
 * Runtime : 15ms(30.15%)
 * Memory : 47.1mb(83.86%)
 */
public class Solution {
    @Test
    public void execute() {
        int[] param_1 = new int[]{3,5,3,4};
        int param_2 = 3;

        int result = numRescueBoats(param_1, param_2);
        System.out.println(result);
    }
    public int numRescueBoats(int[] people, int limit) {
        if(people.length <= 1) return people.length;

        Arrays.sort(people);

        int boatCnt = 0;
        int frontIdx = 0;
        int rearIdx = people.length - 1;

        for(; frontIdx < rearIdx; frontIdx++) {
            int frontW = people[frontIdx];
            boolean found = false;
            while(frontIdx < rearIdx) {
                int rearW = people[rearIdx--];
                boatCnt++;

                if(frontW + rearW <= limit) {
                    found = true;
                    break;
                }
            }

            if(!found) {
                boatCnt++;
            }
        }
        if(frontIdx == rearIdx) boatCnt++;

        return boatCnt;
    }
}
