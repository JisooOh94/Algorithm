package medium.Design_Add_and_Search_Words_Data_Structure;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

class WordDictionary {
	private static final char DOT = '.';
	private Set<String> set;

	public WordDictionary() {
		set = new HashSet<>();
	}

	public void addWord(String word) {
		set.add(word);
	}

	private boolean recursion(int cur, String word, StringBuilder builder) {
		if(cur == word.length()) return set.contains(builder.toString());

		if(word.charAt(cur) == DOT) {
			for(int i = 'a'; i <= 'z'; i++) {
				builder.append((char)i);
				if(recursion(cur + 1, word, builder)) return true;
				builder.setLength(builder.length() - 1);
			}
		} else {
			builder.append(word.charAt(cur));
			if(recursion(cur + 1, word, builder)) return true;
			builder.setLength(builder.length() - 1);
		}

		return false;
	}

	public boolean search(String word) {
		return recursion(0, word, new StringBuilder());
	}
}
