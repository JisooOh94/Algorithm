package medium.Smallest_Range_II;

import org.junit.Test;

import java.util.Arrays;

public class Solution_2 {
    @Test
    public void test() {
//        int[] arr = new int[]{1}; int K = 0;
//        int[] arr = new int[]{0, 10}; int K = 2;
//        int[] arr = new int[]{1, 3, 6}; int K = 3;
        //int[] arr = new int[]{8038,9111,5458,8483,5052,9161,8368,2094,8366,9164,53,7222,9284,5059,4375,2667,2243,5329,3111,5678,5958,815,6841,1377,2752,8569,1483,9191,4675,6230,1169,9833,5366,502,1591,5113,2706,8515,3710,7272,1596,5114,3620,2911,8378,8012,4586,9610,8361,1646,2025,1323,5176,1832,7321,1900,1926,5518,8801,679,3368,2086,7486,575,9221,2993,421,1202,1845,9767,4533,1505,820,967,2811,5603,574,6920,5493,9490,9303,4648,281,2947,4117,2848,7395,930,1023,1439,8045,5161,2315,5705,7596,5854,1835,6591,2553,8628}; int K = 4643;
        int[] arr = new int[]{7,8,8,5,2}; int K = 4;
        System.out.println(smallestRangeII(arr, K));
    }

    public int smallestRangeII(int[] arr, int K) {
        Arrays.sort(arr);
        int minVal = arr[0];
        int maxVal = arr[arr.length - 1];

        int modifiedMin = Math.min(minVal + K, maxVal - K);
        int modifiedMax = Math.max(minVal + K, maxVal - K);

        for(int num : arr) {
            int plusModified = num + K;
            int minusModified = num - K;

            if(plusModified < modifiedMax && modifiedMin < plusModified) num = plusModified;
            else if(modifiedMin < minusModified && minusModified < modifiedMax) num = minusModified;
            else {
                if(plusModified - modifiedMax <= modifiedMin - minusModified) num = plusModified;
                else num = minusModified;
            }

            if(num < modifiedMin) {
                modifiedMin = num;
            }
            if(modifiedMax < num) {
                modifiedMax = num;
            }
        }

        return Math.min(modifiedMax - modifiedMin, maxVal - minVal);
    }
}
