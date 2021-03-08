package medium.Evaluate_Division;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class Solution {
	@Test
	public void execute() {
		List<List<String>> equatios = Arrays.asList(
				Arrays.asList("a", "b"),
				Arrays.asList("b", "c")
		);

		double[] values = new double[]{2.0, 3.0};
		List<List<String>> queries = Arrays.asList(Arrays.asList("a", "c"));

		for(double d : calcEquation(equatios,values,queries))
			System.out.println(d);
	}
	private String getParent(String cur, Map<String, String> parent) {
		while(parent.getOrDefault(cur, cur) != cur) cur = parent.get(cur);
		return cur;
	}
	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		double[] result = new double[queries.size()];
		Map<String, String> parent = new HashMap<>();
		Map<String, Map<String, Double>> dist = new HashMap<>();

		for(int i = 0; i < equations.size(); i++) {
			String ch = getParent(equations.get(i).get(0), parent);
			String p = getParent(equations.get(i).get(1), parent);
			parent.put(ch, p);
			if(dist.get(ch) == null) dist.put(ch, new HashMap<>());
			if(dist.get(p) == null) dist.put(p, new HashMap<>());
			dist.get(ch).put(p, values[i]);
			dist.get(p).put(ch, 1 / values[i]);
		}

		for(int i = 0; i < queries.size(); i++) {
			List<String> query = queries.get(i);
			if(dist.containsKey(query.get(0)) && getParent(query.get(0), parent).equals(getParent(query.get(1), parent))) {
				String ch =  query.get(0);
				String p = query.get(1);
				double chVal = 1.0;
				double pVal = 1.0;
				String prev = ch;
				String cur = parent.getOrDefault(ch, ch);
				while(cur != prev) {
					chVal *= dist.get(prev).get(cur);
					prev = cur;
					cur = parent.getOrDefault(cur, cur);
				}
				prev = p;
				cur = parent.getOrDefault(p, p);
				while(cur != prev) {
					pVal *= dist.get(prev).get(cur);
					prev = cur;
					cur = parent.getOrDefault(cur, cur);
				}

				result[i] = chVal / pVal;
			} else {
				result[i] = -1.0;
			}
		}
		return result;
	}
}
