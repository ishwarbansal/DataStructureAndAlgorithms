package com.data.structure.array;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfAPhoneNumber {

	char[][] mapping = new char[][] {{'*'},{'*'},{'a','b','c'}, {'d','e','f'}, {'g','h','i'},
		{'j','k','l'},{'m','n','o'}, {'p','q','r','s'},
		{'t','u','v'}, {'w','x','y','z'}};

		public List<String> letterCombinations(String digits) {
			List<String> res = new ArrayList<>();
			if(digits.length() == 0) return res;
			helper(digits, 0, new StringBuilder(), res);
			return res;
		}

		private void helper(String digits, int index, StringBuilder sb, List<String> res) {
			if (index == digits.length()) {
				res.add(sb.toString());
				return;
			}

			int n = digits.charAt(index) - '0';
			for(char ch: mapping[n]) {
				sb.append(ch);
				helper(digits, index+1, sb, res);
				sb.setLength(sb.length() - 1);
			}
		}
}
