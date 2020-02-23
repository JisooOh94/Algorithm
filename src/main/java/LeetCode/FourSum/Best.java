package LeetCode.FourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 필터링 3 만 수행하고 필터링 1은 알고있었으나 귀찮아서 추가해주지 않았고 나머지 필터링 방식은 생각하지 못했다.
 * 필터링 1도 단순히 null/empty 인경우에만 가지치기를 한것이 아니라, 직접 invalid 한 경우(더해야하는 숫자 개수보다 적거나, 더해야하는 수가 1개나 0개일때)를 고려하여 가지치기를 추가해주었다.
 * 재귀 활용시 백트레킹을 접목한 부분도 평상시에 알고있었으나 귀찮음으로 굳이 활용하지 않던 내용이었다
 * 알고리즘 구현시, 솔루션이 떠올랐다고 해서 끝나는게 아니고, 솔루션 외에 자잘한 가지치기가 가능한것이 있는지 더 치열하게 고민해보는것이 필요하다.
 * 솔루션의 성능향상도 중요하지만 어쩌면 효율적인 솔루션을 찾아내는것보다 자잘한 가지치기 경우의수를 찾아내는것이 성능 향상 및 시간 소요 측면에서 더 효율적일 것 같다.
 */
public class Best {
	List<List<Integer>> kSum_Trim(int[] a, int target, int k) {			//수가 들어가있는 배열, 합의 결과로 원하는 타겟숫자, 더할 숫자 개수
		List<List<Integer>> result = new ArrayList<>();
		if (a == null || a.length < k || k < 2) return result;		//필터링 1. 배열에 들어있는 수가 없거나 / 더해야하는 숫자 개수보다 적거나 / 더해야하는 숫자 개수가 1개 또는 0개일때
		Arrays.sort(a);
		kSum_Trim(a, target, k, 0, result, new ArrayList<>());
		return result;
	}

	void kSum_Trim(int[] a, int target, int k, int start, List<List<Integer>> result, List<Integer> path) {
		int max = a[a.length - 1];		//정렬한 샘플 배열 내의 가장 큰 숫자가 max에 할당된다.
		if (a[start] * k > target || max * k < target) return;		//필터링 2. 배열내 가장 작은 수를 k 번 더한것이 목표 숫자보다 크거나 / 배열내 가장 큰 수를 k 번 더한것이 목표 숫자보다 적을시 stop

		if (k == 2) {                        // 2 Sum
			int left = start;
			int right = a.length - 1;
			while (left < right) {
				if      (a[left] + a[right] < target) left++;
				else if (a[left] + a[right] > target) right--;
				else {
					result.add(new ArrayList<>(path));
					result.get(result.size() - 1).addAll(Arrays.asList(a[left], a[right]));
					left++; right--;
					while (left < right && a[left] == a[left - 1]) left++;
					while (left < right && a[right] == a[right + 1]) right--;
				}
			}
		}
		else {                        // k Sum
			for (int i = start; i < a.length - k + 1; i++) {
				if (i > start && a[i] == a[i - 1]) continue;		//필터링 3. 이전 loop에서 이미 선택했던 중복되는 수라면 skip
				if (a[i] + max * (k - 1) < target) continue;		//필터링 4. 현재 선택한 수에서 나올 수 있는 가장 큰 합이 목표 수보다 작으면 skip
				if (a[i] * k > target) break;		//필터링 5. 현재 선택한 수에서 나올 수 있는 가장 작은 합이 목표수보다 크면 skip
				if (a[i] * k == target) {			//필터링 6. 현재 선택한 수가 k 번 중복된다고 가정하고 그 합이 목표수와 같다면 실제로 k번 중복되는지만 확인 후 skip
					if (a[i + k - 1] == a[i]) {		//필터링 6-1. k번 중복 확인시, 현재 선택한 수로부터 k개 뒤 index 수가 현재수와 같은지만 확인(정렬했기때문에)
						result.add(new ArrayList<>(path));
						List<Integer> temp = new ArrayList<>();
						for (int x = 0; x < k; x++) temp.add(a[i]);
						result.get(result.size() - 1).addAll(temp);    // Add result immediately.
					}
					break;
				}
				path.add(a[i]);
				kSum_Trim(a, target - a[i], k - 1, i + 1, result, path);
				path.remove(path.size() - 1);        // Backtracking			//재활용. 매번 객체를 복제하여 넘기는것이 아닌, 기존 객체를 재활용하도록 하여 성능 향상
			}
		}
	}
}
