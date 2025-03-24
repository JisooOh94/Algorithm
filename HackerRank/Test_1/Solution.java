package Test_1;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

/**
 * Runtime :
 */
class Result {

  /*
   * Complete the 'plusMinus' function below.
   *
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  public static void plusMinus(List<Integer> arr) {
    int cntArr[] = new int[3];

    for (int num : arr) {
      if (num > 0) cntArr[0]++;
      else if (num < 0) cntArr[1]++;
      else cntArr[2]++;
    }

    for (int cnt : cntArr) {
      if (cnt == 0) {
        System.out.println("0.000000");
      } else if (cnt == arr.size()) {
        System.out.println("1.000000");
      } else {
        String portion = String.valueOf(cnt * 1000000 / arr.size());
        StringBuilder prefix = new StringBuilder("0.");
        for (int i = 0; i < 6 - portion.length(); i++) {
          prefix.append("0");
        }
        System.out.println(prefix.toString() + portion);
      }
    }
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    Result.plusMinus(arr);

    bufferedReader.close();
  }
}
