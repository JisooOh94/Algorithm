package medium.Top_K_Frequent_Words;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Runtime : 13ms(8.02%)
 * Memory : 39.4mb(58.93%)
 */
public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Arrays.sort(words);
        Map<String, Integer> countMap = new LinkedHashMap<>();

        for(String word : words) {
            countMap.put(word,countMap.getOrDefault(word, 0) + 1);
        }

        List<Map.Entry<String, Integer>> sortedList = new LinkedList<>(countMap.entrySet());

        Collections.sort(sortedList, (Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) -> e1.getValue() > e2.getValue() ? -1 : e1.getValue() < e2.getValue() ? 1 : 0);

        return sortedList.subList(0, k).stream().map(Map.Entry::getKey).collect(Collectors.toList());
    }

    @Test
    public void test() {
//        String[] samples = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        String[] samples = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k = 4;
        List<String> sortedList = topKFrequent(samples, k);

        System.out.println(sortedList);
    }
}
