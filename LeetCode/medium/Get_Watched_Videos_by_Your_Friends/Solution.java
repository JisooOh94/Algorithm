package medium.Get_Watched_Videos_by_Your_Friends;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;
import org.junit.Test;

/**
 * Runtime: 69 ms, faster than 55.55% of Java online submissions for Get Watched Videos by Your Friends.
 * Memory Usage: 68.9 MB, less than 17.46% of Java online submissions for Get Watched Videos by Your Friends.
 * Subject : BFS
 */
public class Solution {
  @Test
  public void execute() {
    List<List<String>> watchedVideos = Arrays.asList(
        Arrays.asList("A", "B"),
        Arrays.asList("C"),
        Arrays.asList("B", "C"),
        Arrays.asList("D"));
    int[][] friends = {
        {1,2},{0,3},{0,3},{1,2}
    };
    int id = 0;
    int level = 1;

    List<String> result = watchedVideosByFriends(watchedVideos, friends, id, level);
    result.forEach(System.out::println);
  }

  private static final <T> T defaultIfNull(T param, T defaultValue) {
    return param == null ? defaultValue : param;
  }

  public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
    boolean[] visited = new boolean[friends.length];
    Queue<Integer> queue = new LinkedList<>();
    Map<String, Integer> watchedCnt = new HashMap<>();
    int dist = 0;

    queue.offer(id);
    visited[id] = true;

    while(!queue.isEmpty()) {
      if(dist++ == level) {
        queue.stream().forEach(cur ->
            watchedVideos.get(cur).stream().forEach(video ->
                watchedCnt.put(video, defaultIfNull(watchedCnt.get(video), 0) + 1)));
        break;
      }

      int size = queue.size();
      for(int i = 0; i < size; i++) {
        int cur = queue.poll();
        for(int neighbor : friends[cur]) {
          if(!visited[neighbor]) {
            visited[neighbor] = true;
            queue.offer(neighbor);
          }
        }
      }
    }
    return watchedCnt.entrySet().stream()
        .sorted((e1, e2) -> e1.getValue() == e2.getValue() ? e1.getKey().compareTo(e2.getKey()) : e1.getValue().compareTo(e2.getValue()))
        .map(e -> e.getKey())
        .collect(Collectors.toList());
  }
}
