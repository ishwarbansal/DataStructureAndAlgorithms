package com.patterns.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EvaluateExpression {
	public static List<Float> evaulate(String input) {
		List<Float> result= new ArrayList<Float>();
		Character myChar = null;
		result= evaluateRecursive(input,result,myChar);
		return result;

	}
	public static List<Float> evaluateRecursive(String input, List<Float> result, Character currChar) {
		if(currChar!=null && !(currChar.equals("*")||currChar.equals("+")||currChar.equals("-"))) {
			result.add(Float.parseFloat(currChar.toString()));
		}else {
			for(int i=0;i<input.length();i++) {
				Character currentChar=input.charAt(i);
				List<Float> leftPart=evaluateRecursive(input.substring(0,i),result,currentChar);
				List<Float> rightPart=evaluateRecursive(input.substring(i+1),result,currentChar);
				if(currentChar.equals("*")) {
					result.add(leftPart.get(0)*rightPart.get(0));
				}else if (currentChar.equals("+")) {
					result.add(leftPart.get(0)+rightPart.get(0));
				}else if (currentChar.equals("-")) {
					result.add(leftPart.get(0)-rightPart.get(0));
				}

			}
		}
		return result;
	}



	public static void main(String[] args) {
		List<Float> res=evaulate("1+2*3");
		System.out.println(Arrays.toString(res.toArray()));
	}

}
