package easy.Find_if_Path_Exists_in_Graph;

import org.junit.Test;

/**
 * Runtime : 46ms(88.78%)
 * Memory : 145.2mb(73.85%)
 * Subject : DisjointSet(Tree + Rank Compression + Path Compression)
 */
public class Optimal_4 {
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

    public static class Node {
        Node parent;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node find(Node cur) {
        if(cur.parent != null) cur.parent = find(cur.parent);
        return cur.parent == null ? cur : cur.parent;
    }

    private void union(Node from, Node to, int[] rank) {
        Node fromRoot = find(from);
        Node toRoot = find(to);

        if(fromRoot != toRoot) {
            if(rank[fromRoot.val] > rank[toRoot.val]) {
                toRoot.parent = fromRoot;
            } else if(rank[toRoot.val] > rank[fromRoot.val]) {
                fromRoot.parent = toRoot;
            } else {
                fromRoot.parent = toRoot;
                rank[toRoot.val]++;
            }
        }
    }

    public boolean validPath(int n, int[][] edges, int start, int end) {
        if(n == 1) return true;

        Node[] disjoinSet = new Node[n];
        int[] rank = new int[n];
        for(int[] edge : edges) {
            Node from = disjoinSet[edge[0]];
            if(from == null) {
                from = new Node(edge[0]);
                disjoinSet[edge[0]] = from;
                rank[edge[0]] = 1;
            }
            Node to = disjoinSet[edge[1]];
            if(to == null) {
                to = new Node(edge[1]);
                disjoinSet[edge[1]] = to;
                rank[edge[1]] = 1;
            }

            union(from, to, rank);
        }

        return find(disjoinSet[start]) == find(disjoinSet[end]);
    }
}
