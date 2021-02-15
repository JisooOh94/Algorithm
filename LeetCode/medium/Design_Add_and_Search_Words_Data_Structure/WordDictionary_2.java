package medium.Design_Add_and_Search_Words_Data_Structure;

/**
 * Runtime : 37ms(87.27%)
 * Memory : 49.6mb(77.99%)
 * Time Compexity : add - O(n) search - O(n^2?)
 */
class WordDictionary_2 {
	private static final char DOT = '.';

	public static class Node {
		boolean endOf;
		Node[] childs;

		public Node() {
			childs = new Node[26];
		}
	}

	private Node root;

	public WordDictionary_2() {
		root = new Node();
	}

	public void addWord(String word) {
		Node cur = root;
		for(char ch : word.toCharArray()) {
			if(cur.childs[ch - 'a'] == null) {
				cur.childs[ch - 'a'] = new Node();
			}
			cur = cur.childs[ch - 'a'];
		}
		cur.endOf = true;
	}

	private boolean recursion(int cur, Node curNode, String word) {
		if(curNode == null) return false;
		else if(cur == word.length()) {
			return curNode.endOf;
		}

		if(word.charAt(cur) == DOT) {
			for(int i = 'a'; i <= 'z'; i++)
				if(recursion(cur + 1, curNode.childs[i - 'a'], word)) return true;
		} else {
			if(recursion(cur + 1, curNode.childs[word.charAt(cur) - 'a'], word)) return true;
		}

		return false;
	}

	public boolean search(String word) {
		return recursion(0, root, word);
	}
}
