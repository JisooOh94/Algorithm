package medium.Design_Add_and_Search_Words_Data_Structure;

import org.junit.Test;

public class Solution {
	@Test
	public void execute() {
		WordDictionary wordDictionary = new WordDictionary();
		wordDictionary.addWord("bad");
		wordDictionary.addWord("dad");
		wordDictionary.addWord("mad");
		System.out.println(wordDictionary.search(".ad"));
	}
}
