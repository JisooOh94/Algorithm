package medium.Find_All_Possible_Recipes_from_Given_Supplies;

import org.junit.Test;
import sun.awt.image.ImageWatched;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Runtime : 432 ms (14.62%)
 * Memory : 76.2 MB(52.73%)
 * Subject : Topological sort
 */
public class Solution_2 {
    @Test
    public void execute() {
//        String[] recipes = new String[]{"bread","sandwich","burger"};
//        List<List<String>> ingredients = Arrays.asList(
//                Arrays.asList("yeast","flour"),
//                Arrays.asList("bread","meat"),
//                Arrays.asList("sandwich","meat","bread")
//        );
//        String[] supplies = new String[]{"yeast","flour","meat"};
        String[] recipes = new String[]{"a","b"};
        List<List<String>> ingredients = Arrays.asList(
                Arrays.asList("b"),
                Arrays.asList("a")
        );
        String[] supplies = new String[]{"c"};
        findAllRecipes(recipes, ingredients, supplies).stream().forEach(System.out::println);
    }
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n = recipes.length;
        List<String> supplyList = new ArrayList<>(Arrays.asList(supplies));
        Map<String, Integer> strIdxMap = IntStream.range(0, n).boxed().collect(Collectors.toMap(idx -> recipes[idx], idx -> idx));

        List<Integer>[] parentList = new LinkedList[n];
        for(int i = 0; i < n; i++) parentList[i] = new LinkedList<>();
        int[] incoming = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        List<String> result = new LinkedList<>();
        for(int parentIdx = 0; parentIdx < n; parentIdx++) {
            List<String> childList = ingredients.get(parentIdx);
            for(String child : childList) {
                if(strIdxMap.containsKey(child)) {
                    parentList[strIdxMap.get(child)].add(parentIdx);
                    incoming[parentIdx]++;
                } else if(!supplyList.contains(child)) {
                    incoming[parentIdx] = Integer.MAX_VALUE;
                    break;
                }
            }
            if(incoming[parentIdx] == 0) {
                queue.offer(parentIdx);
                result.add(recipes[parentIdx]);
            }
        }

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int parent : parentList[cur]) {
                incoming[parent]--;
                if(incoming[parent] == 0) {
                    queue.offer(parent);
                    result.add(recipes[parent]);
                }
            }
        }

        return result;
    }
}