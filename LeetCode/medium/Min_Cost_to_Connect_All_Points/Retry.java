package medium.Min_Cost_to_Connect_All_Points;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Retry {
    @Test
    public void execute() {
        int[][] points = new int[][]{{0,0},{2,2},{3,10},{5,2},{7,0}};
        System.out.println(minCostConnectPoints(points));
    }
    private static final int WEIGHT = 2;
    private int getDist(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
    private int getParent(int cur, Integer[] parents) {
        if(parents[cur] == null) return cur;
        return getParent(parents[cur], parents);
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e[WEIGHT]));
        for(int i  = 0; i < n - 1; i++) {
            int[] p1 = points[i];
            for(int j = i + 1; j < n; j++) {
                int[] p2 = points[j];
                int weight = getDist(p1, p2);
                queue.offer(new int[]{i, j, weight});
            }
        }

        Integer[] parents = new Integer[n];
        int connectedCnt = 0;
        int totalWeight = 0;
        while(!queue.isEmpty()) {
            int[] edge = queue.poll();
            int p1Parent = getParent(edge[0], parents);
            int p2Parent = getParent(edge[1], parents);
            if(p1Parent == p2Parent) continue;

            parents[max(p1Parent, p2Parent)] = min(p1Parent, p2Parent);
            connectedCnt++;
            totalWeight += edge[WEIGHT];

            if(connectedCnt == n - 1) break;
        }

        return totalWeight;
    }
}
