package medium.Group_the_People_Given_the_Group_Size_They_Belong_To;

import util.Predicate;

import java.util.*;

/**
 * Runtime : 4ms(93.41%)
 * Memory : 40.4mb(100.00%)
 */
public class Solution implements Predicate<List<List<Integer>>, Object> {
    @Override
    public List<List<Integer>> test(Object... params) {
        return groupThePeople((int[])params[0]);
    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        if(groupSizes.length == 1) return Collections.singletonList(Collections.singletonList(0));
        List<List<Integer>> resultList = new LinkedList<>();
        Map<Integer, List<Integer>> listMap = new HashMap<>();

        for(int i = 0; i < groupSizes.length; i++) {
            int groupSize = groupSizes[i];

            listMap.putIfAbsent(groupSize, new LinkedList<>());
            List<Integer> groupMemberList = listMap.get(groupSize);
            groupMemberList.add(i);

            if(groupMemberList.size() == groupSize) {
                resultList.add(groupMemberList);
                listMap.put(groupSize, new LinkedList<>());
            }
        }

        return resultList;
    }
}
