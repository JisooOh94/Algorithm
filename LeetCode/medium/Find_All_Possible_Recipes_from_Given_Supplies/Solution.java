package medium.Find_All_Possible_Recipes_from_Given_Supplies;

import jdk.internal.org.objectweb.asm.Handle;
import org.junit.Test;

import java.util.*;

/**
 * Runtime : 1143ms (5.02%)
 * Memory : 119.2mb (5.13%)
 */
public class Solution {
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
    private boolean recursion(int cur, List<Integer>[] childList, boolean[] visited, Boolean[] isReachable) {
        if(isReachable[cur] != null) return isReachable[cur];

        if(childList[cur].isEmpty()) isReachable[cur] = true;
        else if(visited[cur]) isReachable[cur] = false;
        else {
            visited[cur] = true;
            for (int child : childList[cur]) {
                if (!recursion(child, childList, visited, isReachable)) {
                    isReachable[cur] = false;
                    break;
                }
            }
            if(isReachable[cur] == null) isReachable[cur] = true;
        }
        return isReachable[cur];
    }
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n = recipes.length;
        Map<String, Integer> recipeIdxMap = new HashMap<>();
        for(int i = 0; i < n; i++) {
            recipeIdxMap.put(recipes[i], i);
        }

        Boolean[] isReachable = new Boolean[n];
        List<Integer>[] childList = new LinkedList[n];
        for(int i = 0; i < n; i++) {
            childList[i] = new LinkedList<>();
            for(String childStr : ingredients.get(i)) {
                Integer child = recipeIdxMap.get(childStr);
                if(child != null) childList[i].add(child);
                else if(Arrays.stream(supplies).noneMatch(s -> s.equals(childStr))) {
                    isReachable[i] = false;
                    break;
                }
            }
        }

        List<String> result = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(isReachable[i] == null) {
                recursion(i, childList, new boolean[n], isReachable);
            }
            if(isReachable[i]) result.add(recipes[i]);
        }

        return result;
    }
}