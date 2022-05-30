package easy.Find_if_Path_Exists_in_Graph;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Runtime : 103ms(75.17%)
 * Memory : 190.4mb(54.10%)
 * Subject : BFS
 */
public class Solution {
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
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(n == 1) return true;
        List<Integer>[] edgeList = new LinkedList[n];
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        visited[source] = true;

        for(int i = 0; i < n; i++) edgeList[i] = new LinkedList<>();

        for(int[] edge : edges) {
            edgeList[edge[0]].add(edge[1]);
            edgeList[edge[1]].add(edge[0]);
        }

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int neighbor : edgeList[cur]) {
                if(neighbor == destination) return true;
                else if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
        return false;
    }
}
