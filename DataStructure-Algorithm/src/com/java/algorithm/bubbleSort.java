package com.java.algorithm;

import java.util.Arrays;

public class bubbleSort {
	
	public static void main(String[] args){
		
		int[] test = { 3, 6, 9, 2, 7, 5, 4, 10, 8, 1 };
		
		for(int i = 0 ; i < test.length - 1 ; i++){
			for(int j = 0 ; j < test.length - 1 ; j++){
				if(test[j] > test[j+1]){
					int temp = test[j];
					test[j] = test[j+1];
					test[j+1] = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(test));
	}
	
}
