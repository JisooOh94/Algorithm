package medium.Maximum_Total_Importance_of_Roads;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Runtime : 10ms(85.48%)
 * Memory : 117.9mb(78.36%)
 * Subject : Greedy
 * Time Complexity : O(nlogn)
 * 굳이 sum 게산시, edge 순회하며 정점의 number 합할 필요가 없음, 정점이 edge 들에 사용된 횟수 * 정점 number 가 sum 에 포함된 정점의 sum값임. 그러므로 각 정점마다 number 할당 따로 할 필요 없이 edge 에 사용된 횟수만 기록하면됨
 */
public class Solution_3 {
    public long maximumImportance(int n, int[][] roads) {
        //count connected edges of each vertices
        int[] vertexEdgeCnt = new int[n];

        for(int[] road : roads) {
            vertexEdgeCnt[road[0]]++;
            vertexEdgeCnt[road[1]]++;
        }

        //sort vertices by connected edges number
        Arrays.sort(vertexEdgeCnt);

        long sum = 0;
        for(long i = 1; i <= n; i++) {
            sum += vertexEdgeCnt[(int)i - 1] * i;
        }

        return sum;
    }
}
