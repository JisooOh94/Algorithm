import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Time Complexity : O(n^2)
 */
public class Solution_2 {
	private static class NodeInfo {
		private boolean visited;
		private List<String> neighbors;

		public NodeInfo(boolean visited, List<String> neighbors) {
			this.visited = visited;
			this.neighbors = neighbors;
		}

		public boolean isVisited() {
			return visited;
		}

		public void setVisited(boolean visited) {
			this.visited = visited;
		}

		public NodeInfo addNeighbors(String neighbor) {
			neighbors.add(neighbor);
			return this;
		}
	}

	private static void markNeighbors (String cur, Map<String, NodeInfo> relationMap) {
		for(String neighbor : relationMap.get(cur).neighbors) {
			NodeInfo neighborNodeInfo = relationMap.get(neighbor);
			if(!neighborNodeInfo.isVisited()) {
				neighborNodeInfo.setVisited(true);
				markNeighbors(neighbor, relationMap);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		Map<String, NodeInfo> relationMap = new HashMap<>();

		for(int i = 0; i < count; i++) {
			String from = sc.next();
			String to = sc.next();
			relationMap.putIfAbsent(from, new NodeInfo(false ,new LinkedList<>()));
			relationMap.putIfAbsent(to, new NodeInfo(false, new LinkedList<>()));
			relationMap.compute(from, (key, node) -> node.addNeighbors(to));
			relationMap.compute(to, (key, list) -> list.addNeighbors(from));
		}

		int clusterCnt = 0;
		for(Iterator<Map.Entry<String, NodeInfo>> iter = relationMap.entrySet().iterator(); iter.hasNext();) {
			Map.Entry<String, NodeInfo> entry = iter.next();
			if(!entry.getValue().isVisited()) {
				clusterCnt++;
				entry.getValue().setVisited(true);
				markNeighbors(entry.getKey(), relationMap);
			}
		}

		System.out.println(clusterCnt);
	}
}
