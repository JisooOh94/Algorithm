package medium.Combination_Sum;

import util.Predicate;

import java.util.*;

/**
 * Runtime : 2ms(99.58%)
 * Memory : 39.3mb(22.23%)
 */
class Solution implements Predicate<List<List<Integer>>, Object>{
    public List<List<Integer>> test(Object... params) {
        return combinationSum((int[])params[0], (int)params[1]);
    }

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);

            if(target < candidates[0]) {
                return Collections.EMPTY_LIST;
            }

            Stack<Integer> numList = new Stack<>();
            List<List<Integer>> resultList = new LinkedList<>();

            recursion(target, 0, numList, resultList, candidates);

            return resultList;
        }

        private void recursion(int targetNum, int curIdx, Stack<Integer> numList, List<List<Integer>> resultList, int[] candidates) {
            if(targetNum == 0) {
                resultList.add(new ArrayList<>(numList));
                return;
            }

            for(int i = curIdx; i < candidates.length && candidates[i] <= targetNum; i++) {
                numList.push(candidates[i]);
                recursion(targetNum - candidates[i], i, numList, resultList, candidates);
                numList.pop();
            }
        }
}