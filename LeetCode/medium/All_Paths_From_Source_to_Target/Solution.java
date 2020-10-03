package medium.All_Paths_From_Source_to_Target;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * Runtime : 5ms(32.59%)
 * Memory : 43mb(27.39%)
 */
public class Solution {
	@Test
	public void execute() {
		int[][] edges = new int[][]{
				{1,2},{3},{3},{}
		};
		List<List<Integer>> result = allPathsSourceTarget(edges);
		for(List<Integer> list : result) {
			for(int path : list) System.out.print(path + " - ");
			System.out.println();
		}
	}
	private List<List<Integer>> recursion(int curIdx, int[][] edges) {
		if(curIdx == edges.length - 1) {
			LinkedList<Integer> list = new LinkedList<>(Arrays.asList(curIdx));
			return new LinkedList<>(Arrays.asList(list));
		}

		List<List<Integer>> pathList = new LinkedList<>();
		for(int neighbor : edges[curIdx]) {
			for(List<Integer> curPath : recursion(neighbor, edges)) {
				((LinkedList)curPath).addFirst(curIdx);
				pathList.add(curPath);
			}
		}
		return pathList;
	}

	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		return recursion(0, graph);
	}
}
