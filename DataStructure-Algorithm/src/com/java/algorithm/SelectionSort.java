package com.java.algorithm;

import java.util.Arrays;

public class SelectionSort {
	
	public static void main(String[] args){
		
		int[] test = { 3, 6, 9, 2, 7, 5, 4, 10, 8, 1 };
		int min = 0;
		int flag = 0;
		
		for(int i = 0 ; i < test.length ; i++){
			min = test[i];
			
			for(int j = i ; j < test.length ; j++){
				if(min > test[j]){
					min = test[j];
					flag = j;
				}
			}
			
			test[flag] = test[i];
			test[i] = min;
			/*System.out.println(Arrays.toString(test));*/
		}
		
		System.out.println(Arrays.toString(test));
	}

}
