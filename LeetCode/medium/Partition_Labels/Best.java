package medium.Partition_Labels;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Runtime : 2ms(99.22%)
 * Memory : 38.4mb(5.19%)
 */
public class Best {
    @Test
    public void test() {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> result = partitionLabels(s);
        System.out.println(result);
    }

    public List<Integer> partitionLabels(String S) {
        int[] map = new int[26];
        int prev = 0;

        List<Integer> cntList = new ArrayList<>();

        for(int i = 0 ; i < S.length(); i++){
            map[S.charAt(i) - 'a'] = i;
        }

        for(int idx = 0; idx < S.length(); idx++){
            int max = map[S.charAt(idx) - 'a'];

            while(idx < max){
                max = Math.max(max, map[S.charAt(++idx) - 'a']);
            }

            cntList.add(max - prev + 1);
            prev = max + 1;
        }

        return cntList;
    }
}
