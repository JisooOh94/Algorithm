package easy.Split_a_String_in_Balanced_Strings;

import org.junit.Test;
import util.PerformanceUtil;

public class Executor {
    @Test
    public void test() {
        String s = "RLLLLRRRLR";
        PerformanceUtil.calcPerformance(new Solution(), s);
    }
}
