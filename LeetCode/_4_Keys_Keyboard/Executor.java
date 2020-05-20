package _4_Keys_Keyboard;

import org.junit.Test;
import util.PerformanceUtil;

public class Executor {
    @Test
    public void test() {
        int num = 11;
        PerformanceUtil.calcPerformance(new Solution(), num);
    }
}
