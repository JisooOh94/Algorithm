package LeetCode.Word_Ladder;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import util.Predicate;

/**
 * Runtime: 295ms(25.34%)
 * Memory : 39.5mb(87.59%)
 */
public class Solution_2 implements Predicate<Integer, Object> {
	public Integer test(Object... params) {
		return ladderLength((String)params[0], (String)params[1], (List<String>)params[2]);
	}

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if(wordList == null || wordList.size() == 0) return 0;
		else if(wordList.size() == 1) return isConnected(beginWord, endWord) ? 2 : 0;

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

					if(isConnected(sourceWord, targetWord)) {
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
