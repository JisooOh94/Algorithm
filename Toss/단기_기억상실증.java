import java.util.*;

import org.junit.Test;

public class 단기_기억상실증 {
//	private void recentPaymentType(String str) {
//		if(str == null || str.length() == 0) return;
//		String[] bankArr = str.split(" ");
//		Deque<String> queue = new LinkedList<>();
//		Set<String> set = new LinkedHashSet<>();
//		List<String> list = new LinkedList<>();
//
//		for(int i = 0; i < bankArr.length; i++) {
//			if (!set.contains(bankArr[i])) {
//				set.add(bankArr[i]);
//				queue.offerFirst(bankArr[i]);
//				if (queue.size() > 5) set.remove(queue.pollLast());
//			} else {
//				set.remove(bankArr[i]);
//				set.add(bankArr[i]);
//			}
//			for(Iterator<String> iter = set.iterator(); iter.hasNext();) {
//				list.add(iter.hasNext() ? iter.next() + " " : iter.next());
//			}
//			Collections.reverse(list);
//			System.out.println(list.toString());
//			list.clear();
//		}
//	}

	private void recentPaymentType(String str) {
		if(str == null || str.length() == 0) return;
		String[] bankArr = str.split(" ");
		Deque<String> queue = new LinkedList<>();

		for(int i = 0; i < bankArr.length; i++) {
			if (!queue.contains(bankArr[i])) {
				queue.offerFirst(bankArr[i]);
				if (queue.size() > 5) queue.pollLast();
			} else {
				queue.remove(bankArr[i]);
				queue.offerFirst(bankArr[i]);
			}

			int cnt = 1;
			for(Iterator<String> iter = queue.iterator(); iter.hasNext();) {
				System.out.print(cnt++ < queue.size() ? iter.next() + " " : iter.next() + "\n");
			}
		}
	}

	@Test
	public void test() {
		String str = "우리 우리 우리 하나 우리 국민 삼성 농협 농협 농협 국민 저축";
		recentPaymentType(str);
	}


	@Test
	public void test2() {
		Set<Integer> set = new LinkedHashSet<>();
		set.add(4);
		set.add(1);
		set.add(2);
		set.add(3);

		for(Iterator<Integer> iter = set.iterator(); iter.hasNext();) System.out.println(iter.next());

		set.remove(4);
		set.add(4);
		for(Iterator<Integer> iter = set.iterator(); iter.hasNext();) System.out.println(iter.next());
	}
}
