package easy.Divisor_Game;

import org.junit.Test;

public class Solution {
    @Test
    public void test() {
        System.out.println(divisorGame(5));
    }

    private static final int ALICE = 1;

    public boolean recursion(int num, int turn) {
        if(num <= 1) return turn == ALICE ? false : true;

        for(int i = 1; i < num; i++) {
            if(num % i == 0 && recursion(num - i, turn * -1)) {
                return true;
            }
        }
        return false;
    }

    public boolean divisorGame(int N) {
        return recursion(N, ALICE);
    }

//    public boolean divisorGame(int n) {
//        for(int x=1; x < n; x++)
//            if(n % x == 0 && !divisorGame(n-x)) //if Bob fails, Alice wins
//                return true;
//        return false;
//    }
}
