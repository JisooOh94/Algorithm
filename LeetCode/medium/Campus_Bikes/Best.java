package medium.Campus_Bikes;

import java.util.*;

/**
 * 그냥 비효율, 시뮬레이션으로 떄려버린 솔루션. 하지만 이게 60% 라는거..
 */
public class Best {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        // Map<Distance, List<[worker, bike]>
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int b = 0; b < bikes.length; b++) {
            for (int w = 0; w < workers.length; w++) {
                int dist = Math.abs(bikes[b][0] - workers[w][0]) + Math.abs(bikes[b][1] - workers[w][1]);
                if (!map.containsKey(dist))
                    map.put(dist, new ArrayList<>());
                map.get(dist).add(new int[]{w, b});
            }
        }

        for (Integer dist : map.keySet()) {
            Collections.sort(map.get(dist), (pair1, pair2) -> Integer.compare(pair1[0], pair2[0]));
        }
        Set<Integer> wTaken = new HashSet<>();
        Set<Integer> bTaken = new HashSet<>();
        int[] result = new int[workers.length];
        List<Integer> distList = new ArrayList<>(map.keySet());
        Collections.sort(distList);
        for (Integer dist : distList) {
            for (int[] pair : map.get(dist)) {
                if (wTaken.contains(pair[0]) || bTaken.contains(pair[1]))
                    continue;
                result[pair[0]] = pair[1];
                wTaken.add(pair[0]);
                bTaken.add(pair[1]);
            }
        }
        return result;
    }
}
