import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _1_은_2_가_좋지만_2_는_생각이_없다 {
	private static boolean isValid(String str) {
		if(str == null || str.length() == 0) return false;

		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '1') {
				if(i + 1== str.length() || str.charAt(i + 1) != '2') return false;
			} else if(str.charAt(i) != '2') {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		System.out.println("Hello Goorm! Your input is " + input);

		System.out.println(isValid(input));
	}
}
