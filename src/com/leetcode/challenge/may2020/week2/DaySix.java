package com.leetcode.challenge.may2020.week2;

public class DaySix {

	public String removeKdigits(String num, int k) {
		int j =0;
		while(k>0) {
			j = j > 0 ? j-1 : 0;
			while(j+1<num.length() && num.charAt(j) <= num.charAt(j+1))
				j++;

			num = num.substring(0,j) + num.substring(j+1);	
			k--;
		}

		int zeros = 0;
		while(zeros<num.length() && num.charAt(zeros)=='0')
			zeros++;

		if(zeros>0) 
			num=num.substring(zeros);
		
		return num.length()==0?"0":num;
	}

	public static void main(String[] args) {
		DaySix daySix = new DaySix();

//		File myObj = new File("C:\\hCentive\\input.txt");
//		Scanner myReader;
//		String data = "";
//		try {
//			myReader = new Scanner(myObj);
//			while (myReader.hasNextLine()) {
//				data = myReader.nextLine();
//				System.out.println(data);
//			}
//			myReader.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}


//		System.out.println(daySix.removeKdigits(data, 1000));
//		System.out.println(daySix.removeKdigits("1432219", 3));
		System.out.println(daySix.removeKdigits("10200", 1));
		System.out.println(daySix.removeKdigits("1000005", 2));
		System.out.println(daySix.removeKdigits("10", 2));
		System.out.println(daySix.removeKdigits("112", 1));
	}
}
