package medium.Minimum_Score_Triangulation_of_Polygon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class Solution {
	@Test
	public void execute() {
//		int[] arr = new int[]{1, 2, 3, 4, 5, 6};
//		int[] arr = new int[]{1,3,1,4,1,5};
//		int[] arr = new int[]{3,7,4,5};
//		int[] arr = new int[]{4,3,4,3,5};
//		int[] arr= new int[]{2,2,2,2,1};
		int[] arr = new int[]{5,5,5,4,2,5};
		System.out.println(minScoreTriangulation(arr));
	}

	private int recursion(List<Integer> list, int startIdx) {
		int edgeCnt = 0;
		int curScore = 1;
		int scoreSum = 0;

		List<Integer> vertexList = new ArrayList<>();
		vertexList.add(list.get(startIdx));

		for (int i = 0; i < list.size(); i++) {
			int curIdx = (startIdx + i) % list.size();
			curScore *= list.get(curIdx);
			edgeCnt++;

			if (edgeCnt == 3) {
				vertexList.add(list.get(curIdx));
				scoreSum += curScore;
				curScore = list.get(curIdx);
				edgeCnt = 1;
			} else if (i == list.size() - 1) {
				curScore *= list.get(startIdx);
				scoreSum += curScore;
			}
		}

		if(vertexList.size() == 3) {
			int min = scoreSum + vertexList.get(0) * vertexList.get(1) * vertexList.get(2);
			return min;
		}
		else if(vertexList.size() == 4) {
			int min = scoreSum + Math.min(recursion(vertexList, 0), recursion(vertexList, 1));
			return min;
		}
		else if(vertexList.size() > 4) {
			int min = 9999999;
			for(int i = 0; i < vertexList.size(); i++) min = Math.min(recursion(vertexList, i), recursion(vertexList, 1));
			return scoreSum + min;
		}
		return scoreSum;
	}

	public int minScoreTriangulation(int[] arr) {
		List<Integer> list = new ArrayList<>(Arrays.stream(arr).boxed().collect(Collectors.toList()));
		int min = 99999;
		for(int i = 0; i < arr.length; i++) {
			min = Math.min(recursion(list, i), min);
		}
		return min;
	}
}
