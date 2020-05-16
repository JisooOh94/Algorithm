package Top_K_Frequent_Elements;

import util.Predicate;

import java.util.*;

public class Solution_3 implements Predicate<int[], Object> {
    @Override
    public int[] test(Object... params) {
        int[] resut = topKFrequent((int[])params[0], (int)params[1]);
        for(int num : resut) {
            System.out.print(num + " ");
        }
        return resut;
    }
    public class Item implements Comparable<Item>{
        public int key;
        public int cnt;

        public Item(int key, int cnt) {
            this.key = key;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Item target) {
            return this.cnt > target.cnt ? -1 : this.cnt < target.cnt ? 1 : 0;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length == 1) return nums;
        Arrays.sort(nums);

        PriorityQueue<Item> queue = new PriorityQueue<>();

        int cur = nums[0];
        int cnt = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != cur) {
                queue.offer(new Item(cur, cnt));
                cur = nums[i];
                cnt = 1;
            } else {
                cnt++;
            }
        }

        queue.offer(new Item(cur, cnt));

        Object[] arr = queue.toArray();
        return Arrays.copyOfRange(queue.stream().mapToInt(item -> item.key).toArray(),0,k);
    }
}
