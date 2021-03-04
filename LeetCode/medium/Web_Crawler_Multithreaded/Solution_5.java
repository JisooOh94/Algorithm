package medium.Web_Crawler_Multithreaded;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

/**
 * Runtime : 923ms(5.03%)
 * Memory : 106.4mb(16.70%)
 */
public class Solution_5 {
	interface HtmlParser {
		List<String> getUrls(String url);
	}

	public List<String> crawl(String startUrl, HtmlParser htmlParser) {
		Queue<String> queue = new LinkedList<>();
		Set<String> visited = new HashSet<>();
		List<String> sameHostUrlList = new LinkedList<>();
		String targetHost = startUrl.split("/")[2];

		ForkJoinPool threadPool = new ForkJoinPool(10);

		queue.offer(startUrl);
		visited.add(startUrl);
		sameHostUrlList.add(startUrl);

		while(!queue.isEmpty()) {
			int nodeCnt = queue.size();
			List<Future> isDone = new LinkedList<>();
			for(int i = 0; i < nodeCnt; i++) {
				isDone.add(threadPool.submit(() -> {
					String curUrl = queue.poll();
					List<String> neighborUrlList = htmlParser.getUrls(curUrl);

					for (String neighborUrl : neighborUrlList) {
						threadPool.submit(() -> {
							if (!visited.contains(neighborUrl)) {
								visited.add(neighborUrl);
								if (neighborUrl.split("/")[2].equals(targetHost)) {
									queue.offer(neighborUrl);
									sameHostUrlList.add(neighborUrl);
								}
							}
						});
					}
				}));
			}
			while(!isDone.stream().allMatch(Future::isDone));
		}
		return sameHostUrlList;
	}
}
