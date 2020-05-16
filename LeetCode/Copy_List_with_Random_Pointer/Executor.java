package Copy_List_with_Random_Pointer;

import org.junit.Test;
import util.Node;
import util.PerformanceUtil;

public class Executor {
	@Test
	public void test() {
		Node head = Node.makeList(-7,null,13,0,-11,4,10,2,1,0);

		PerformanceUtil.calcPerformance(new Solution(), (Node)head);

	}
}
