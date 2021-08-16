package medium.Find_the_Celebrity;

/**
 * Runtime : 548ms(8.10%)
 * Memory : 39.3mb(62.16%)
 * Time Complexity : O(n^2)
 * Subject : greedy
 */
public class Solution {
	private boolean knows(int a, int b) {
		/* The knows API is defined in the parent class Relation.*/
		return true;
	}

	public int findCelebrity(int n) {
		int celebCandidate = -1;
		int[] knownCnt = new int[n];
		for(int i = 0; i < n; i++) {
			boolean isCeleb = true;

			for(int j = 0; j < n; j++) {
				if(i!=j && knows(i, j)) {
					knownCnt[j]++;
					isCeleb = false;
				}
			}

			if(isCeleb) {
				if(celebCandidate != -1) return -1;
				else celebCandidate = i;
			}
		}

		return celebCandidate == - 1 ? celebCandidate : knownCnt[celebCandidate] == n - 1 ? celebCandidate : -1;
	}
}
