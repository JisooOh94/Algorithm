package medium.All_Ancestors_of_a_Node_in_a_Directed_Acyclic_Graph;

import org.junit.Test;

import java.util.*;

/**
 * Runtime : 144ms(67.56%%)
 * Memory : 129.5mb(67.98%)
 * Time Complexity : O()
 */
public class Solution_2 {
    @Test
    public void execute() {
        int n = 8;
        int[][] edges = new int[][]{
                {0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}
        };

        List<List<Integer>> ancestors = getAncestors(n, edges);
        ancestors.stream().forEach(ancestor -> {
            ancestor.stream().forEach(System.out::print);
            System.out.println();
        });
    }
    private static final int FROM = 0;
    private static final int TO = 1;
    private List<Integer> recursion(int cur, List<Integer>[] parents, List<Integer>[] ancestors) {
        if(ancestors[cur] != null) return ancestors[cur];

        Set<Integer> ancestorSet = new HashSet<>();
        for(int parent : parents[cur]) {
            ancestorSet.addAll(recursion(parent, parents, ancestors));
            ancestorSet.add(parent);
        }
        List<Integer> ancestor = new ArrayList<>(ancestorSet);
        Collections.sort(ancestor);
        ancestors[cur] = ancestor;

        return ancestors[cur];
    }
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Integer>[] parents = new LinkedList[n];
        for(int i = 0; i < n; i++) parents[i] = new LinkedList<>();

        for(int[] edge : edges) parents[edge[TO]].add(edge[FROM]);

        List<Integer>[] ancestors = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            if(ancestors[i] == null) recursion(i, parents, ancestors);
        }
        return Arrays.asList(ancestors);
    }
}
