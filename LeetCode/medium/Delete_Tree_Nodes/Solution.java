package medium.Delete_Tree_Nodes;

import org.junit.Test;

/**
 * Runtime : 11ms(48.15%)
 * Memory : 52.4mb(6.35%)
 */
public class Solution {
    @Test
    public void execute() {
        int nodes = 7;
        int[] parent = new int[]{-1,0,0,1,2,2,2};
        int[] value = new int[]{1,-2,4,0,-2,-1,-1};
        System.out.println(deleteTreeNodes(nodes, parent, value));
    }
    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        int[][] nodeInfo = new int[nodes][2];

        for (int i = nodes - 1; 0 <= i; i--) {
            nodeInfo[i][0]++;
            nodeInfo[i][1] += value[i];

            if (nodeInfo[i][1] == 0) {
                nodes -= nodeInfo[i][0];
            } else if(parent[i] != -1){
                nodeInfo[parent[i]][0] += nodeInfo[i][0];
                nodeInfo[parent[i]][1] += nodeInfo[i][1];
            }
        }

        return nodes;
    }
}
