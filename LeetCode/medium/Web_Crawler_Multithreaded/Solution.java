package medium.Web_Crawler_Multithreaded;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {
	interface HtmlParser {
		List<String> getUrls(String url);
	}

	public List<String> crawl(String startUrl, HtmlParser htmlParser) {
		Queue<String> queue = new LinkedList<>();
		Set<String> visited = new HashSet<>();
		List<String> sameHostUrlList = new LinkedList<>();
		String targetHost = startUrl.split("/")[2];

		queue.offer(startUrl);
		visited.add(startUrl);
		sameHostUrlList.add(startUrl);

		while(!queue.isEmpty()) {
			String curUrl = queue.poll();
			List<String> neighborUrlList = htmlParser.getUrls(curUrl);

			for(String neighborUrl : neighborUrlList) {
				if(!visited.contains(neighborUrl)) {
					visited.add(neighborUrl);
					if(neighborUrl.split("/")[2].equals(targetHost)) {
						queue.offer(neighborUrl);
						sameHostUrlList.add(neighborUrl);
					}
				}
			}
		}
		return sameHostUrlList;
	}
}
