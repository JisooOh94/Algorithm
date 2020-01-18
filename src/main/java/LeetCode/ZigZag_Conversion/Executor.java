package LeetCode.ZigZag_Conversion;

import org.junit.Assert;
import org.junit.Test;

public class Executor {
	private static final String outputEx_rowNum_3 = "PAHNAPLSIIGYIR";
	private static final String outputEx_rowNum_4 = "PINALSIGYAHRPI";
	@Test
	public void execute() {
		String input = "abcdefgh";
		int rowNum = 2;
		String output = Solution.convert(input, rowNum);

		System.out.println(output);

		//Assert.assertEquals(output, outputEx_rowNum_4);
	}
}
