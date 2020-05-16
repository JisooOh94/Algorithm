package LRU_Cache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import org.junit.Test;

public class Executor {
	@Test
	public void test() {
		LRUCache cache = new LRUCache(2);

		cache.put(1, 1);
		cache.put(2, 2);

		cache.print();
		cache.printInv();
		System.out.println();

		cache.get(1);       // returns 1

		cache.print();
		cache.printInv();
		System.out.println();

		cache.put(3, 3);    // evicts key 2

		cache.print();
		cache.printInv();
		System.out.println();

		cache.get(2);       // returns -1 (not found)

		cache.print();
		cache.printInv();
		System.out.println();

		cache.put(4, 4);    // evicts key 1

		cache.print();
		cache.printInv();
		System.out.println();

		cache.get(1);       // returns -1 (not found)

		cache.print();
		cache.printInv();
		System.out.println();

		cache.get(3);       // returns 3

		cache.print();
		cache.printInv();
		System.out.println();

		cache.get(4);       // returns 4

		cache.print();
		cache.printInv();
	}

	@Test
	public void test_2() {
		LRUCache cache = new LRUCache(1);

		cache.put(2, 1);
		cache.get(2);
		cache.put(3, 2);
		cache.get(2);
		cache.get(3);
	}

	@Test
	public void test_3() {
		LRUCache cache = new LRUCache(2);


		System.out.println(cache.get(2));
		cache.put(2, 6);
		System.out.println(cache.get(1));
		cache.put(1, 5);
		cache.put(1, 2);
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
	}

	@Test
	public void test_4() {
		LRUCache cache = new LRUCache(2);


		cache.put(2, 1);
		cache.put(1, 1);
		cache.put(2, 3);
		cache.put(4, 1);
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
	}

	@Test
	public void test_5() {
		LRUCache cache = new LRUCache(10);
		cache.put(10, 13);
		cache.put(3, 17);
		cache.put(6, 11);
		cache.put(10, 5);
		cache.put(9, 10);
		System.out.println(cache.get(13));
		cache.put(2, 19);
		System.out.println(cache.get(2));
		System.out.println(cache.get(3));
		cache.put(5, 25);
		System.out.println(cache.get(8));
		cache.put(9, 22);
		cache.put(5, 5);
		cache.put(1, 30);
		System.out.println(cache.get(11));
		cache.put(9, 12);
		System.out.println(cache.get(7));
		System.out.println(cache.get(5));
		System.out.println(cache.get(8));
		System.out.println(cache.get(9));
		cache.put(4, 30);
		cache.put(9, 3);
		System.out.println(cache.get(9));
		System.out.println(cache.get(10));
		System.out.println(cache.get(10));
		cache.put(6, 14);
		cache.put(3, 1);
		System.out.println(cache.get(3));
		cache.put(10, 11);
		System.out.println(cache.get(8));
		cache.put(2, 14);
		System.out.println(cache.get(1));
		System.out.println(cache.get(5));
		System.out.println(cache.get(4));
		cache.put(11, 4);
		cache.put(12, 24);
		cache.put(5, 18);
		System.out.println(cache.get(13));
		cache.put(7, 23);
		System.out.println(cache.get(8));
		System.out.println(cache.get(12));
		cache.put(3, 27);
		cache.put(2, 12);
		System.out.println(cache.get(5));
		cache.put(2, 9);
		cache.put(13, 4);
		cache.put(8, 18);
		cache.put(1, 7);
		System.out.println(cache.get(6));
		cache.put(9, 29);
		cache.put(8, 21);
		System.out.println(cache.get(5));
		cache.put(6, 30);
		cache.put(1, 12);
		System.out.println(cache.get(10));
		cache.put(4, 15);
		cache.put(7, 22);
		cache.put(11, 26);
		cache.put(8, 17);
		cache.put(9, 29);
		System.out.println(cache.get(5));
		cache.put(3, 4);
		cache.put(11, 30);
		System.out.println(cache.get(12));
		cache.put(4, 29);
		System.out.println(cache.get(3));
		System.out.println(cache.get(9));
		System.out.println(cache.get(6));
		cache.put(3, 4);
		System.out.println(cache.get(1));
		System.out.println(cache.get(10));
		cache.put(3, 29);
		cache.put(10, 28);
		cache.put(1, 20);
		cache.put(11, 13);
		System.out.println(cache.get(3));
		cache.put(3, 12);
		cache.put(3, 8);
		cache.put(10, 9);
		cache.put(3, 26);
		System.out.println(cache.get(8));
		System.out.println(cache.get(7));
		System.out.println(cache.get(5));
		cache.put(13, 17);
		cache.put(2, 27);
		cache.put(11, 15);
		System.out.println(cache.get(12));
		cache.put(9, 19);
		cache.put(2, 15);
		cache.put(3, 16);
		System.out.println(cache.get(1));
		cache.put(12, 17);
		cache.put(9, 1);
		cache.put(6, 19);
		System.out.println(cache.get(4));
		System.out.println(cache.get(5));
		System.out.println(cache.get(5));
		cache.put(8, 1);
		cache.put(11, 7);
		cache.put(5, 2);
		cache.put(9, 28);
		System.out.println(cache.get(1));
		cache.put(2,2 );
		cache.put(7, 4);
		cache.put(4, 22);
		cache.put(7, 24);
		cache.put(9, 26);
		cache.put(13, 28);
		cache.put(11, 26);
	}
}
