package pack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Prob_1 {
	@Test
	public void execute() {
		String[] p = new String[]{
				"12","2","5","+","*","9","3","/","-"
		};
		System.out.println(solution(p));
	}

	String[] operators = new String[]{"+", "-", "/", "*"};

	private long calc(long num1, long num2, String oper) {
		long result = 0;
		switch (oper) {
			case "+" : result = num1 + num2;
				break;
			case "-" : result = num1 - num2;
				break;
			case "/" : result = num1 / num2;
				break;
			case "*" : result = num1 * num2;
				break;
		}
		return result;
	}

	private boolean contains(String[] operators, String operator) {
		for(String comp : operators) {
			if(comp.equals(operator)) return true;
		}
		return false;
	}

	private long recursion(long parentNum, long childNum, int[] operIdx, String[] p) {
		while(!contains(operators,p[operIdx[0]])) {
			long grandChildNum = Long.parseLong(p[operIdx[0]]);
			operIdx[0]++;
			childNum = recursion(childNum, grandChildNum, operIdx, p);
			operIdx[0]++;
		}
		return calc(parentNum, childNum, p[operIdx[0]]);
	}

	public long solution(String[] p) {
		int[] operIdx = new int[]{0};
		long parentNum = Long.parseLong(p[0]);
		while(operIdx[0] < p.length - 1) {
			long childNum = Long.parseLong(p[operIdx[0] + 1]);
			operIdx[0] += 2;
			parentNum = recursion(parentNum, childNum, operIdx, p);
		}
		return parentNum;
	}
}
