package Word_Break;

import java.util.List;

import util.Predicate;

/**
 * Runtime : 3ms(87.66%)
 * Memory : 39.7mb(5.08%)
 */
public class Solution implements Predicate<Boolean, Object> {
	public Boolean test(Object... params) {
		return wordBreak((String)params[0], (List<String>)params[1]);
	}

	private boolean recursion(String source, int startIdx, List<String> wordDict, boolean[] isVisited) {
		if(startIdx == source.length()) {
			return true;
		} else if(isVisited[startIdx]) {
			return false;
		}

		for(String target : wordDict) {
			if(startIdx + target.length() <= source.length() && target.equals(source.substring(startIdx, startIdx + target.length()))) {
				if(recursion(source, startIdx + target.length(), wordDict, isVisited)) {
					return  true;
				}
			}
		}

		isVisited[startIdx] = true;
		return false;
	}

	public boolean wordBreak(String s, List<String> wordDict) {
		if(s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
			return false;
		} else if(s.length() == 1) {
			return wordDict.contains(s);
		} else if(wordDict.size() == 1) {
			return s.equals(wordDict.get(0));
		}

		boolean[] isVisited = new boolean[s.length()];

		return recursion(s, 0, wordDict, isVisited);
	}
}
