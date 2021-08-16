package medium.Find_the_Celebrity;

/**
 * Time Complexity : O(n)
 */
public class Answer {
	private boolean knows(int a, int b) {
		/* The knows API is defined in the parent class Relation.*/
		return true;
	}

	public int findCelebrity(int n) {
		int candidate = 0;
		for(int i = 1; i < n; i++){
			if(knows(candidate, i))
				candidate = i;
		}

		for(int i = 0; i < n; i++){
			if(i != candidate && (knows(candidate, i) || !knows(i, candidate))) return -1;
		}
		return candidate;
	}
}
