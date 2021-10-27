import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Prob_2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int userCnt = Integer.parseInt(br.readLine());
		int[][] users = new int[userCnt][2];
		for(int i = 0; i < userCnt; i++) {
			String[] info = br.readLine().split(" ");
			users[i][0] = Integer.parseInt(info[1]);
			users[i][1] = Integer.parseInt(info[2]);
		}
		int[] result = getToiletInfo(users);
		System.out.println(result[0]);
		System.out.println(result[1]);
	}

	private static final int START = 0;
	private static final int END = 1;
	private static int[] getToiletInfo(int[][] users) {
		Arrays.sort(users, (e1, e2) -> e1[END] < e2[END] ? -1 : e1[END] > e2[END] ? 1 : e1[START] < e2[START] ? -1 : e1[START] > e2[START] ? 1 : 0);
		int[] cur = users[0];
		int maxUserCnt = 1;
		for(int i = 1; i < users.length; i++) {
			if(cur[END] <= users[i][START]) {
				cur = users[i];
				maxUserCnt++;
			}
		}

		Arrays.sort(users, (e1, e2) -> e1[START] < e2[START] ? -1 : e1[START] > e2[START] ? 1 : e1[END] < e2[END] ? -1 : e1[END] > e2[END] ? 1 : 0);
		PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e[END]));
		int maxOverlaped = 0;
		for(int[] user : users) {
			while(!queue.isEmpty()) {
				if(queue.peek()[END] <= user[START]) queue.poll();
				else break;
			}
			queue.offer(user);
			maxOverlaped = Math.max(maxOverlaped, queue.size());
		}
		return new int[]{maxUserCnt, maxOverlaped};
	}
}
