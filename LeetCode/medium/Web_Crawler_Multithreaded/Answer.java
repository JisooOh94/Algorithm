package medium.Web_Crawler_Multithreaded;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Answer {
	interface HtmlParser {
		List<String> getUrls(String url);
	}

	class Solution {
		public List<String> crawl(String startUrl, HtmlParser htmlParser) {
			int idx = startUrl.indexOf('/', 7);
			String host = startUrl.substring(0, idx != -1 ? idx : startUrl.length());
			Set<String> visited = ConcurrentHashMap.newKeySet();
			visited.add(startUrl);
			return crawl(startUrl, htmlParser, visited, host)
					.collect(Collectors.toList());
		}

		private Stream<String> crawl(String startUrl, HtmlParser parser, Set<String> visited, String host) {
			Stream<String> stream = parser.getUrls(startUrl)
					.parallelStream()
					.filter(url -> url.startsWith(host))
					.filter(url -> visited.add(url))
					.flatMap(url -> crawl(url, parser, visited, host));
			return Stream.concat(Stream.of(startUrl), stream);
		}

	}
}
