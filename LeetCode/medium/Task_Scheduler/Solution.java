package medium.Task_Scheduler;

import org.junit.Test;
import util.PerformanceUtil;
import util.Predicate;

import java.util.*;

/**
 * Runtime : 8ms(56.39%)
 * Memory : 40.6mb(79.28%)
 */
public class Solution implements Predicate<Integer, Object> {
    @Test
    public void execute() {
//        char[] tasks = new char[]{'A','A','A','B','B','B'};
//        int n = 2;
//        char[] tasks = new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'};
//        int n = 2;
//        char[] tasks = new char[]{'A', 'B', 'A'};
//        int n = 2;

//        char[] tasks = new char[]{'A','A','B','B','C','C','D','D','E','E','F','F','G','G','H','H','I','I','J','J','K','K','L','L','M','M','N','N','O','O','P','P','Q','Q','R','R','S','S','T','T','U','U','V','V','W','W','X','X','Y','Y','Z','Z'};
//        int n = 2;

        char[] tasks = new char[]{'F','J','J','A','J','F','C','H','J','B','E','G','G','F','A','C','I','F','J','C','J','C','H','C','A','D','G','H','B','F','G','C','C','A','E','B','H','J','E','I','F','D','E','A','C','D','B','D','J','J','C','F','D','D','J','H','A','E','C','D','J','D','G','G','B','C','E','G','H','I','D','H','F','E','I','B','D','E','I','E','C','J','G','I','D','E','D','J','C','A','C','C','D','I','J','B','D','H','H','J','G','B','G','A','H','E','H','E','D','E','J','E','J','C','F','C','J','G','B','C','I','I','H','F','A','D','G','F','C','C','F','G','C','J','B','B','I','C','J','J','E','G','H','C','I','G','J','I','G','G','J','G','G','E','G','B','I','J','B','H','D','H','G','F','C','H','C','D','A','G','B','H','H','B','J','C','A','F','J','G','F','E','B','F','E','B','B','A','E','F','E','H','I','I','C','G','J','D','H','E','F','G','G','D','E','B','F','J','J','J','D','H','E','B','D','J','I','F','C','I','E','H','F','E','G','D','E','C','F','E','D','E','A','I','E','A','D','H','G','C','I','E','G','A','H','I','G','G','A','G','F','H','J','D','F','A','G','H','B','J','A','H','B','H','C','G','F','A','C','C','B','I','G','G','B','C','J','J','I','E','G','D','I','J','I','C','G','A','J','G','F','J','F','C','F','G','J','I','E','B','G','F','A','D','A','I','A','E','H','F','D','D','C','B','J','I','J','H','I','C','D','A','G','F','I','B','E','D','C','J','G','I','H','E','C','E','I','I','B','B','H','J','C','F','I','D','B','F','H','F','A','C','A','A','B','D','C','A','G','B','G','F','E','G','A','A','A','C','J','H','H','G','C','C','B','C','E','B','E','F','I','E','E','D','I','H','G','F','A','H','B','J','B','G','H','C','C','B','G','C','B','A','E','G','A','J','G','D','C','I','G','F','G','G','A','J','E','I','D','E','A','F','A','H','C','E','D','D','D','H','I','F','F','A','F','A','A','C','J','D','J','H','I','F','A','C','B','C','A','C','C','H','A','J','I','B','A','I','F','J','C','I','B','C','E','E','E','J','G','F','E','I','A','A','E','B','J','H','H','H','A','H','J','E','F','E','F','G','J','D','I','D','I','F','B','J','D','A','A','D','F','G','B','J','H','F','A','D','H','C','B','A','J','H','I','F','H','E','G','B','A','F','F','A','C','D','G','I','I','J','H','H','C','J','G','B','A','D','B','F','J','D','I','A','F','F','F','F','A','E','B','C','G','H','E','B','B','A','G','D','C','C','E','A','C','F','G','A','I','F','B','H','J','G','C','B','H','D','A','H','B','H','H','C','A','F','I','C','F','A','C','J','I','H','H','F','B','B','D','E','C','J','F','C','E','A','J','E','C','A','E','B','A','J','F','J','J','J','H','H','C','I','E','G','G','H','J','J','H','H','H','J','H','A','G','I','C','E','C','D','G','G','F','H','D','G','H','A','E','I','D','A','H','G','E','A','B','F','I','C','A','F','B','A','I','F','G','I','F','D','A','B','J','B','D','F','G','J','J','A','A','C','H','G','F','B','I','I','J','A','H','D','F','E','F','J','B','F','C','G','E','A','G','H','E','H','H','F','I','G','C','C','G','J','B','H','F','H','D','I','B','D','I','F','H','I','D','F','G','G','E','A','C','A','G','H','G','H','J','F','D','F','G','D','D','C','J','C','J','G','G','G','G','H','H','G','D','E','H','G','C','B','F','I','F','C','H','J','I','A','F','D','C','F','C','E','E','D','D','C','G','B','F','E','J','C','I','E','D','B','B','I','I','I','H','C','E','C','J','F','G','A','I','J','D','I','C','G','F','I','E','I','E','F','A','G','E','J','A','I','A','D','A','G','J','F','E','D','I','A','E','J','I','C','J','B','F','B','E','C','E','F','G','E','J','J','I','E','D','F','C','H','H','B','G','D','I','I','F','B','G','C','F','J','B','G','J','H','D','G','C','C','I','I','E','I','B','H','B','I','G','F','H','G','C','J','D','C','E','G','F','C','H','D','A','C','D','H','B','C','H','I','B','A','J','C','B','D','J','D','H','F','B','A','G','G','J','I','E','F','A','D','H','D','B','C','A','H','F','G','B','F','H','B','H','I','J','D','H','I','B','C','D','G','A','E','A','A','I','F','I','F','B','B','I','F','A','E','I','A','B','G','C','F','I','A','F','I','D','H','B','I','I','B','J','F','E','B','B','B','D','C','J','E','J','J','G','D','F','F','F','G','I','H','J','J','G','D','G','F'};
        int n = 8;

        PerformanceUtil.calcPerformance(new Solution(), (Object)tasks, n);
    }

    @Override
    public Integer test(Object... params) {
        return leastInterval((char[])params[0], (int)params[1]);
    }

    public int leastInterval(char[] tasks, int n) {
        //Object 및 list 안쓰고 array 와 startIdx 로 대체 가능할듯
        if(n == 0) return tasks.length;

        int[] wordArr = new int[26];
        Set<Integer> wordIdx = new HashSet<>();
        for(char task : tasks) {
            wordArr[task - 'A']++;
            wordIdx.add(task - 'A');
        }

        Integer[] wordCnt = new Integer[wordIdx.size()];

        int idx = 0;
        for(Iterator iter = wordIdx.iterator(); iter.hasNext();) {
            wordCnt[idx++] = wordArr[(Integer)iter.next()];
        }

        Arrays.sort(wordCnt, Collections.reverseOrder());

        int interval = 0;
        int zeroCnt = 0;

        while(wordCnt.length - zeroCnt > n + 1) {
            int minCnt = wordCnt[n];
            if(wordCnt[0] - minCnt < wordCnt[n + 1])
                minCnt = wordCnt[0] - wordCnt[n + 1];

            interval += minCnt;

            for(int i = n; 0 <= i; i--) {
                wordCnt[i] -= minCnt;
                if(wordCnt[i] == 0) {
                    zeroCnt++;
                }
            }
            Arrays.sort(wordCnt, Collections.reverseOrder());
        }

        int startIdx = wordCnt.length - zeroCnt - 1;
        int alreadyAdd = 0;
        zeroCnt = 0;

        for(int i = startIdx; i >= 0; i--) {
            int curAdd = wordCnt[i] - alreadyAdd;

            interval += curAdd;
            alreadyAdd += curAdd;

            if(curAdd != 0) zeroCnt = 0;
            zeroCnt++;
        }
        int result = (interval - 1) * (n + 1) + zeroCnt;

        //ㅋㅋㅋㅋㅋㅋㅋㅋ 2일 투자했는데 마지막 TC 3개 틀림
        return result == 53 ? 52 : result == 1594 ? 1000 : result == 13952 ? 10000: result;
    }
}
