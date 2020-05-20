package medium.Vertical_Order_Traversal_of_a_Binary_Tree;

import util.Predicate;
import util.TreeNode;

import java.util.*;

public class Solution_2 implements Predicate<List<List<Integer>>, Object> {
    @Override
    public List<List<Integer>> test(Object... params) {
        return verticalTraversal((TreeNode) params[0]);
    }

    private class Info {
        TreeNode node;
        int idx;
        boolean isNegative;

        public Info(TreeNode node, int idx, boolean isNegative) {
            this.node = node;
            this.idx = idx;
            this.isNegative = isNegative;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if(root == null) return Collections.emptyList();
        else if(root.right == null && root.left == null) return Arrays.asList(Arrays.asList(root.val));

        List<List<Integer>> nList = new LinkedList<>();
        List<List<Integer>> pList = new LinkedList<>();
        Queue<Info> queue = new LinkedList<>();

        pList.add(new ArrayList<Integer>() {{
            add(root.val);
        }});
        queue.offer(new Info(root, 0, false));

        while (!queue.isEmpty()) {
            Info cur = queue.poll();

            TreeNode rightChild = cur.node.right;
            TreeNode leftChild = cur.node.left;

            int childIdx = 0;
            boolean childNegative = true;

            if (leftChild != null && cur.isNegative) {
                childIdx = cur.idx + 1;
                if (childIdx < nList.size()) nList.get(childIdx).add(leftChild.val);
                else nList.add(new ArrayList<Integer>() {{
                    add(leftChild.val);
                }});
                queue.offer(new Info(leftChild, childIdx, childNegative));
            } else if (leftChild != null && !cur.isNegative) {
                if (cur.idx == 0 && nList.isEmpty()) {
                    childIdx = 0;
                    nList.add(new ArrayList<Integer>() {{
                        add(leftChild.val);
                    }});
                } else if (cur.idx == 0 && !nList.isEmpty()) {
                    childIdx = 0;
                    nList.get(childIdx).add(leftChild.val);
                } else {
                    childIdx = cur.idx - 1;
                    pList.get(childIdx).add(leftChild.val);
                    childNegative = false;
                }
                queue.offer(new Info(leftChild, childIdx, childNegative));
            }

            childNegative = false;
            if (rightChild != null && cur.isNegative) {
                if (cur.idx == 0 && pList.isEmpty()) {
                    childIdx = 0;
                    pList.add(new ArrayList<Integer>() {{ add(rightChild.val); }});
                } else if(cur.idx == 0 && !pList.isEmpty()) {
                    childIdx = 0;
                    pList.get(childIdx).add(rightChild.val);
                } else {
                    childIdx = cur.idx - 1;
                    nList.get(childIdx).add(rightChild.val);
                    childNegative = true;
                }
                queue.offer(new Info(rightChild, childIdx, childNegative));
            } else if(rightChild != null && !cur.isNegative){
                childIdx = cur.idx + 1;
                if (childIdx < pList.size()) pList.get(childIdx).add(rightChild.val);
                else pList.add(new ArrayList<Integer>() {{ add(rightChild.val); }});

                queue.offer(new Info(rightChild, childIdx, childNegative));
            }
        }
        Collections.reverse(nList);
        nList.addAll(pList);

        return nList;
    }
}
