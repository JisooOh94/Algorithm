package medium.Longest_ZigZag_Path_in_a_Binary_Tree;

import util.TreeNode;

public class Solution {
    private static final int RIGHT = 1;
    private static final int LEFT = -1;
    private int maxLength = 0;
    private void recursion(TreeNode node, int dir, int curLength, Queue<TreeNode> startNode) {
        if(dir == RIGHT && node.right != null) startNode.offer(node.right);
        else if(dir == LEFT && node.left != null) startNode.offer(node.left);

        if(dir == RIGHT && node.left == null || dir == LEFT && node.right == null) {
            maxLength = Math.max(maxLength, curLength);
            return;
        }

        recursion(dir == RIGHT ? node.left : node.right, dir * -1, curLength + 1, startNode);
    }

    public int longestZigZag(TreeNode root) {
        Queue<TreeNode> queue = new Queue<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode startNode = queue.poll();

            if(startNode.right != null) recursion(startNode.right, RIGHT, 1, queue);
            if(startNode.left != null) recursion(startNode.left, LEFT, 1, queue);
        }

        return maxLength;
    }
}
