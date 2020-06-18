package medium.Reorganize_String;

import org.junit.Test;
import util.PerformanceUtil;
import util.Predicate;

import java.util.*;

/**
 * Runtime : 6ms(19.12%)
 * Memory : 37.4mb(80.91%)
 */
public class Solution implements Predicate<String, Object> {
    @Test
    public void test_2() {
        System.out.println((char)(16 + 'a'));
    }
    @Test
    public void execute() {
//        String param = "aab";
        String param = "tndsewnllhrtwsvxenkscbivijfqnysamckzoyfnapuotmdexzkkrpmppttficzerdndssuveompqkemtbwbodrhwsfpbmkafpwyedpcowruntvymxtyyejqtajkcjakghtdwmuygecjncxzcxezgecrxonnszmqmecgvqqkdagvaaucewelchsmebikscciegzoiamovdojrmmwgbxeygibxxltemfgpogjkhobmhwquizuwvhfaiavsxhiknysdghcawcrphaykyashchyomklvghkyabxatmrkmrfsppfhgrwywtlxebgzmevefcqquvhvgounldxkdzndwybxhtycmlybhaaqvodntsvfhwcuhvuccwcsxelafyzushjhfyklvghpfvknprfouevsxmcuhiiiewcluehpmzrjzffnrptwbuhnyahrbzqvirvmffbxvrmynfcnupnukayjghpusewdwrbkhvjnveuiionefmnfxao";
        PerformanceUtil.calcPerformance(new Solution(), param);
    }
    @Override
    public String test(Object... params) {
        return reorganizeString((String)params[0]);
    }
    public String reorganizeString(String S) {
        if(S.length() == 1) return S;

        int[] wordCnt = new int[26];
        Set<Integer> idxSet = new HashSet<>();

        for(char word : S.toCharArray()) {
            wordCnt[word - 'a']++;
            idxSet.add(word - 'a');
        }
        if(idxSet.size() == 1) return "";

        Integer idxArr[] = new Integer[idxSet.size()];
        idxSet.toArray(idxArr);

        Arrays.sort(idxArr, (e1, e2) -> wordCnt[e1] > wordCnt[e2] ? -1 : wordCnt[e1] < wordCnt[e2] ? 1 : 0);

        int fromIdx = 0;
        int toIdx = 1;
        StringBuilder sb = new StringBuilder();
        while(true) {
            int from = idxArr[fromIdx];
            int to = idxArr[toIdx];

            sb.append((char)(from + 'a'));
            sb.append((char)(to + 'a'));

            wordCnt[from]--;
            wordCnt[to]--;

            if(wordCnt[from] == 0 && wordCnt[to] != 0) {
                fromIdx = fromIdx > toIdx ? fromIdx + 1 : toIdx + 1;

                if(fromIdx == idxArr.length) {
                    if(sb.length() > wordCnt[to] + 1) {
                        int minusCnt = 0;
                        for(int i = 1; i < sb.length() - 1; i++) {
                            if(sb.charAt(i - 1) != (char)(to + 'a') && sb.charAt(i + 1) != (char)(to + 'a')) {
                                minusCnt++;
                            }
                            if(wordCnt[to] == minusCnt) {
                                for(int idx = i; 1 <= idx; idx--) {
                                    if (sb.charAt(idx - 1) != (char) (to + 'a')) {
                                        sb.insert(idx, (char)(to + 'a'));
                                    }
                                }
                                return sb.toString();
                            }
                        }
                    }
                    return "";
                }
            } else if(wordCnt[to] == 0 && wordCnt[from] != 0) {
                toIdx = toIdx > fromIdx ? toIdx + 1 : fromIdx + 1;

                if(toIdx == idxArr.length) {
                    return wordCnt[from] == 1 ? sb.toString() + (char)(from + 'a') : "";
                }
            } else if(wordCnt[from] == 0 && wordCnt[to] == 0) {
                fromIdx = fromIdx > toIdx ? fromIdx + 1 : toIdx + 1;
                toIdx = fromIdx + 1;

                if(fromIdx == idxArr.length) {
                    return sb.toString();
                } else if(toIdx == idxArr.length) {
                    return wordCnt[idxArr[fromIdx]] == 1 ? sb.toString() + (char)(idxArr[fromIdx] + 'a') : "";
                }
            }
        }
    }
}
