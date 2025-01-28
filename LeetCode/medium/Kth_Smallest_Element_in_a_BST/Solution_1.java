package medium.Kth_Smallest_Element_in_a_BST;

import util.TreeNode;

/**
 * Time Complexity : O(n)
    * 0ms Beats 100.00%
 * Space Complexity : O(n)
    * 44.85MB Beats 12.35%
 */
public class Solution_1 {

    public int kthSmallest(TreeNode root, int k) {
        TreeNode result = travers(root, k);
        return result.val;
    }

    private int smallNumCnt = 0;

    private TreeNode travers(TreeNode cur, int k) {
        if (cur.left != null) {
            TreeNode result = travers(cur.left, k);
            if (result != null) {
                return result;
            }
        }

        smallNumCnt++;
        if (smallNumCnt == k) {
            return cur;
        }

        if (cur.right != null) {
            TreeNode result = travers(cur.right, k);
            if (result != null) {
                return result;
            }
        }

        return null;
    }
}
