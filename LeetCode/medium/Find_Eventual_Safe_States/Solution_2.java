package medium.Find_Eventual_Safe_States;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * Runtime : 7 ms(47.86 %)
 * Memory : 47.6 mb(89.13%)
 */
public class Solution_2 {
	@Test
	public void execute() {
		int[][] graph = new int[][]{
				{1,2},{2,3},{5},{0},{5},{},{}
//				{1,2,3,4},{1,2},{3,4},{0,4},{}
		};

		System.out.println(eventualSafeNodes(graph));
	}
	private boolean recursion(int cur, int[][] graph, Boolean[] isSafe) {
		if(isSafe[cur] != null) return isSafe[cur];
		else if(graph[cur].length == 0) {
			isSafe[cur] = true;
			return true;
		}

		isSafe[cur] = false;
		for(int connected : graph[cur]) {
			if(!recursion(connected, graph, isSafe)) return false;
		}
		isSafe[cur] = true;
		return true;
	}
	public List<Integer> eventualSafeNodes(int[][] graph) {
		if(graph == null || graph.length == 0) return Collections.emptyList();
		Boolean[] isSafe = new Boolean[graph.length];
		List<Integer> safeList = new LinkedList<>();

		for(int i = 0; i < graph.length; i++) {
			if(recursion(i, graph, isSafe)) safeList.add(i);
		}

		Collections.sort(safeList);
		return safeList;
	}
}

