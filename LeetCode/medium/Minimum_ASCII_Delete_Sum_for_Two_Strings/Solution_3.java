package medium.Minimum_ASCII_Delete_Sum_for_Two_Strings;

import org.junit.Test;

/**
 * Runtime : 15ms(89.64%)
 * Memory : 39.8mb(70.00%)
 */
public class Solution_3 {
	@Test
	public void execute() {
//		String s1 = "sea"; String s2 = "eat";
//		String s1 = "delete"; String s2 = "leet";
		String s1 = "zyomgwqaoninimjmgrvlubqjhrzuhooukkytlrymjjqeiusguxgssjiozmvxgndcukmstsdrefhrtwqvcqtxvtapszxryazsrguszwitukccbxwjqucorvyerxvpalrpvockrfxntwsktjumkmjohknviqhuvzmnqowqazjnwedtavxxxaitcgwnnhulhqzqybgfwgapjuxjysygpcnomedaoyjywjpkijahfcwpwjjzgoczugl"; String s2 = "vlhxdnzgaojwsyzdghjgplbidswfniohpdsrczbililhubozfzjstqrnkonbpyykssdvwugcnmsqasnxylgtnuygoacnwevqbjtvyisdojnotjjrifnnmojjcgpeglqejyerhywkmuyppfscbybcjusralaosqvkhceuolvaxwrehigvdvojkyueudnwzukgijagauxyblnuajifvcsaqelotezbfecircokqhhpqoyjrzqdvuyqvscgjuehtuygbraawzqqpaqeqfxiffaunilooccmrihjoosakmxlhsmiokpmlehigqbxblzkjyzwmxsuiutubpmoravvftwhtudrprmwzvszgoqyyythptkhgscdypwcocdfpuxspdc";
		System.out.println(minimumDeleteSum(s1, s2));
	}

	public int minimumDeleteSum(String s1, String s2) {
		int[][] record = new int[s1.length() + 1][s2.length() + 1];

		int totalScore = 0;

		for(int i = 1; i <= s1.length(); i++) {
			totalScore += s1.charAt(i - 1);
			for(int j = 1; j <= s2.length(); j++) {
				if(i == s1.length()) totalScore += s2.charAt(j - 1);
				record[i][j] = s1.charAt(i - 1) == s2.charAt(j - 1) ? s1.charAt(i - 1) * 2 + record[i - 1][j - 1] : Math.max(record[i - 1][j], record[i][j - 1]);
			}
		}
		return totalScore - record[s1.length()][s2.length()];
	}
}
