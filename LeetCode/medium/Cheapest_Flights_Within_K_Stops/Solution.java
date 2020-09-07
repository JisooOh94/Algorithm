package medium.Cheapest_Flights_Within_K_Stops;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * Runtime : 6ms(87.31%)
 * Memory : 39.6mb(90.82%)
 */
public class Solution {
	@Test
	public void execute() {
		int n = 3;
		int[][] flights = new int[][]{{0,1,100},{1,2,100},{0,2,500}};
		int src = 0;
		int dst = 2;
		int K = 0;
		System.out.println(findCheapestPrice(n, flights, src, dst, K));
	}
	private static final int EDGE_IDX = 0;
	private static final int PRICE_IDX = 1;

	private int recursion(int curPos, int dstPos, int k, List<int[]>[] edgeList, Integer[][] record) {
		if(curPos == dstPos) return 0;
		else if(k == -1 || edgeList[curPos] == null) return -1;
		else if(record[curPos][k] != null) return record[curPos][k];

		int minPrice = 9999999;
		for(int[] edge : edgeList[curPos]) {
			int curPrice = recursion(edge[EDGE_IDX], dstPos, k - 1, edgeList, record);
			if(curPrice != -1) minPrice = Math.min(minPrice, curPrice + edge[PRICE_IDX]);
		}

		minPrice = minPrice == 9999999 ? -1 : minPrice;
		record[curPos][k] = minPrice;
		return minPrice;
	}
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		Integer[][] record = new Integer[n][K + 1];
		List<int[]>[] edgeList = new LinkedList[n];
		for(int[] flight : flights) {
			int srcPos = flight[0];
			int[] edge = new int[]{flight[1], flight[2]};
			if(edgeList[srcPos] == null) edgeList[srcPos] = new LinkedList<>();
			edgeList[srcPos].add(edge);
		}
		return recursion(src, dst, K, edgeList, record);
	}
}
