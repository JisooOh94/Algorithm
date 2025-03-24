package medium.Two_Sum_II_Input_Array_Is_Sorted;

/**
 * Time Complexity : O(n)
     * 2 ms Beats 93.40%
 * Space Complexity : O(1)
     * 47.06 MB Beats 66.38%
 */
public class Answer {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length == 2) {
            return new int[] { 1, 2 };
        }

        int frontIdx = 0;
        int rearIdx = numbers.length - 1;

        while (frontIdx < rearIdx) {
            int sum = numbers[frontIdx] + numbers[rearIdx];
            if (sum == target) {
                return new int[]{frontIdx + 1, rearIdx + 1};
            } else if (sum < target) {
                frontIdx++;
            } else {
                rearIdx--;
            }
        }

        throw new IllegalStateException();
    }
}
