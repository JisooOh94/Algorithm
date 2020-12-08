package medium.Sentence_Similarity_II;

import java.util.*;

import org.junit.Test;

/**
 * Runtime : 21ms(92.41%)
 * Memory : 40.1mb(58.23%)
 */
public class Solution {
	@Test
	public void execute() {
		String[] words1 = new String[]{"this","summer","thomas","get","really","very","rich","and","have","any","actually","wonderful","and","good","truck","every","morning","he","drives","an","extraordinary","truck","around","the","nice","city","to","eat","some","extremely","extraordinary","food","as","his","meal","but","he","only","entertain","an","few","well","fruits","as","single","lunch","he","wants","to","eat","single","single","and","really","healthy","life"};
		String[] words2 = new String[]{"this","summer","thomas","get","very","extremely","rich","and","possess","the","actually","great","and","wonderful","vehicle","every","morning","he","drives","unique","extraordinary","automobile","around","unique","fine","city","to","drink","single","extremely","nice","meal","as","his","super","but","he","only","entertain","a","few","extraordinary","food","as","some","brunch","he","wants","to","take","any","some","and","really","healthy","life"};
		List<List<String>> paris = Arrays.asList(
				Arrays.asList("good","nice"),Arrays.asList("good","excellent"),Arrays.asList("good","well"),Arrays.asList("good","great"),Arrays.asList("fine","nice"),Arrays.asList("fine","excellent"),Arrays.asList("fine","well"),Arrays.asList("fine","great"),Arrays.asList("wonderful","nice"),Arrays.asList("wonderful","excellent"),Arrays.asList("wonderful","well"),Arrays.asList("wonderful","great"),Arrays.asList("extraordinary","nice"),Arrays.asList("extraordinary","excellent"),Arrays.asList("extraordinary","well"),Arrays.asList("extraordinary","great"),Arrays.asList("one","a"),Arrays.asList("one","an"),Arrays.asList("one","unique"),Arrays.asList("one","any"),Arrays.asList("single","a"),Arrays.asList("single","an"),Arrays.asList("single","unique"),Arrays.asList("single","any"),Arrays.asList("the","a"),Arrays.asList("the","an"),Arrays.asList("the","unique"),Arrays.asList("the","any"),Arrays.asList("some","a"),Arrays.asList("some","an"),Arrays.asList("some","unique"),Arrays.asList("some","any"),Arrays.asList("car","vehicle"),Arrays.asList("car","automobile"),Arrays.asList("car","truck"),Arrays.asList("auto","vehicle"),Arrays.asList("auto","automobile"),Arrays.asList("auto","truck"),Arrays.asList("wagon","vehicle"),Arrays.asList("wagon","automobile"),Arrays.asList("wagon","truck"),Arrays.asList("have","take"),Arrays.asList("have","drink"),Arrays.asList("eat","take"),Arrays.asList("eat","drink"),Arrays.asList("entertain","take"),Arrays.asList("entertain","drink"),Arrays.asList("meal","lunch"),Arrays.asList("meal","dinner"),Arrays.asList("meal","breakfast"),Arrays.asList("meal","fruits"),Arrays.asList("super","lunch"),Arrays.asList("super","dinner"),Arrays.asList("super","breakfast"),Arrays.asList("super","fruits"),Arrays.asList("food","lunch"),Arrays.asList("food","dinner"),Arrays.asList("food","breakfast"),Arrays.asList("food","fruits"),Arrays.asList("brunch","lunch"),Arrays.asList("brunch","dinner"),Arrays.asList("brunch","breakfast"),Arrays.asList("brunch","fruits"),Arrays.asList("own","have"),Arrays.asList("own","possess"),Arrays.asList("keep","have"),Arrays.asList("keep","possess"),Arrays.asList("very","super"),Arrays.asList("very","actually"),Arrays.asList("really","super"),Arrays.asList("really","actually"),Arrays.asList("extremely","super"),Arrays.asList("extremely","actually")
		);

		System.out.println(areSentencesSimilarTwo(words1, words2, paris));
	}

	private void union(String parent, String child, Map<String, String> parentMap) {
		String grandParent = find(parent, parentMap);
		String grandChild = find(child, parentMap);

		if(!grandParent.equals(grandChild)) parentMap.put(grandChild, grandParent);
	}

	private String find(String cur, Map<String, String> parentMap) {
		while(parentMap.get(cur) != null) {
			cur = parentMap.get(cur);
		}
		return cur;
	}

	public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
		if(words1.length != words2.length) return false;

		Map<String, String> parentMap = new HashMap<>();

		for(List<String> pair : pairs) {
			union(pair.get(0), pair.get(1), parentMap);
		}

		for(int i = 0; i < words1.length; i++) {
			if(!words1[i].equals(words2[i]) && !find(words1[i], parentMap).equals(find(words2[i], parentMap))) return false;
		}
		return true;
 	}
}
