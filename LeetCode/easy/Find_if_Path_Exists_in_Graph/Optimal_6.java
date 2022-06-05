package easy.Find_if_Path_Exists_in_Graph;

import org.junit.Test;

/**
 * Runtime : 13ms(96.79%)
 * Memory : 98mb(97.75%)
 * Subject : DisjointSet(array + Path Compression + Rank Compression)
 * Time Complexity : O(E log V)
 */
public class Optimal_6 {
    @Test
    public void execute() {
        int n = 3;
        int[][] edges = new int[][]{
                {0,1},
                {1,2},
                {2,0}
        };
        int source = 0;
        int destination = 2;
        System.out.println(validPath(n, edges, source, destination));
    }
    private int find(int cur, int[] groups) {
        if(groups[cur] != cur) groups[cur] = find(groups[cur], groups);
        return groups[cur];
    }

    private void union(int from, int to, int[] groups, int[] rank) {
        int fromGroup = find(from, groups);
        int toGroup = find(to, groups);

        if(rank[fromGroup] > rank[toGroup]) {
            groups[toGroup] = fromGroup;
        } else if(rank[toGroup] > rank[fromGroup]) {
            groups[fromGroup] = toGroup;
        } else {
            groups[fromGroup] = toGroup;
            rank[toGroup]++;
        }
    }

    public boolean validPath(int n, int[][] edges, int start, int end) {
        if(n == 1) return true;

        int[] groups = new int[n];
        int[] rank = new int[n];
        for(int i = 0; i < n; i++) groups[i] = i;
        for(int[] edge : edges) {
            union(edge[0], edge[1], groups, rank);
        }

        return find(start, groups) == find(end, groups);
    }
}
