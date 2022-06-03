package easy.Find_if_Path_Exists_in_Graph;

import org.junit.Test;

/**
 * Runtime : 54ms(87.30%)
 * Memory : 192.9mb(50.03%)
 * Subject : DisjointSet(Tree)
 */
public class Optimal_2 {
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
        return cur.parent == null ? cur : find(cur.parent);
    }

    private void union(Node from, Node to) {
        Node fromRoot = find(from);
        Node toRoot = find(to);

        if(fromRoot != toRoot) toRoot.parent = fromRoot;
    }

    public boolean validPath(int n, int[][] edges, int start, int end) {
        if(n == 1) return true;
        Node[] disjoinSet = new Node[n];
        for(int[] edge : edges) {
            Node from = disjoinSet[edge[0]];
            if(from == null) {
                from = new Node(edge[0]);
                disjoinSet[edge[0]] = from;
            }
            Node to = disjoinSet[edge[1]];
            if(to == null) {
                to = new Node(edge[1]);
                disjoinSet[edge[1]] = to;
            }

            union(from, to);
        }

        return find(disjoinSet[start]) == find(disjoinSet[end]);
    }
}
