package medium.Broken_Calculator;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Time LImit Exceed
 */
public class Solution {
    @Test
    public void execute() {
        int X = 4;
        int Y = 24;
        int result = brokenCalc(X, Y);
        System.out.println(result);
    }
    public int brokenCalc(int X, int Y) {
        if(Y <= X) {
            return X - Y;
        }

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{X, 0});
        q.offer(new int[]{X - 1, 1});
        int result = 0;
        while(!q.isEmpty()) {
            int[] info = q.poll();

            if(info[0] * 2 == Y) {
                result = info[1] + 1;
                break;
            } else if(info[0] * 2 < Y) {
                q.offer(new int[]{info[0] * 2, info[1] + 1});
            }

            if(info[0] * 2 - 1 == Y) {
                result = info[1] + 2;
                break;
            } else if(info[0] * 2 - 1 < Y) {
                q.offer(new int[]{info[0] * 2 - 1, info[1] + 2});
            }
        }
        return result;
    }
}
