package medium.Task_Scheduler;

import org.junit.Test;
import util.PerformanceUtil;
import util.Predicate;

import java.util.*;

public class Solution implements Predicate<Integer, Object> {
    @Test
    public void execute() {
        char[] tasks = new char[]{'A','A','A','B','B','B'};
        int n = 50;

        PerformanceUtil.calcPerformance(new Solution(), (Object)tasks, n);
    }

    @Override
    public Integer test(Object... params) {
        return leastInterval((char[])params[0], (int)params[1]);
    }
    private class Task {
        char taskId;
        int remain;

        public Task(char taskId, int remain) {
            this.taskId = taskId;
            this.remain = remain;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        if(n == 0) return tasks.length;

        LinkedList<Task> list = new LinkedList<>();
        char taskId = tasks[0];
        int taskCnt = 0;
        for (char task : tasks) {
            if (task != taskId) {
                list.add(new Task(taskId, taskCnt));
                taskCnt = 0;
                taskId = task;
            }
            taskCnt++;
        }

        list.add(new Task(taskId, taskCnt));
        Collections.sort(list, Comparator.comparingInt(e -> e.remain));

        int interval = 0;

        while (list.size() > n + 1) {
            int loopCnt = list.getFirst().remain;
            interval += loopCnt * (n + 1);

            int idx = 0;
            for (Iterator iter = list.iterator(); idx < n + 1; idx++) {
                Task task = (Task) iter.next();
                task.remain -= loopCnt;

                if (task.remain == 0) iter.remove();
            }
        }

        int minusNum = list.getFirst().remain;
        interval += minusNum * (n + 1);
        list.removeFirst();

        int zeroCnt = 0;
        for(Task task : list) {
            int remain = task.remain - minusNum;
            interval += remain  * (n + 1);
            minusNum += remain;

            if(remain != 0) zeroCnt = 0;
            zeroCnt++;
        }

        return interval - zeroCnt;
    }
}
