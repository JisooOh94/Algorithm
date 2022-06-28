package easy.Find_if_Path_Exists_in_Graph;

import org.junit.Test;

public class Remember_1 {
    @Test
    public void execute() {

    }
    public boolean validPath(int n, int[][] edges, int start, int end) {
        int[] rank = new int[n];
        int[] group = new int[n];
        for(int i = 0; i < n; i++) group[i] = i;

        for(int[] edge : edges) union(edge, group, rank);

        return find(start, group) == find(end, group);
    }

    private void union(int[] edge, int[] group, int[] rank) {
        int g1 = find(edge[0], group);
        int g2 = find(edge[1], group);

        if(rank[g1] > rank[g2]) group[g2] = g1;
        else if(rank[g2] > rank[g1]) group[g1] = g2;
        else {
            group[g2] = g1;
            rank[g1]++;
        }
    }

    private int find(int cur, int[] group) {
        if(cur == group[cur]) return cur;
        group[cur] = find(group[cur], group);
        return group[cur];
    }
}
