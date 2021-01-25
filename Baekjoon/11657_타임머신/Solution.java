import java.io.IOException;
import java.util.Scanner;

public class Solution {
	private static Long[] getMinTime(int n, int m, int[][] edgeInfo) {
		Long[] minTime = new Long[n];
		minTime[0] = 0L;

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				int start = edgeInfo[j][0] - 1;
				int target = edgeInfo[j][1] - 1;
				int time = edgeInfo[j][2];

				if(minTime[start] != null) {
					if(minTime[target] == null) minTime[target] = minTime[start] + time;
					else if(minTime[target] > minTime[start] + time) {
						minTime[target] = minTime[start] + time;
						if (i == n - 1) {
							minTime[0] = -1L;
							return minTime;
						}
					}
				}
			}
		}
		return minTime;
	}

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[][] edgeInfo = new int[m][3];
		for(int i = 0; i < m; i++) {
			edgeInfo[i][0] = scanner.nextInt();
			edgeInfo[i][1] = scanner.nextInt();
			edgeInfo[i][2] = scanner.nextInt();
		}

		Long[] result = getMinTime(n, m, edgeInfo);
		if(result[0] == -1) System.out.println(-1);
		else {
			for(int i = 1; i < n; i++) {
				System.out.println(result[i] == null ? -1 : result[i]);
			}
		}
	}
}
