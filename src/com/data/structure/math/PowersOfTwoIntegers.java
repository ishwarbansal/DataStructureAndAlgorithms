package com.data.structure.math;

public class PowersOfTwoIntegers {

	public int isPower(int A) {

		if(A==1)
			return 1;

		int n = (int)Math.sqrt(A);

		for(int x=2; x<=n; x++){
			int y = 2;

			double p = Math.pow(x, y);

			while(p<=A){
				if(p==A)
					return 1;
				y++;

				p = Math.pow(x,y);
			}
		}

		return 0;
	}
}
