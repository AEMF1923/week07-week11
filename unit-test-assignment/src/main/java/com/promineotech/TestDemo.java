package com.promineotech;

import java.util.Random; 


public class TestDemo {

	public int addPositive(int a, int b) { 
	
	if((a > 0) && (b > 0)) {
		int sum = a + b; 
		return sum;
	} else {
		throw new IllegalArgumentException("Both parameters must be positive!");
	}
}
	
	
	public int randomNumberSquared() {
		int randomInt = getRandomInt(); 
		
		 return randomInt * randomInt;
		}

	


	public int getRandomInt() {
		Random random = new Random(); 
		return random.nextInt(10) + 1;
		
	}
}



//remember that you need to return a value because you are dictating this 
//in line 5 . You are declaring that you need a value back. 
//Always remember that void mean return nothing. 
