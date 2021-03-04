package medium.Web_Crawler_Multithreaded;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class Solution_2 {
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
			String curUrl = queue.poll();
			List<String> neighborUrlList = htmlParser.getUrls(curUrl);
			List<Future> futures = new LinkedList<>();
			for(String neighborUrl : neighborUrlList) {
				futures.add(pool.submit(() -> {
					boolean hasVisited;
					synchronized (this) {
						hasVisited = visited.contains(neighborUrl);
						if(!hasVisited) visited.add(neighborUrl);
					}
					if (!hasVisited) {
						if (neighborUrl.split("/")[2].equals(targetHost)) {
							queue.offer(neighborUrl);
							sameHostUrlList.add(neighborUrl);
						}
					}
				}));
			}

			while(!futures.stream().allMatch(Future::isDone));
		}

		return new LinkedList<>(sameHostUrlList);
	}
}
