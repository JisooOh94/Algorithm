package medium.Web_Crawler_Multithreaded;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Runtime : 1085ms(5.03%)
 * Memory : 156.7mb(5.11%)
 */
public class Solution_4 {
	interface HtmlParser {
		List<String> getUrls(String url);
	}

	public List<String> crawl(String startUrl, HtmlParser htmlParser) {
		Queue<String> queue = new LinkedList<>();
		Set<String> visited = new HashSet<>();
		Set<String> sameHostUrlList = new HashSet<>();
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
						if (!visited.contains(neighborUrl)) {
							visited.add(neighborUrl);
							if (neighborUrl.split("/")[2].equals(targetHost)) {
								queue.offer(neighborUrl);
								sameHostUrlList.add(neighborUrl);
							}
						}
					}
				}));
			}
			while(!isDone.stream().allMatch(Future::isDone));
		}
		return new ArrayList<>(sameHostUrlList);
	}
}
