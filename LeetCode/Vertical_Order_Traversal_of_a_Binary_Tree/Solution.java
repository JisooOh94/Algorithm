package Vertical_Order_Traversal_of_a_Binary_Tree;

import util.Predicate;
import util.TreeNode;

import java.util.*;

public class Solution implements Predicate<List<List<Integer>>, Object> {
    @Override
    public List<List<Integer>> test(Object... params) {
        return verticalTraversal((TreeNode)params[0]);
    }

    private void recursion(TreeNode cur, int curIdx, boolean negative, List<List<Integer>> nList, List<List<Integer>> pList) {
        TreeNode leftChild = cur.left;
        TreeNode rightChild = cur.right;

        int newIdx = 0;
        boolean newNegative = false;

        if(leftChild != null) {
            if(negative) {
                if(curIdx + 1 < nList.size()) nList.get(curIdx + 1).add(leftChild.val);
                else nList.add(new ArrayList<Integer>(){{add(leftChild.val);}});
                newIdx = curIdx + 1;
                newNegative = true;
            } else {
                if(curIdx == 0){
                    if(nList.isEmpty()) nList.add(new ArrayList<Integer>(){{add(leftChild.val);}});
                    else nList.get(0).add(leftChild.val);
                    newIdx = 0;
                    newNegative = true;
                }
                else {
                    pList.get(curIdx - 1).add(leftChild.val);
                    newNegative = false;
                    newIdx = curIdx - 1;
                }
            }
            recursion(leftChild, newIdx, newNegative, nList, pList);
        }
        if(rightChild != null) {
            if(negative) {
                if(curIdx == 0) {
                    if (pList.isEmpty()) pList.add(new ArrayList<Integer>(){{add(rightChild.val);}});
                    else pList.get(0).add(rightChild.val);
                    newIdx = 0;
                    newNegative = false;
                }
                else {
                    nList.get(curIdx - 1).add(rightChild.val);
                    newIdx = curIdx - 1;
                    newNegative = true;
                }
            } else {
                if(curIdx + 1 < pList.size()) pList.get(curIdx + 1).add(rightChild.val);
                else pList.add(new ArrayList<Integer>(){{add(rightChild.val);}});

                newIdx = curIdx + 1;
                newNegative = false;
            }

            recursion(rightChild, newIdx, newNegative, nList, pList);
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> nList = new LinkedList<>();
        List<List<Integer>> pLIst = new LinkedList<>();
        pLIst.add(new ArrayList<Integer>(){{add(root.val);}});
        recursion(root, 0, false, nList, pLIst);

        Collections.reverse(nList);
        nList.addAll(pLIst);

        return nList;
    }
}
