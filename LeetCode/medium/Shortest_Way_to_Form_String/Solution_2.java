package medium.Shortest_Way_to_Form_String;

import org.junit.Test;
import util.PerformanceUtil;
import util.Predicate;

import java.util.LinkedList;
import java.util.List;

/**
 * Runtime : 13ms
 * Memory : 39.3mb(19.05%)
 */
public class Solution_2 implements Predicate<Integer, Object> {
    @Test
    public void execute() {
//        String source = "aaaaa";
//        String target = "aaaaaaaaaaaaa";
//        String source = "abc";
//        String target = "abcbc";
//        String source = "abc";
//        String target = "acdbc";
        String source = "bxdisnclwdrpcqamhqqvudgtdbsdikhzzbnlgzlspozvhdkunxkpevnqvyrfowanagolpwvezuvnhgxvjopcvrkdaippmwgkofbo";
        String target = "ntzebqmlrzxissncdlvcxbojgbnnphtfdunjpzroegfdvieaajafjkidpxbrgsjpgmalekhjckwgygfz";
//        String source = "xyz";
//        String target = "xzyxz";
        PerformanceUtil.calcPerformance(new Solution_2(), source, target);
    }

    @Override
    public Integer test(Object... params) {
        return shortestWay((String) params[0], (String) params[1]);
    }

    public int shortestWay(String source, String target) {
        List<Integer>[] sourceWordIdxList = new LinkedList[26];
        int[] nextWordIdxList = new int[26];
        
        for (int i = 0; i < source.length(); i++) {
            if (sourceWordIdxList[source.charAt(i) - 'a'] == null)
                sourceWordIdxList[source.charAt(i) - 'a'] = new LinkedList<>();
            sourceWordIdxList[source.charAt(i) - 'a'].add(i);
        }

        int seq = 0;
        int prevWordIdx = -1;
        int nextWordIdx = -1;

        for(int i = 0; i < target.length(); i++) {
            char nextWord = target.charAt(i);
            List<Integer> nextWordIdxCandList = sourceWordIdxList[nextWord - 'a'];
            if (nextWordIdxCandList == null) return -1;

            for(int idx = nextWordIdxList[nextWord - 'a']; idx < nextWordIdxCandList.size(); idx++) {
                int nextWordCandIdx = nextWordIdxCandList.get(idx);
                if (prevWordIdx < nextWordCandIdx) {
                    nextWordIdx = nextWordCandIdx;
                    nextWordIdxList[nextWord - 'a'] = idx;
                    break;
                }
            }

            if (nextWordIdx != prevWordIdx) {
                prevWordIdx = nextWordIdx;
                continue;
            } else {
                nextWordIdxList = new int[26];
                prevWordIdx = nextWordIdxCandList.get(0);
                nextWordIdx = prevWordIdx;
                seq++;
            }
        }

        if (nextWordIdx == prevWordIdx) seq++;
        return seq;
    }
}
