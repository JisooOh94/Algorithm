package medium.Top_K_Frequent_Elements;

import util.Predicate;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Runtime : 11ms(52.75%)
 * Memory : 41.9mb(10.34%)
 */
public class Solution implements Predicate<int[], Object> {
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

        Map<Integer, Item> map = new HashMap<>();
        List<Item> list = new LinkedList<>();

        for(Integer num : nums){
            Item item = map.getOrDefault(num, new Item(num, 0));
            if(item.cnt == 0){
                list.add(item);
                map.put(num, item);
            }

            item.cnt++;
        }
        list.sort((item1, item2) -> item1.cnt > item2.cnt ? -1 : item1.cnt < item2.cnt ? 1 : 0);
        return list.subList(0,k).stream().mapToInt(item -> item.key).toArray();
    }
}
