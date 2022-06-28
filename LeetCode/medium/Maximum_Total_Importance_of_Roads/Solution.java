package medium.Maximum_Total_Importance_of_Roads;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Runtime : 75ms(32.33%)
 * Memory : 134mb(7.61%)
 * Subject : Greedy
 * Time Complexity : O(E + nlogn)
 */
public class Solution {
    public long maximumImportance(int n, int[][] roads) {
        //count connected edges of each vertices
        int[] vertexNumber = new int[n];
        int[][] vertexEdgeCnt = new int[n][2];
        for(int i = 0; i < n; i++) vertexEdgeCnt[i] = new int[]{i, 0};

        for(int[] road : roads) {
            vertexEdgeCnt[road[0]][1]++;
            vertexEdgeCnt[road[1]][1]++;
        }

        //sort vertices by connected edges number
        Arrays.sort(vertexEdgeCnt, Comparator.comparingInt(e -> e[1]));

        for(int i = 1; i <= n; i++) {
            vertexNumber[vertexEdgeCnt[i - 1][0]] = i;
        }

        //calculate sum of adjacent vertices numbers
        long sum = 0;
        for(int[] road : roads) sum += vertexNumber[road[0]] + vertexNumber[road[1]];

        return sum;
    }
}
