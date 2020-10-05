package medium.Regions_Cut_By_Slashes;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/**
 * Runtime : 13ms(19.71%)
 * Memory :38.8mb(62.91%)
 */
public class Solution {
	@Test
	public void execute() {
		String[] strings = new String[]{
				" /",
				"/ "
		};
		System.out.println(regionsBySlashes(strings));
	}
	public int regionsBySlashes(String[] grid) {
		int[][] map = new int[grid.length * 3][grid[0].length() * 3];

		for(int y = 0; y < grid.length; y++) {
			for(int x = 0; x < grid[0].length(); x++) {
				switch (grid[y].charAt(x)) {
					case '\\' :
						map[y * 3 + 0][x * 3 + 0] = map[y * 3 + 1][x * 3 + 1] = map[y * 3 + 2][x * 3 + 2] = 1;
						break;
					case '/' :
						map[y * 3 + 2][x * 3 + 0] = map[y * 3 + 1][x * 3 + 1] = map[y * 3 + 0][x * 3 + 2] = 1;
						break;
				}
			}
		}

		int regionCnt = 0;
		for(int y = 0; y < map.length; y++) {
			for(int x = 0; x < map[0].length; x++) {
				if(map[y][x] == 0) {
					regionCnt++;
					map[y][x] = 1;
					Queue<int[]> posQ = new LinkedList<>();
					posQ.offer(new int[]{y, x});

					while(!posQ.isEmpty()) {
						int[] pos = posQ.poll();
						if(pos[0] + 1 < map.length && map[pos[0] + 1][pos[1]] == 0) {
							map[pos[0] + 1][pos[1]] = 1;
							posQ.offer(new int[]{pos[0] + 1, pos[1]});
						}

						if(0 <= pos[0] - 1 && map[pos[0] - 1][pos[1]] == 0) {
							map[pos[0] - 1][pos[1]] = 1;
							posQ.offer(new int[]{pos[0] - 1, pos[1]});
						}

						if(pos[1] + 1 < map.length && map[pos[0]][pos[1] + 1] == 0) {
							map[pos[0]][pos[1] + 1] = 1;
							posQ.offer(new int[]{pos[0], pos[1] + 1});
						}

						if(0 <= pos[1] - 1 && map[pos[0]][pos[1] - 1] == 0) {
							map[pos[0]][pos[1] - 1] = 1;
							posQ.offer(new int[]{pos[0], pos[1] - 1});
						}
					}
				}
			}
		}
		return regionCnt;
	}
}
