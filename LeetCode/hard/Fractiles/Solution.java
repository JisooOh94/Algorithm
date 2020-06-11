package hard.Fractiles;

import org.junit.Test;

import java.util.*;

public class Solution {
    @Test
    public void test() {
        System.out.println(recursion(3, 2, 3));
    }

    private void createPermutation(Stack<Integer> stack, Queue<List<Integer>> permutationList, int limit) {
        if(stack.size() == limit) {
            permutationList.offer(new ArrayList<>(stack));
            return;
        }

        stack.push(0);
        createPermutation(stack, permutationList, limit);
        stack.pop();

        stack.push(1);
        createPermutation(stack, permutationList, limit);
        stack.pop();
    }

    private int recursion(int initCnt, int depth, int limit) {
        Queue<List<Integer>> permutationList = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        createPermutation(stack, permutationList, initCnt);

        ((LinkedList<List<Integer>>) permutationList).pollFirst();
        ((LinkedList<List<Integer>>) permutationList).pollLast();

        int selectCnt = 0;
        while(permutationList.size() > 1) {
            int min_l_cnt = 999;
            int min_l_idx = 0;
            boolean same = true;
            for(int i = 0; i < initCnt; i++) {
                int l_cnt = 0;
                for(List<Integer> list : permutationList) {
                    if(list.get(i) == 1) l_cnt++;
                }
                if(l_cnt < min_l_cnt) {
                    min_l_cnt = l_cnt;
                    min_l_idx = i;
                }

                if(min_l_cnt != 999 && l_cnt != min_l_cnt) same = false;
            }

            for(Iterator iter = permutationList.iterator(); iter.hasNext(); ){
                List<Integer> list = (List<Integer>)iter.next();
                if(list.get(min_l_idx) == 0) iter.remove();
            }
            if(!same)
                selectCnt++;
        }

        return permutationList.size() == 1 ? selectCnt + 1 : selectCnt;
//        for(List<Integer> list : permutationList) {
//            System.out.println(list);
//        }
    }
}
