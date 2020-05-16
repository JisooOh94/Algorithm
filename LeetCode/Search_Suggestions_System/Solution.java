package Search_Suggestions_System;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import util.Predicate;

/**
 * Runtime : 14ms(78.13%)
 * Memory : 45.8mb(100.00%)
 */
public class Solution implements Predicate<List, Object> {
	@Test
	public List test(Object... params) {
		return suggestedProducts((String[])params[0], (String)params[1]);
	}

	public List<List<String>> suggestedProducts(String[] products, String searchWord) {
		Arrays.sort(products);

		List<List<String>> resultList = new LinkedList<>();
		List<String> subList = Arrays.asList(products);


		for(int i = 0; i < searchWord.length(); i++) {
			char targetWord = searchWord.charAt(i);
			List<String> curSubList = new LinkedList<>();

			for(String product : subList) {
				if(!curSubList.isEmpty() && product.charAt(i) != targetWord) break;

				if(product.length() > i && product.charAt(i) == targetWord) {
					curSubList.add(product);
				}
			}

			resultList.add(new LinkedList<>(curSubList.size() > 3 ? curSubList.subList(0,3) : curSubList));

			subList = curSubList;
		}

		return resultList;
	}
}
