package LeetCode.Word_Ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import util.Predicate;

public class Solution implements Predicate<Integer, Object> {
	public Integer test(Object... params) {
		return ladderLength((String)params[0], (String)params[1], (List<String>)params[2]);
	}

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if(wordList == null || wordList.size() == 0) return 0;
		else if(wordList.size() == 1) return isConnected(beginWord, endWord) ? 1 : 0;

		Map<String, Map<String, Boolean>> connectionMap = new HashMap<>();

		connectionMap.put(beginWord, new HashMap<>());
		for(int y = 0; y < wordList.size(); y++) {
			String yWord = wordList.get(y);
			Map<String, Boolean> map = new HashMap<>();
			connectionMap.put(yWord, map);

			for(int x = 0; x < wordList.size(); x++) {
				String xWord = wordList.get(x);
				map.put(xWord, false);
			}

			connectionMap.get(beginWord).put(yWord, false);
			connectionMap.get(yWord).put(beginWord, false);
		}

		for(int i = 0; i < wordList.size() - 1; i++) {
			String source = wordList.get(i);
			for(int j = i + 1; j < wordList.size(); j++) {
				String target = wordList.get(j);
				if(isConnected(source, target)) {
					connectionMap.get(source).put(target, true);
					connectionMap.get(target).put(source, true);
				}
			}

			if(isConnected(beginWord, source)) {
				connectionMap.get(beginWord).put(source, true);
				connectionMap.get(source).put(beginWord, true);
			}
		}

		Queue<String> wordQ = new LinkedList<>();
		wordQ.add(beginWord);

		int count = 0;

		while(!wordQ.isEmpty() && !wordList.isEmpty()) {
			int size = wordQ.size();
			count++;

			for(int i = 0; i < size; i++) {
				String sourceWord = wordQ.poll();

				for(Iterator<String> iter = wordList.iterator(); iter.hasNext();) {
					String targetWord = iter.next();

					if(connectionMap.get(sourceWord).get(targetWord) == true) {
						if(targetWord.equals(endWord)) {
							return ++count;
						}

						wordQ.add(targetWord);
						iter.remove();
					}
				}
			}
		}

		return 0;
	}

	private boolean isConnected(String source, String target) {
		int diffCnt = 0;
		for(int i = 0; i < source.length(); i++) {
			if(source.charAt(i) != target.charAt(i)) {
				if(diffCnt == 0) diffCnt++;
				else return false;
			}
		}
		return true;
	}
}
