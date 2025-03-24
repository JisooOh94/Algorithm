package medium.Remove_Duplicates_from_Sorted_Array_2;

public class Aswer {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int storeIdx = 1; // Pointer for current index in the array
        int duplicateCnt = 1; // Count of the current element occurrences

        for (int cutIdx = 1; cutIdx < nums.length; cutIdx++) {
            if (nums[cutIdx] == nums[cutIdx - 1]) {
                duplicateCnt++; // Increment count for the current element
            } else {
                duplicateCnt = 1; // Reset count for new element
            }

            if (duplicateCnt <= 2) {
                nums[storeIdx++] = nums[cutIdx]; // Update the array in place
            }
        }

        return storeIdx; // Return the new array length
    }
}
