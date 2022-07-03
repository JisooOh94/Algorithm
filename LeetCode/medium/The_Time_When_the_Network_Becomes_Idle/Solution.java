package medium.The_Time_When_the_Network_Becomes_Idle;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Runtime : 141ms(78.24%)
 * Memory : 165mb(59.41%)
 * Time Complexity : O(n + e)
 * Subject : BFS
 */
public class Solution {
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

        int[] minPath = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int cost = 0;
        while(!queue.isEmpty()) {
            cost++;
            int cnt = queue.size();
            for(int i = 0; i < cnt; i++) {
                int cur = queue.poll();
                for(int neighbor : edges[cur]) {
                    if(minPath[neighbor] == 0 && neighbor != 0) {
                        minPath[neighbor] = cost * 2;
                        queue.offer(neighbor);
                    }
                }
            }
        }

        int minIdleTime = 0;
        for(int i = 1; i < n; i++) {
            int lastResendMsgSendTime = (minPath[i] % patience[i] == 0 ? minPath[i] / patience[i] - 1 : minPath[i] / patience[i]) * patience[i];
            int lastResendMsgArrivedTime = lastResendMsgSendTime + minPath[i];
            minIdleTime = Math.max(minIdleTime, lastResendMsgArrivedTime);
        }

        return minIdleTime + 1;
    }
}
