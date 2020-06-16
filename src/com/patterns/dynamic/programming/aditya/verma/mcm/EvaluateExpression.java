package com.patterns.dynamic.programming.aditya.verma.mcm;

import java.util.HashMap;
import java.util.Map;

public class EvaluateExpression {

	Map<String, Integer> map = new HashMap<String, Integer>();

	public int getEvaluateExpressionUsingRecurssion(String s, int i, int j, boolean isMatching) {
		if(i>j)
			return 0;

		if(i==j) {
			if(isMatching == true)
				return s.charAt(i) == 'T' ? 1 : 0;
			else
				return s.charAt(i) == 'F' ? 1 : 0;
		}

		int ans = 0;

		for(int k=i+1; k<=j; k=k+2) {

			int lt = getEvaluateExpressionUsingRecurssion(s, i, k-1, true);
			int lf = getEvaluateExpressionUsingRecurssion(s, i, k-1, false);
			int rt = getEvaluateExpressionUsingRecurssion(s, k+1, j, true);;
			int rf = getEvaluateExpressionUsingRecurssion(s, k+1, j, false);

			char expression = s.charAt(k);			
			
			if(expression=='&') {
				if(isMatching)
					ans+= (lt * rt);
				else
					ans+= (lt * rf) + (lf * rt) + (lf * rf);
			}else if(expression=='|') {
				if(isMatching)
					ans+= (lt * rf) + (lf * rt) + (lt * rt);
				else
					ans+= (lf * rf);
			}else if(expression=='^'){
				if(isMatching)
					ans+= (lt * rf) + (lf * rt);
				else
					ans+= (lt * rt) + (lf * rf);
			}
		}
		return ans;
	}
	
	public int getEvaluateExpressionUsingDP(String s, int i, int j, boolean isMatching) {
		if(i>j)
			return 0;

		if(i==j) {
			if(isMatching == true)
				return s.charAt(i) == 'T' ? 1 : 0;
			else
				return s.charAt(i) == 'F' ? 1 : 0;
		}

		String tempKey = i + j + Boolean.toString(isMatching);
		if(map.get(tempKey)!=null)
			return map.get(tempKey);
		
		int ans = 0;

		for(int k=i+1; k<=j; k=k+2) {

			int lt = getEvaluateExpressionUsingRecurssion(s, i, k-1, true);
			int lf = getEvaluateExpressionUsingRecurssion(s, i, k-1, false);
			int rt = getEvaluateExpressionUsingRecurssion(s, k+1, j, true);
			int rf = getEvaluateExpressionUsingRecurssion(s, k+1, j, false);

			char expression = s.charAt(k);			
			
			if(expression=='&') {
				if(isMatching)
					ans+= (lt * rt);
				else
					ans+= (lt * rf) + (lf * rt) + (lf * rf);
			}else if(expression=='|') {
				if(isMatching)
					ans+= (lt * rf) + (lf * rt) + (lt * rt);
				else
					ans+= (lf * rf);
			}else if(expression=='^'){
				if(isMatching)
					ans+= (lt * rf) + (lf * rt);
				else
					ans+= (lt * rt) + (lf * rf);
			}
		}
		map.put(tempKey, ans);
		return ans;
	}

	

	public static void main(String[] args) {
//		String s = "T|F&T^F";
		String s = "T|T&F^T";
		EvaluateExpression palindromePartioning = new EvaluateExpression();
		
		System.out.println("getEvaluateExpressionUsingRecurssion  "+ palindromePartioning.getEvaluateExpressionUsingRecurssion(s, 0, s.length()-1, true));
		
		System.out.println("getEvaluateExpressionUsingDP  "+ palindromePartioning.getEvaluateExpressionUsingDP(s, 0, s.length()-1, true));
	}
}
