package Remove_Nth_Node;

import java.util.LinkedList;
import java.util.List;

import util.ListNode;
import util.Predicate;

public class BestSolution implements Predicate<List, Object> {
	public List test(Object[] params ) {
		List<Integer> resultList = new LinkedList();
		ListNode head = removeNthFromEnd((ListNode)params[0], (int)params[1]);
		ListNode cur = head;
		while(cur != null) {
			resultList.add(cur.val);
			cur = cur.next;
		}

		return resultList;
	}

	//뒤에서부터 n번 앞으로 이동하면 그 앞에는 size - n 개의 노드가 남아있다
	//앞에서부터 n번 뒤로 이동하면 그 뒤에는 size - n 개의 노드가 남아있다.
	//앞에서부터 n번 뒤로 이동하고 그 뒤에 남은 노드 수 k(size - n)만큼 다시 앞에서 k번 이동한다.
	//앞에서 k 번 이동한 노드 뒤에는 n개의 노드가 남아있다. 즉 뒤에서부터 n번째 노드는 k 번 이동한 노드의 바로 다음 노드이다.
	//이를 통해 리스트 순회 1번만으로 삭제가 가능해진다....
	//천잰가..
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode newHead = new ListNode(0);
		newHead.next = head;
		ListNode p = newHead;
		ListNode runner = newHead;
		while(n>0){		//앞에서부터 n번 뒤로 이동한다. while 문 결과 runner는 앞에서 n번째 노드를 가리키고 있고 runner 뒤에는 size - n개의 노드가 남아있다.
			runner = runner.next;
			n--;
		}
		while(runner.next!=null){		//runner를 이용해 앞에서부터 n번 뒤로 이동하고 그 뒤에 남은 노드 수 k(size - n)를 계산하고 p를 이용해 앞에서 k번 이동한다.
			runner = runner.next;
			p=p.next;
		}	//앞에서 k 번 이동한 노드 뒤에는 n개의 노드가 남아있다. 즉 뒤에서부터 n번째 노드는 k 번 이동한 노드, 즉 p의 바로 다음 노드이다.
		p.next = p.next.next;
		return newHead.next;
	}
}
