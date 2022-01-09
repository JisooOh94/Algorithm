package medium.Paths_in_Maze_That_Lead_to_Same_Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

import org.junit.Test;
import javafx.util.Pair;

/**
 * RunTime : 917ms(16.49%)
 * Memory : 128.6mb(14.03%)
 * Time Complexity : o()
 * Subject : Graph
 */
public class Solution_2 {
	@Test
	public void test() {
		int n = 5;
		int[][] corridors = new int[][]{
				{1,2},{5,2},{4,1},{2,4},{3,1},{3,4}
		};

		System.out.println(numberOfPaths(n, corridors));
	}
	private int getScore(int curIdx, List<Integer> neighbors, List<Integer>[] edges) {
		int score = 0;
		for(int i = 0; i < neighbors.size() - 1; i++) {
			if(neighbors.get(i) < curIdx) continue;
			int from = neighbors.get(i);
			for(int j = i + 1; j < neighbors.size(); j++) {
				int to = neighbors.get(j);
				if(Collections.binarySearch(edges[to], from) >= 0) score++;
			}
		}
		return score;
	}
	public int numberOfPaths(int n, int[][] corridors) {
		List<Integer>[] edges = new ArrayList[n];
		for(int i = 0; i < n; i++) edges[i] = new ArrayList<>();
		for(int[] corridor : corridors) {
			edges[corridor[0] - 1].add(corridor[1] - 1);
			edges[corridor[1] - 1].add(corridor[0] - 1);
		}
		for(List<Integer> edge : edges) Collections.sort(edge);

		int confusionScore = 0;

		for(int i = 0; i < n; i++) confusionScore += getScore(i, edges[i], edges);
		return confusionScore;
	}
}
