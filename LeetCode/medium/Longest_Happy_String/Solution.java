package medium.Longest_Happy_String;

import org.junit.Test;

public class Solution {

    @Test
    public void test() {
        System.out.println(longestDiverseString(7,1,0));
    }
    public String longestDiverseString(int a, int b, int c) {
        int[] arr = new int[]{a,b,c};
        int maxIdx = 0;
        int midIdx = 0;
        int minIdx = 0;
        StringBuilder builder = new StringBuilder();

        if(a == 0) {
            if(b == 0) {
                if(c == 0) {
                    return "";
                }
            } else if(c == 0) {
                return b >= 2 ? "bb" : "b";
            }
        } else if(b == 0) {
            if(c == 0) {
                return a >= 2 ? "aa" : "a";
            } else {
                int min = a <= c ? a : c;
                while(true) {
                    builder.append((char)(maxIdx + 'a'));
                    builder.append((char)(maxIdx + 'a'));
                    builder.append((char)(minIdx + 'a'));
                    arr[maxIdx] -= 2;
                    arr[minIdx] -= 1;
                    if(arr[maxIdx] == 0) {
                        builder.append((char)(minIdx + 'a'));
                        break;
                    } else if(arr[minIdx] == 0) {
                        builder.append((char)(maxIdx + 'a'));
                        if(arr[maxIdx] >= 2)
                            builder.append((char)(maxIdx + 'a'));
                        break;
                    }
                }
            }
        } else if(c == 0) {

        }

        while(true) {
            if(arr[0] >= arr[1] && arr[0] >= arr[2]) {
                maxIdx = 0;
                midIdx = arr[1] >= arr[2] ? 1 : 2;
                minIdx = midIdx == 1 ? 2 : 1;
            } else if(arr[1] >= arr[0] && arr[1] >= arr[2]) {
                maxIdx = 1;
                midIdx = arr[0] >= arr[2] ? 0 : 2;
                minIdx = midIdx == 0 ? 2 : 0;
            } else if(arr[2] >= arr[0] && arr[2] >= arr[1]) {
                maxIdx = 2;
                midIdx = arr[0] >= arr[1] ? 0 : 1;
                minIdx = midIdx == 0 ? 1 : 0;
            }

            builder.append((char)(maxIdx + 'a'));
            builder.append((char)(maxIdx + 'a'));
            builder.append((char)(midIdx + 'a'));

            arr[maxIdx] -= 2;
            arr[midIdx] -= 1;

            if(arr[maxIdx] == 0) {
                builder.append((char)(minIdx + 'a'));
                for(int i = 0; i < arr[midIdx]; i++) {
                    builder.append((char)(midIdx + 'a'));
                }
                break;
            } else if(arr[midIdx] == 0) {
                while(true) {
                    builder.append((char)(maxIdx + 'a'));
                    builder.append((char)(maxIdx + 'a'));
                    builder.append((char)(minIdx + 'a'));
                    arr[maxIdx] -= 2;
                    arr[minIdx] -= 1;
                    if(arr[maxIdx] == 0) {
                        builder.append((char)(minIdx + 'a'));
                        break;
                    } else if(arr[minIdx] == 0) {
                        builder.append((char)(maxIdx + 'a'));
                        if(arr[maxIdx] >= 2)
                            builder.append((char)(maxIdx + 'a'));
                        break;
                    }
                }
                break;
            }
        }
        return builder.toString();
    }
}
