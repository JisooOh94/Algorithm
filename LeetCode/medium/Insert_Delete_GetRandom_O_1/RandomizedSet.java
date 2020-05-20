package medium.Insert_Delete_GetRandom_O_1;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class RandomizedSet {
	private Set<Integer> set;
	public RandomizedSet() {
		set = new HashSet<>();
	}

	public boolean insert(int val) {
		return set.add(val);
	}

	public boolean remove(int val) {
		return set.remove(val);
	}

	public int getRandom() {
		Integer[] arr = set.toArray(new Integer[set.size()]);
		if(arr.length == 1) return arr[0];
		else return arr[ThreadLocalRandom.current().nextInt(arr.length)];
	}
}
