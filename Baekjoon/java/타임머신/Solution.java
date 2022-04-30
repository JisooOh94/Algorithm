package 타임머신;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static int FROM = 0;
    private static int TO = 1;
    private static int COST = 2;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<int[]> edges = new LinkedList<>();
        for(int i = 0; i < m; i++) edges.add(new int[]{sc.nextInt() - 1, sc.nextInt() - 1, sc.nextInt()});

        Long[] minCosts = new Long[n];
        minCosts[0] = 0L;

        for(int i = 0; i < n; i++) {
            for(int[] edge : edges) {
                if(minCosts[edge[FROM]] == null) continue;

                if(minCosts[edge[TO]] == null || minCosts[edge[FROM]] + edge[COST] < minCosts[edge[TO]]) {
                    if(i == n - 1) {
                        System.out.println(-1);
                        return;
                    }
                    minCosts[edge[TO]] = minCosts[edge[FROM]] + edge[COST];
                }
            }
        }

        for(int i = 1; i < n; i++) {
            System.out.println(minCosts[i] == null ? -1 : minCosts[i]);
        }
    }
}
