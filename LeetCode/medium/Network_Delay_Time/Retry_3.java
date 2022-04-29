package medium.Network_Delay_Time;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Retry_3 {
    private static final int SOURCE = 0;
    private static final int TARGET = 1;
    private static final int WEIGHT = 2;
    private static final int TO = 0;
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
        boolean[] visited = new boolean[n];
        int visitedCnt = 0;

        for(int i = 0;i < n ;i++) edges[i] = new LinkedList<>();

        for(int[] edge : times) {
            edges[edge[SOURCE] - 1].add(new int[]{edge[TARGET] - 1, edge[WEIGHT]});
        }

        minVals[k - 1] = 0;

        while(true) {
            int min = Integer.MAX_VALUE;
            Integer minIdx = null;
            for(int i = 0; i < n; i++) {
                if(!visited[i] && minVals[i] != null && (minIdx == null || minVals[i] < min)) {
                    min = minVals[i];
                    minIdx = i;
                }
            }

            if(minIdx == null) break;
            visited[minIdx] = true;
            visitedCnt++;

            for(int[] edge : edges[minIdx]) {
                if(minVals[edge[TO]] == null || min + edge[COST] < minVals[edge[TO]]) {
                    minVals[edge[TO]] = min + edge[COST];
                }
            }
        }

         return visitedCnt < n ? -1 : Collections.max(Arrays.asList(minVals));
    }
}
