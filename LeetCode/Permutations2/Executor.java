package Permutations2;

import java.util.List;

import org.junit.Test;

public class Executor {
	@Test
	public void test() {
		int[] samples = new int[]{-1,2,0,-1,1,0,1};
		List<List<Integer>> resultList = Solution.permute(samples);

		duplicateCheck(resultList);
	}

	private void duplicateCheck(List<List<Integer>> list) {
		for(List<Integer> partList : list) {
			if(list.lastIndexOf(partList) != list.indexOf(partList)) {
				System.out.println(partList);
			}
		}
	}

}
