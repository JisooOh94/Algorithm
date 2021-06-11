package medium.Minimum_Deletions_to_Make_String_Balanced;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Runtime : 68ms(15.21%)
 * Memory : 48.3mb(18.04%)
 * Time Complexity : O(n)
 * Subject : greedy
 */
public class Solution {
	public int minimumDeletions(String s) {
		int aCnt = 0, bCnt = 0;
		char aPrev = 'b', bPrev = 'a';
		List<Integer> bRemoveCntList = new LinkedList<>(), aRemoveCntList = new LinkedList<>();

		char[] charArr = s.toCharArray();
		int reverseIdx = s.length() - 1;
		int frontIdx = s.indexOf("b");

		if(frontIdx == -1) return 0;

		while(frontIdx < s.length()) {
			if(charArr[frontIdx] == 'b') {
				if(bPrev == 'a') bRemoveCntList.add(bCnt);
				bCnt++;
			}
			bPrev = charArr[frontIdx++];

			if(charArr[reverseIdx] == 'a') {
				if(aPrev == 'b') aRemoveCntList.add(aCnt);
				aCnt++;
			}
			aPrev = charArr[reverseIdx--];
		}

		if(charArr[s.length() - 1] == 'a') bRemoveCntList.add(bCnt);
		aRemoveCntList.add(aCnt);

		int minDelete = 999999;
		Collections.reverse(aRemoveCntList);

		for(Iterator<Integer> iterA = aRemoveCntList.iterator(), iterB = bRemoveCntList.iterator(); iterA.hasNext() && iterB.hasNext();)
			minDelete = Math.min(minDelete, iterA.next() + iterB.next());

		return minDelete;
	}
}
