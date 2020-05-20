package medium.Analyze_User_Website_Visit_Pattern;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import util.Predicate;

public class Solution implements Predicate<List<String>, Object> {
	public List<String> test(Object... params) {
		return mostVisitedPattern((String[])params[0], (int[])params[1], (String[])params[2]);
	}

	private class VisitInfo {
		String webSite;
		int time;

		public VisitInfo(String webSite, int time) {
			this.webSite = webSite;
			this.time = time;
		}
	}

	public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
		Map<String, List<VisitInfo>> webSiteList = new HashMap<>();
		Map<String, Set<String>> visitUserListMap = new HashMap<>();
		Queue<String> webSiteSeqQ = new LinkedList<>();

		for(int i = 0; i < username.length; i++) {
			webSiteList.putIfAbsent(username[i], new LinkedList<>());
			webSiteList.get(username[i]).add(new VisitInfo(website[i], timestamp[i]));
		}

		for(Map.Entry<String, List<VisitInfo>> entry : webSiteList.entrySet()) {
			if(entry.getValue().size() >= 3) {
				Collections.sort(entry.getValue(), (visitInfo_1, visitInfo_2) -> visitInfo_1.time > visitInfo_2.time ? 1 : visitInfo_1.time < visitInfo_2.time ? -1 : 0);
				arrangeVisitUserList(webSiteSeqQ, entry.getValue(), visitUserListMap, entry.getKey());
			}
		}

		List<String> maxKeyList = new LinkedList<>();
		int maxUserCnt = 0;
		for(Map.Entry<String, Set<String>> entry : visitUserListMap.entrySet()) {
			if(maxUserCnt < entry.getValue().size()) {
				maxKeyList.clear();
				maxKeyList.add(entry.getKey());
				maxUserCnt = entry.getValue().size();
			} else if (maxUserCnt == entry.getValue().size()) {
				maxKeyList.add(entry.getKey());
			}
		}

		Collections.sort(maxKeyList);
		return Arrays.asList(maxKeyList.get(0).split("-"));
	}

	private void arrangeVisitUserList(Queue<String> webSiteSeqQ, List<VisitInfo> visitInfoList, Map<String, Set<String>> visitUserListMap, String userName) {
		webSiteSeqQ.clear();
		StringBuilder stringBuilder = new StringBuilder();

		for(int i = 0; i < visitInfoList.size(); i++) {
			webSiteSeqQ.offer(visitInfoList.get(i).webSite);
			stringBuilder.append(visitInfoList.get(i).webSite + "-");

			if(2 <= i) {
				String webSiteSeqStr = stringBuilder.toString();
				visitUserListMap.putIfAbsent(webSiteSeqStr, new HashSet<>());
				visitUserListMap.get(webSiteSeqStr).add(userName);
				stringBuilder.delete(0, webSiteSeqQ.poll().length() + 1);
			}
		}
	}
}
