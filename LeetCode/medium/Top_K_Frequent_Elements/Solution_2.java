package medium.Top_K_Frequent_Elements;

import util.Predicate;

import java.util.*;

/**
 * RUntime : 9ms(86.53%)
 * Memory : 42.5mb(7.76%)
 */
public class Solution_2 implements Predicate<int[], Object> {
    @Override
    public int[] test(Object... params) {
        int[] resut = topKFrequent((int[])params[0], (int)params[1]);
        for(int num : resut) {
            System.out.print(num + " ");
        }
        return resut;
    }
    public class Item {
        public int key;
        public int cnt;

        public Item(int key, int cnt) {
            this.key = key;
            this.cnt = cnt;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length == 1) return nums;

        List<Item> list = new LinkedList<>();
        Arrays.sort(nums);

        int cur = nums[0];
        int cnt = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != cur) {
                list.add(new Item(cur, cnt));
                cur = nums[i];
                cnt = 1;
            } else {
                cnt++;
            }
        }

        list.add(new Item(cur, cnt));

        list.sort((item1, item2) -> item1.cnt > item2.cnt ? -1 : item1.cnt < item2.cnt ? 1 : 0);
        return list.subList(0,k).stream().mapToInt(item -> item.key).toArray();
    }
}
