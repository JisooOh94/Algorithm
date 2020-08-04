package medium.Longest_ZigZag_Path_in_a_Binary_Tree;

import org.junit.Test;
import util.TreeNode;

/**
 * Runtime : 6ms(73.85%)
 * Memory : 51.3mb(64.10%)
 */
public class Solution {
    @Test
    public void execute() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.left.right.left = new TreeNode(1);
        root.left.right.right = new TreeNode(1);
        root.left.right.left.right = new TreeNode(1);


//        TreeNode root = new TreeNode(1);
//        root.right = new TreeNode(2);
//        root.right.left = new TreeNode(3);
//        root.right.right = new TreeNode(4);
//        root.right.right.left = new TreeNode(5);
//        root.right.right.right = new TreeNode(6);
//        root.right.right.left.right = new TreeNode(7);
//        root.right.right.left.right.right = new TreeNode(8);

//        TreeNode root = new TreeNode(1);

//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(6);
//        root.right.right= new TreeNode(7);
//        root.right.right.left = new TreeNode(8);
//        root.right.right.right = new TreeNode(9);
//        root.right.right.right.left = new TreeNode(10);
        System.out.println(longestZigZag(root));
    }
    private static final int RIGHT = 1;
    private static final int LEFT = -1;
    private int maxLength = 0;
    private void recursion(TreeNode node, int dir, int curLength) {
        curLength++;
        if(dir == RIGHT && node.right != null) recursion(node.right, RIGHT, 0);
        else if(dir == LEFT && node.left != null) recursion(node.left, LEFT, 0);

        if(dir == RIGHT && node.left == null || dir == LEFT && node.right == null) {
            maxLength = Math.max(maxLength, curLength);
            return;
        }

        recursion(dir == RIGHT ? node.left : node.right, dir * -1, curLength);
    }

    public int longestZigZag(TreeNode root) {
        if(root.right != null) recursion(root.right, RIGHT, 0);
        if(root.left != null) recursion(root.left, LEFT, 0);

        return maxLength;
    }
}
