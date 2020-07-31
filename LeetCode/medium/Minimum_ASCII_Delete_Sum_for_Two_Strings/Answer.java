package medium.Minimum_ASCII_Delete_Sum_for_Two_Strings;

import org.junit.Test;

public class Answer {
	@Test
	public void execute() {
		String s1 = "sea"; String s2 = "eat";
//		String s1 = "delete"; String s2 = "leet";
//		String s1 = "zyomgwqaoninimjmgrvlubqjhrzuhooukkytlrymjjqeiusguxgssjiozmvxgndcukmstsdrefhrtwqvcqtxvtapszxryazsrguszwitukccbxwjqucorvyerxvpalrpvockrfxntwsktjumkmjohknviqhuvzmnqowqazjnwedtavxxxaitcgwnnhulhqzqybgfwgapjuxjysygpcnomedaoyjywjpkijahfcwpwjjzgoczugl"; String s2 = "vlhxdnzgaojwsyzdghjgplbidswfniohpdsrczbililhubozfzjstqrnkonbpyykssdvwugcnmsqasnxylgtnuygoacnwevqbjtvyisdojnotjjrifnnmojjcgpeglqejyerhywkmuyppfscbybcjusralaosqvkhceuolvaxwrehigvdvojkyueudnwzukgijagauxyblnuajifvcsaqelotezbfecircokqhhpqoyjrzqdvuyqvscgjuehtuygbraawzqqpaqeqfxiffaunilooccmrihjoosakmxlhsmiokpmlehigqbxblzkjyzwmxsuiutubpmoravvftwhtudrprmwzvszgoqyyythptkhgscdypwcocdfpuxspdc";
		System.out.println(minimumDeleteSum(s1, s2));
	}
	int minimumDeleteSum(String s1, String s2) {
		int[][] record = new int[s1.length() + 1][s2.length() + 1];

		for (int i = 1; i <= s1.length(); i++)
			record[i][0] = record[i - 1][0] + s1.charAt(i - 1);

		for (int j = 1; j <= s2.length(); j++)
			record[0][j] = record[0][j - 1] + s2.charAt(j - 1);

		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1))
					record[i][j] = record[i - 1][j - 1];
				else
					record[i][j] = Math.min(record[i - 1][j] + s1.charAt(i - 1), record[i][j - 1] + s2.charAt(j - 1));
			}
		}
		return record[s1.length()][s2.length()];
	}
}
