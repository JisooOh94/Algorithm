package medium.Network_Delay_Time;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.junit.Test;

import java.util.*;

public class Retry_4 {
    private static final int SOURCE = 0;
    private static final int TARGET = 1;
    private static final int WEIGHT = 2;
    private static final int IDX = 0;
    private static final int COST = 1;

    @Test
    public void execute() {
        int[][] times = new int[][]{
                {2,1,1},{2,3,1},{3,4,1}
        };
        int n = 4;
        int k = 2;

        System.out.println(networkDelayTime(times, n, k));
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] edges = new LinkedList[n];
        Integer[] minVals = new Integer[n];
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e[COST]));
        boolean[] visited = new boolean[n];
        int visitedCnt = 0;

        for(int i = 0;i < n ;i++) edges[i] = new LinkedList<>();
        for(int[] edge : times) {
            edges[edge[SOURCE] - 1].add(new int[]{edge[TARGET] - 1, edge[WEIGHT]});
        }

        minVals[k - 1] = 0;
        queue.offer(new int[]{k - 1, 0});

        while(!queue.isEmpty()) {
            int[] min = queue.poll();
            int minIdx = min[IDX];
            int minCost = min[COST];
            if(visited[minIdx]) continue;
            visited[minIdx] = true;
            visitedCnt++;

            for(int[] edge : edges[minIdx]) {
                if(minVals[edge[IDX]] == null || minCost + edge[COST] < minVals[edge[IDX]]) {
                    minVals[edge[IDX]] = minCost + edge[COST];
                    queue.offer(new int[]{edge[IDX], minVals[edge[IDX]]});
                }
            }
        }

         return visitedCnt < n ? -1 : Collections.max(Arrays.asList(minVals));
    }
}
