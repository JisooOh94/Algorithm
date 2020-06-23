package medium.Broken_Calculator;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Runtime : 0ms(100.00%)
 * Memory : 36.1mb(65.19%)
 */
public class Solution_2 {
    @Test
    public void execute() {
        int X = 68;
        int Y = 71;
        int result_1 = brokenCalc(X, Y);

        System.out.println(result_1);
    }

    public int brokenCalc(int X, int Y) {
        if(Y <= X) {
            return X - Y;
        }

        int operationCnt = 0;
        while(X < Y) {
            operationCnt++;
            if(Y % 2 != 0) Y += 1;
            else Y /= 2;
        }

        return Y == X ? operationCnt : Y == X - 1 ? operationCnt + 1 : operationCnt + X - Y;
    }
}
