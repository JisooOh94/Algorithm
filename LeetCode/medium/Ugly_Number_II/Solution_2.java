package medium.Ugly_Number_II;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.Test;

public class Solution_2 {
	@Test
	public void execute() {
		int n = 27;
		System.out.println(nthUglyNumber(n));
	}
	public int nthUglyNumber(int n) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		List<Integer> list = new LinkedList<>();
		queue.offer(1);
		list.add(1);

		while(true){
			List<Integer> newList = new LinkedList<>();
			for(Iterator<Integer> iter = list.iterator(); iter.hasNext();) {
				int oldVal = iter.next();
				int newVal_2 = oldVal * 2;
				int newVal_3 = oldVal * 3;
				int newVal_5 = oldVal * 5;

				if(!queue.contains(newVal_2)) {
					queue.offer(newVal_2);
					newList.add(newVal_2);
				}
				if(!queue.contains(newVal_3)) {
					queue.offer(newVal_3);
					newList.add(newVal_3);
				}
				if(!queue.contains(newVal_5)) {
					queue.offer(newVal_5);
					newList.add(newVal_5);
				}
				list = newList;
			}

			if(queue.size() > n * 3) {
				for(int i = 0; i < n - 1 ;i++) {
					queue.poll();
				}
				return queue.poll();
			}
		}
	}
}
