package medium.Reduce_Array_Size_to_The_Half;

public class Best {
    public int minSetSize(int[] arr) {

        // Find the maximum number in the array
        int max = 0;
        for (int n : arr)
            max = Math.max(max, n);

        int[] map = new int[max + 1]; // Array for all numbers

        // Find the maximum frequency and update frequency for each number
        int maxFreq = 0;
        for (int n : arr) {
            map[n] += 1;
            maxFreq = Math.max(maxFreq, map[n]);
        }

        // Occurance of each frequency
        int[] count = new int[maxFreq + 1];
        for (int n : map) {
            if (n > 0) {
                count[n] += 1;
            }
        }

        int sum = 0;
        int res = 0;
        for (int i = maxFreq; i >= 0; i--) {
            while (count[i] > 0) {
                sum += i;
                res += 1;
                if (sum >= arr.length / 2) {
                    return res;
                }
                count[i] -= 1;
            }
        }
        return res;
    }
}
