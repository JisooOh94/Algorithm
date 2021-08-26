package medium.Minimum_Adjacent_Swaps_to_Reach_the_Kth_Smallest_Number;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class Solution {
	@Test
	public void execute() {
		String num = "6975";
		int k = 8;
		System.out.println(getMinSwaps(num, k));
	}
	private int reverse(List<Integer> numList, int start, int end, int targetNum) {
		int rearIdx = end - 1;
		int targetIdx = start;
		for(int i = start; i < (end + start) / 2; i++) {
			int temp = numList.get(i);
			numList.set(i, numList.get(rearIdx));
			numList.set(rearIdx, temp);
			if(numList.get(i) > targetNum) targetIdx = i;
			else if(numList.get(rearIdx) > targetNum) targetIdx = rearIdx;
			rearIdx--;
		}
		if((end + start) % 2 == 1) {
			int idx = numList.get((end + start) / 2);
			if(numList.get(idx) > targetNum && numList.get(idx) < numList.get(targetIdx)) targetIdx = idx;
		}
		return targetIdx;
	}
	private void swap(int source, int target, List<Integer> numList) {
		int temp = numList.get(source);
		numList.set(source, numList.get(target));
		numList.set(target, temp);
	}
	public int getMinSwaps(String num, int k) {
		List<Integer> numList = num.chars().mapToObj(c -> c - '0').collect(Collectors.toList());
		List<Integer> orgList = new LinkedList<>(numList);
		Collections.reverse(orgList);
		int maxSwapped = numList.size() - 1;
		for(int idx = 0; idx < k; idx++) {
			int max = num.length() - 1;
			int cur = max - 1;
			while(numList.get(cur) >= numList.get(max)) {
				max = cur;
				cur -= 1;
				maxSwapped = Math.min(cur, maxSwapped);
			}
			int targetIdx = reverse(numList, cur + 1, numList.size(), numList.get(cur));
			swap(cur, targetIdx, numList);
		}

		int totalSwapCnt = 0;
		for(int targetIdx = numList.size() - 1; maxSwapped <= targetIdx; targetIdx--) {
			int swapCnt = 0;
			int targetNum = numList.get(targetIdx);
			for(Iterator<Integer> iter = orgList.iterator(); iter.hasNext();) {
				if(iter.next() == targetNum) {
					iter.remove();
					break;
				}
				swapCnt++;
			}
			totalSwapCnt += swapCnt;
		}
		return totalSwapCnt;
	}
}
