package medium.Web_Crawler_Multithreaded;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class Solution_3 {
	interface HtmlParser {
		List<String> getUrls(String url);
	}

	public List<String> crawl(String startUrl, HtmlParser htmlParser) {
		Queue<String> queue = new ConcurrentLinkedQueue<>();
		Set<String> visited = new HashSet<>();
		Set<String> sameHostUrlList = ConcurrentHashMap.newKeySet();

		String targetHost = startUrl.split("/")[2];
		queue.offer(startUrl);
		visited.add(startUrl);
		sameHostUrlList.add(startUrl);

		ForkJoinPool pool = new ForkJoinPool(30);

		while (!queue.isEmpty()) {
			int nodeCnt = queue.size();
			List<Future> isComplete = new LinkedList<>();
			for (int i = 0; i < nodeCnt; i++) {
				String curUrl = queue.poll();
				isComplete.add(pool.submit(() -> {
					List<String> neighborUrlList = htmlParser.getUrls(curUrl);
					List<Future> futures = new LinkedList<>();
					for (String neighborUrl : neighborUrlList) {
						futures.add(pool.submit(() -> {
							boolean hasVisited;
							synchronized (this) {
								hasVisited = visited.contains(neighborUrl);
								if (!hasVisited) visited.add(neighborUrl);
							}
							if (!hasVisited) {
								if (neighborUrl.split("/")[2].equals(targetHost)) {
									queue.offer(neighborUrl);
									sameHostUrlList.add(neighborUrl);
								}
							}
						}));
					}
				}));
			}
			while (!isComplete.stream().allMatch(Future::isDone)) ;
		}
		return new LinkedList<>(sameHostUrlList);
	}
}
