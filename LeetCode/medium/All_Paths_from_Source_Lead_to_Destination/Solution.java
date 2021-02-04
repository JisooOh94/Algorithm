package medium.All_Paths_from_Source_Lead_to_Destination;

import java.util.LinkedList;
import java.util.List;

/**
 * Runtime : 5ms(87.77%)
 * Memory : 42.1mb(56.44%)
 */
public class Solution {
	private boolean recursion(int cur, int dest, List<Integer>[] edgeList, boolean[] visited, Boolean[] lead2dest) {
		if(cur == dest) return true;

		visited[cur] = true;
		if(edgeList[cur] != null) {
			for (int neighbor : edgeList[cur]) {
				if (visited[neighbor] && lead2dest[neighbor] == null) return false;
				else if (lead2dest[neighbor] != null || recursion(neighbor, dest, edgeList, visited, lead2dest))
					lead2dest[cur] = true;
				else return false;
			}
		}

		return lead2dest[cur] == null ? false : lead2dest[cur];
	}
	public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
		List<Integer>[] edgeList = new LinkedList[n];
		for(int[] edge : edges) {
			if(edgeList[edge[0]] == null) edgeList[edge[0]] = new LinkedList<>();
			edgeList[edge[0]].add(edge[1]);
		}

		if(edgeList[destination] != null) return false;

		return recursion(source, destination, edgeList, new boolean[n], new Boolean[n]);
	}
}
