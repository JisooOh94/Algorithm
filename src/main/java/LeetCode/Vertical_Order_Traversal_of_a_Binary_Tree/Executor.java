package LeetCode.Vertical_Order_Traversal_of_a_Binary_Tree;

import org.junit.Test;
import util.PerformanceUtil;
import util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Executor {
    @Test
    public void test() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        PerformanceUtil.calcPerformance(new Solution_2(), root);
    }
}
