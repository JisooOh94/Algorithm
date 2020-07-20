package medium.Minimum_Cost_Tree_From_Leaf_Values;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.*;

/**
 * TLE
 */
public class Solution {
    @Test
    public void execute() {
//        int[] arr = new int[]{6, 2, 4, 8};
        int[] arr = new int[]{1,10,11,8,12,14,1,15,3,11,6,12};
        System.out.println(mctFromLeafValues(arr));
    }

    public int mctFromLeafValues(int[] arr) {
        List<Integer> list = new LinkedList<Integer>();
        Map<String, Integer> record = new HashMap<>();
        for(int num : arr) {
            list.add(num);
        }
        return recursion(list, record);
    }

    private int recursion(List<Integer> leaf, Map<String, Integer> record) {
        String key = leaf.toString();
        int recorded = record.getOrDefault(key, -1);
        if(recorded != -1) {
            return recorded;
        }

        if(leaf.size() == 2) return leaf.get(0) * leaf.get(1);

        int minSum = 999999;

        for(int prevIdx = 0; prevIdx < leaf.size() - 1; prevIdx++) {
            int nextIdx = prevIdx + 1;

            int prevLeaf = leaf.get(prevIdx);
            int nextLeaf = leaf.get(nextIdx);

            int sum = prevLeaf * nextLeaf;

            if(prevLeaf > nextLeaf) {
                leaf.remove(nextIdx);
                sum += recursion(leaf, record);
                leaf.add(nextIdx, nextLeaf);
            } else {
                leaf.remove(prevIdx);
                sum += recursion(leaf, record);
                leaf.add(prevIdx, prevLeaf);
            }

            if(sum < minSum) {
                minSum = sum;
            }
        }

        record.put(key, minSum);

        return minSum;
    }
}
