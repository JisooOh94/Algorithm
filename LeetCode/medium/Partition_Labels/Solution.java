package medium.Partition_Labels;

import org.junit.Test;

import java.util.*;

public class Solution {
    @Test
    public void test() {
        List<Integer> result = partitionLabels("ababcbacadefegdehijhklij");

        System.out.println(result);
    }

    private int binarySearch(Integer[] arr, int target, int fromIdx) {
        int resultIdx = Arrays.binarySearch(arr, fromIdx, arr.length, target);

        if(resultIdx < 0) {
            resultIdx = resultIdx * -1 - 2;
        }

        return resultIdx;
    }

    private int recursion(Integer[] startIdxArr, Integer[] endIdxArr, int startIdx, int targetValue) {
        int range = binarySearch(startIdxArr, targetValue, startIdx) ;

        int endIdxCand = endIdxArr[startIdx];
        for(int i = startIdx + 1; i <= range; i++) {
            if(endIdxCand < endIdxArr[i]) endIdxCand = endIdxArr[i];
        }

        if(endIdxCand == endIdxArr[startIdx]) return range;

        return recursion(startIdxArr, endIdxArr, range + 1, endIdxCand);
    }

    public List<Integer> partitionLabels(String S) {
        Map<Character, Integer> wordMap = new HashMap<>();
        List<Integer> startIdxList = new ArrayList<>();
        List<Integer> endIdxList = new ArrayList<>();

        for(int i = 0; i < S.length(); i++) {
            char word = S.charAt(i);
            int idx = wordMap.getOrDefault(word, -1);
            if(idx != -1) endIdxList.set(idx, i);
            else {
                wordMap.put(word, startIdxList.size());
                startIdxList.add(i);
                endIdxList.add(i);
            }
        }

        Integer[] startIdxArr = new Integer[startIdxList.size()];
        startIdxList.toArray(startIdxArr);

        Integer[] endIdxArr = new Integer[endIdxList.size()];
        endIdxList.toArray(endIdxArr);

        int idx = 0;
        List<Integer> resultList = new LinkedList<>();

        while(idx < startIdxArr.length) {
            idx = recursion(startIdxArr, endIdxArr, idx, endIdxArr[idx]);
            resultList.add(endIdxArr[idx++] + 1);
        }

        return resultList;
    }
}
