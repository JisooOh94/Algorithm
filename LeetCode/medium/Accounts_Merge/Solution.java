package medium.Accounts_Merge;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * Runtime : 59ms(26.59%)
 * Memory : 60.6mb(5.47%)
 */
public class Solution {
	@Test
	public void execute() {
//		List<List<String>> accounts = Arrays.asList(
//				Arrays.asList("David","David0@m.co","David1@m.co"),
//				Arrays.asList("David","David3@m.co","David4@m.co"),
//				Arrays.asList("David","David4@m.co","David5@m.co"),
//				Arrays.asList("David","David2@m.co","David3@m.co"),
//				Arrays.asList("David","David1@m.co","David2@m.co")
//		);
//		List<List<String>> accounts = Arrays.asList(
//				Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com"),
//				Arrays.asList("John","johnsmith@mail.com","john00@mail.com"),
//				Arrays.asList("Mary","mary@mail.com"),
//				Arrays.asList("John","johnnybravo@mail.com")
//		);

		List<List<String>> accounts = Arrays.asList(
		Arrays.asList("Alex","Alex5@m.co","Alex4@m.co","Alex0@m.co"),
		Arrays.asList("Ethan","Ethan3@m.co","Ethan3@m.co","Ethan0@m.co"),
		Arrays.asList("Kevin","Kevin4@m.co","Kevin2@m.co","Kevin2@m.co"),
		Arrays.asList("Gabe","Gabe0@m.co","Gabe3@m.co","Gabe2@m.co"),
		Arrays.asList("Gabe","Gabe3@m.co","Gabe4@m.co","Gabe2@m.co")
		);
		System.out.println(accountsMerge(accounts));
	}

	private String getRoot(String cur, Map<String, String> rootInfoMap) {
		while(rootInfoMap.get(cur) != null) {
			cur = rootInfoMap.get(cur);
		}
		return cur;
	}
	public List<List<String>> accountsMerge(List<List<String>> accounts) {
		List<List<String>> resultList = new LinkedList<>();
		Map<String, List<List<String>>> connectionInfo = new HashMap<>();
		for(List<String> userInfo : accounts) {
			List<List<String>> connections = connectionInfo.getOrDefault(userInfo.get(0), new LinkedList<>());
			connections.add(userInfo.subList(1, userInfo.size()));
			if(connections.size() == 1) connectionInfo.put(userInfo.get(0), connections);
		}

		for(Map.Entry<String, List<List<String>>> entry : connectionInfo.entrySet()) {
			Map<String, String> rootInfoMap = new HashMap<>();
			for(List<String> connections : entry.getValue()) {
				String root = getRoot(connections.get(0), rootInfoMap);
				rootInfoMap.put(root, null);
				for(int i = 1; i < connections.size(); i++) {
					String childRoot = getRoot(connections.get(i), rootInfoMap);
					if(!childRoot.equals(root)) rootInfoMap.put(childRoot, root);
				}
			}

			Map<String, List<String>> resultMap = new HashMap<>();
			for(Map.Entry<String, String> e : rootInfoMap.entrySet()) {
				String root = getRoot(e.getKey(), rootInfoMap);
				List<String> list = resultMap.getOrDefault(root, new LinkedList<>());
				list.add(e.getKey());
				if(list.size() == 1) resultMap.put(root, list);
			}

			for(Map.Entry<String, List<String>> e : resultMap.entrySet()) {
				LinkedList<String> list = new LinkedList();
				list.addAll(e.getValue());
				Collections.sort(list);
				list.addFirst(entry.getKey());
				resultList.add(list);
			}
		}
		return resultList;
	}
}
