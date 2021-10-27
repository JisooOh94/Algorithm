import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import javafx.util.Pair;
import org.junit.Test;


public class Solution_4 {
	@Test
	public void test() {
		List<Integer> source = Arrays.asList(1,2,3);
		List<Integer> dest = new LinkedList<>();
		Collections.copy(source, dest);

	}
	private static final int START = 0;
	private static final int END = 1;
	private static final int PROFIT = 2;

	private static Pair<Integer, LinkedList<Integer>> recursion(int curIdx, int prevEndTime, List<int[]> schedules, Pair<Integer, LinkedList<Integer>>[] memo) {
		if (curIdx == schedules.size()) return new Pair<>(0, new LinkedList<>());

		if (schedules.get(curIdx)[START] >= prevEndTime) {
			if (memo[curIdx] != null) return memo[curIdx];
			Pair<Integer, LinkedList<Integer>> doInfo = recursion(curIdx + 1, schedules.get(curIdx)[END], schedules, memo);
			int doProfit = doInfo.getKey() + schedules.get(curIdx)[PROFIT];

			Pair<Integer, LinkedList<Integer>> skipInfo = recursion(curIdx + 1, prevEndTime, schedules, memo);
			int skipProfit = skipInfo.getKey();

			if (doProfit > skipProfit) {
				LinkedList<Integer> history = new LinkedList<>();
				Collections.copy(doInfo.getValue(), history);
				history.addFirst(curIdx);
				memo[curIdx] = new Pair<>(doProfit, history);
			} else {
				LinkedList<Integer> history = new LinkedList<>();
				Collections.copy(skipInfo.getValue(), history);
				memo[curIdx] = new Pair<>(skipProfit, history);
			}
			return memo[curIdx];
		} else {
			return recursion(curIdx + 1, prevEndTime, schedules, memo);
		}
	}

	public static void main(String[] args) {
		List<int[]> schedules = new LinkedList<>();

		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		for(int i = 0; i < count; i++) {
			int[] schedule = new int[3];
			schedule[START] = sc.nextInt();
			schedule[END] = sc.nextInt();
			schedule[PROFIT] = sc.nextInt();
			schedules.add(schedule);
		}

		Collections.sort(schedules, Comparator.comparingInt(schedule -> schedule[END]));
		Pair<Integer, LinkedList<Integer>>[] memo = new Pair[schedules.size()];

		recursion(0, 0, schedules, memo);

		int maxProfit = memo[0].getKey();
		LinkedList<Integer> maxHistory = memo[0].getValue();
		System.out.println(maxProfit);
		for(int idx : maxHistory) {
			System.out.println(schedules.get(idx)[START] + " " + schedules.get(idx)[END]);
		}
	}
}


//5
//0 4 5
//3 4 20
//6 6 3
//8 5 35
//10 4 12