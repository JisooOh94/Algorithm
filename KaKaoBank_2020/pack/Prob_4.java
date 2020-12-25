package pack;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class Prob_4 {
	@Test
	public void execute() {
		int[] arr = new int[]{1, 1, 3, 3, 2, 2, 4, 5, 1, 1, 1, 3, 3, 3};
		System.out.println(solution(arr));
	}

	public int solution(int[] arr) {
		List<Integer> list = new LinkedList<>();
		for(int num : arr) list.add(num);

		int totalCnt = 0;
		while(1 < list.size()) {
			List<Integer> curList = new LinkedList<>();
			for(int idx = 0; idx < list.size();) {
				int cur = list.get(idx++);
				int cnt = 1;
				while(idx < list.size() && list.get(idx) == cur) {
					cnt++;
					idx++;
				}

				curList.add(cnt);
			}
			list = curList;
			totalCnt++;
		}
		return list.get(0) != 1 ? totalCnt + 1 : totalCnt;
	}
}
