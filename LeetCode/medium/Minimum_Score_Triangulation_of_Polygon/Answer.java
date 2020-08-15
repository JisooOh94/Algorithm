package medium.Minimum_Score_Triangulation_of_Polygon;

public class Answer {
	public int minScoreTriangulation(int[] a) {
		return helper(a, 0, a.length-1);
	}
	private int helper(int[] a, int i, int j){
		if( (j-i+1) < 3) return 0;
		int min = Integer.MAX_VALUE;
		for(int k=i+1; k < j; k++)
			min = Math.min(min, helper(a, i, k)+a[i]*a[k]*a[j]+helper(a, k, j));
		return min;
	}
}
