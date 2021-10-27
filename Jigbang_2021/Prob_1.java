import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.junit.Test;

public class Prob_1 {

	@Test
	public void execute() {
		String str = "xyz";
		int jump = 2;
		System.out.println(parse(str.length(), jump, str));
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int len = Integer.parseInt(input[0]);
		int jump = Integer.parseInt(input[1]);
		String str = br.readLine();
		System.out.println(parse(len, jump, str));
	}

	private static String parse(int len, int jump, String str) {
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < len; i++) {
			int jumpedChar = ((str.charAt(i) - 'a') + (int)Math.pow(jump, i + 1)) % 26;
			builder.append((char)(jumpedChar + 'a'));
		}
		return builder.toString();
	}
}
