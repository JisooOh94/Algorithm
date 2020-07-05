package medium.Cinema_Seat_Allocation;

import org.junit.Test;

import java.util.Arrays;

/**
 * Runtime : 34ms(23.99%)
 * Memory : 47.4mb(33.64%)
 */
public class Solution {
    @Test
    public void test() {
        //int n = 3; int[][] reservedSeats = new int[][]{{1,2},{1,3},{1,8},{2,6},{3,1},{3,10}};
//        int n = 2; int[][] reservedSeats = new int[][]{{2,1},{1,8},{2,6}};
        int n = 4; int[][] reservedSeats = new int[][]{{4,3},{1,4},{4,6},{1,7}};
        System.out.println(maxNumberOfFamilies(n, reservedSeats));
    }

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int max = n * 2;
        Arrays.sort(reservedSeats, (e1, e2) -> e1[0] > e2[0] ? 1 : e1[0] < e2[0] ? -1 : e1[1] > e2[1] ? 1 : e1[1] < e2[1] ? -1 : 0);

        int curRow = reservedSeats[0][0];
        int idx = 0;
        boolean failCase1, failCase2, failCase3;
        failCase1 = failCase2 = failCase3 = false;
        while(idx < reservedSeats.length) {
            if(curRow != reservedSeats[idx][0]) {
                curRow = reservedSeats[idx][0];
                if(failCase1 && failCase2 && failCase3) max -= 2;
                else if(failCase1 || failCase2 || failCase3) max -= 1;
                failCase1 = failCase2 = failCase3 = false;
            }

            if(reservedSeats[idx][1] == 2 || reservedSeats[idx][1] == 3) failCase1 = true;
            else if(reservedSeats[idx][1] == 4 || reservedSeats[idx][1] == 5) { failCase1 = true; failCase2 = true; }
            else if(reservedSeats[idx][1] == 6 || reservedSeats[idx][1] == 7) { failCase2 = true; failCase3 = true; }
            else if(reservedSeats[idx][1] == 8 || reservedSeats[idx][1] == 9) failCase3 = true;
            idx++;
        }

        if(failCase1 && failCase2 && failCase3) max -= 2;
        else if(failCase1 || failCase2 || failCase3) max -= 1;

        return max;
    }
}
