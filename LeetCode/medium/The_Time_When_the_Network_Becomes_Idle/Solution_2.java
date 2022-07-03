package medium.The_Time_When_the_Network_Becomes_Idle;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Maybe optimal...
 */
public class Solution_2 {
    @Test
    public void execute() {
//        int[][] edgesRaw = new int[][]{{0,1},{1,2}}; int[] patience = new int[]{0,2,1};
        int[][] edgesRaw = new int[][]{{0,1},{0,2},{1,2}}; int[] patience = new int[]{0,10,10};

        System.out.println(networkBecomesIdle(edgesRaw, patience));
    }
    public int networkBecomesIdle(int[][] edgesRaw, int[] patience) {
        int n = patience.length;
        List<Integer>[] edges = new LinkedList[n];
        for(int i = 0;i < n; i++) edges[i] = new LinkedList<>();
        for(int[] edge : edgesRaw) {
            edges[edge[0]].add(edge[1]);
            edges[edge[1]].add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        int cost = 0;
        int minIdleTime = 0;
        while(!queue.isEmpty()) {
            cost++;
            int cnt = queue.size();
            for(int i = 0; i < cnt; i++) {
                int cur = queue.poll();
                for(int neighbor : edges[cur]) {
                    if(!visited[neighbor]) {
                        int minPath = cost * 2;
                        int lastResendMsgSendTime = (minPath % patience[neighbor] == 0 ? minPath / patience[neighbor] - 1 : minPath / patience[neighbor]) * patience[neighbor];
                        int lastResendMsgArrivedTime = lastResendMsgSendTime + minPath;
                        minIdleTime = Math.max(minIdleTime, lastResendMsgArrivedTime);

                        queue.offer(neighbor);
                        visited[neighbor] = true;
                    }
                }
            }
        }

        return minIdleTime + 1;
    }
}
