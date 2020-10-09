package medium.Lexicographically_Smallest_Equivalent_String;

import org.junit.Test;

/**
 * Runtime : 3ms(36.05%)
 * Memory : 37.4mb(21.09%)
 */
public class Solution {
	@Test
	public void execute() {
		String A = "ddvexktmenioinkrgbpuhkuixocxgiwlbbdouqvrpnnrsdueot";
		String B = "ksvvwxspkqnfsjqikdssbrwooshgrdhpliptxhacskrwgxsskn";
		String S = "pcjfbtxshbboarojnopmxvfmctzrwrgxzispbllycynlssjtqz";

		System.out.println(smallestEquivalentString(A, B, S));
	}
	public String smallestEquivalentString(String A, String B, String S) {
		Integer[] wordArr = new Integer[26];

		for(int i = 0; i < A.length(); i++) {
			if(A.charAt(i) == B.charAt(i)) continue;
			int parent = Math.min(A.charAt(i), B.charAt(i)) - 'a';
			int child = Math.max(A.charAt(i), B.charAt(i)) - 'a';

			if(wordArr[child] == null || wordArr[child] == parent) wordArr[child] = parent;
			else {
				int orgParentAncestor = wordArr[child];
				int parentAncestor = parent;
				while(wordArr[orgParentAncestor] != null) orgParentAncestor = wordArr[orgParentAncestor];
				while(wordArr[parentAncestor] != null) parentAncestor = wordArr[parentAncestor];

				if(orgParentAncestor != parentAncestor) {
					wordArr[child] = Math.min(parentAncestor, orgParentAncestor);
					wordArr[Math.max(parentAncestor, orgParentAncestor)] = wordArr[child];
				}
			}
		}

		StringBuilder builder = new StringBuilder();

		for(char ch : S.toCharArray()) {
			int minCh = ch  - 'a';
			while(wordArr[minCh] != null) {
				minCh = wordArr[minCh];
			}
			builder.append((char)(minCh + 'a'));
		}

		return builder.toString();
	}
}
