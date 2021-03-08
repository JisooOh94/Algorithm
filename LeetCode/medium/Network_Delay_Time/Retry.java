package medium.Network_Delay_Time;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * Runtime : 7ms(94.97%)
 * Memory : 42.8mb(58.15%)
 */
public class Retry {
	private int getMinIdx(Integer[] minPath, boolean[] visited) {
		int minIdx = -1;
		Integer min = 9999;
		for(int i = 1; i < minPath.length; i++) {
			if (minPath[i] != null && minPath[i] < min && !visited[i]) {
				min = minPath[i];
				minIdx = i;
			}
		}
		return minIdx;
	}
	public int networkDelayTime(int[][] times, int nodeCnt, int startPos) {
		Integer[] minPath = new Integer[nodeCnt + 1];
		boolean[] visited = new boolean[nodeCnt + 1];

		List<int[]>[] edgeList = new LinkedList[nodeCnt + 1];

		for(int[] edge : times) {
			if(edgeList[edge[0]] == null) edgeList[edge[0]] = new LinkedList<>();
			edgeList[edge[0]].add(new int[]{edge[1], edge[2]});
		}

		minPath[startPos] = 0;
		int maxPathAmongMinPath = -1;
		for(int i = 0; i < nodeCnt; i++) {
			int minIdx = getMinIdx(minPath, visited);
			if(minIdx == -1) return -1;
			visited[minIdx] = true;
			maxPathAmongMinPath = Math.max(minPath[minIdx], maxPathAmongMinPath);
			if(edgeList[minIdx] != null) {
				for (int[] neighbor : edgeList[minIdx]) {
					if (!visited[neighbor[0]])
						minPath[neighbor[0]] = minPath[neighbor[0]] == null ? minPath[minIdx] + neighbor[1] : Math.min(minPath[neighbor[0]], minPath[minIdx] + neighbor[1]);
				}
			}
		}

		return maxPathAmongMinPath;
	}
}