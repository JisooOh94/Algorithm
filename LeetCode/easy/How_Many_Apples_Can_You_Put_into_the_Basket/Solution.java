package easy.How_Many_Apples_Can_You_Put_into_the_Basket;

import org.junit.Test;
import util.PerformanceUtil;
import util.Predicate;

import java.util.Arrays;

/**
 * Runtime : 1ms(97.26%)
 * Memory : 39.1mb(100.00%)
 */
public class Solution implements Predicate<Integer, Object> {
    @Test
    public void execute() {
        int[] weightArr = new int[]{100,200,150,1000};
        PerformanceUtil.calcPerformance(new Solution(), (Object)weightArr);
    }

    @Override
    public Integer test(Object... params) {
        return maxNumberOfApples((int[])params[0]);
    }

    private int max = 5000;
    public int maxNumberOfApples(int[] arr) {
        if(arr.length == 1) return arr[0] <= max ? 1 : 0;

        Arrays.sort(arr);

        int lastIdx = arr.length - 1;
        if(arr[lastIdx] <= max && (arr[lastIdx] * 2 - arr.length + 1) / 2  * arr.length <= max) return arr.length;
        else if(max < arr[0]) return 0;
        else if(arr[0] == max) return 1;

        int count = 0;

        for(int weight : arr) {
            max -= weight;
            if(max < 0) return count;
            count++;
        }

        return count;
    }
}
