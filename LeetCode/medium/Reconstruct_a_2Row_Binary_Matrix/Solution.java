package medium.Reconstruct_a_2Row_Binary_Matrix;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Runtime : 12ms(43.18%)
 * Memory : 63.3mb(13.14%)
 */
public class Solution {
    @Test
    public void test() {
        //int upper = 2; int lower = 1; int[] colSum = new int[]{1, 1, 1};
        int upper = 2; int lower = 3; int[] colSum = new int[]{2, 2, 1, 1};
        //int upper = 5; int lower = 5; int[] colSum = new int[]{2,1,2,0,1,0,1,2,0,1};
        List<List<Integer>> result = reconstructMatrix(upper, lower, colSum);

        for(List<Integer> list : result) {
            for(int val : list) {
                System.out.print(val);
            }
            System.out.println();
        }
    }
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<Integer> upperList = new LinkedList<>();
        List<Integer> lowerList = new LinkedList<>();
        for(int sum : colsum) {
            if(sum == 2) {
                upper--; lower--;
                if(upper < 0 || lower < 0) return Collections.emptyList();
                else {
                    upperList.add(1);
                    lowerList.add(1);
                }
            } else if(sum == 1) {
                if(upper != 0 && lower != 0) {
                    if(upper >= lower) {
                        upper--;
                        upperList.add(1);
                        lowerList.add(0);
                    } else {
                        lower--;
                        upperList.add(0);
                        lowerList.add(1);
                    }
                } else if(upper != 0) {
                    upper--;
                    upperList.add(1);
                    lowerList.add(0);
                } else if(lower != 0) {
                    lower--;
                    upperList.add(0);
                    lowerList.add(1);
                } else return Collections.emptyList();
            } else {
                upperList.add(0);
                lowerList.add(0);
            }
        }

        if(upper != 0 || lower != 0) return Collections.emptyList();
        else return Arrays.asList(upperList, lowerList);
    }
}
