package com.java.algorithm;

import java.util.Arrays;

public class insertionSort {

	public static void main(String[] args){

		int[] test = { 3, 6, 9, 2, 7, 5, 4, 10, 8, 1 };
		
		/*// 나의 답
		for(int i = 0 ; i < test.length ; i++){
			int flag = -1;
			int temp = 0;
			for(int j = i ; j > -1 ; j--){
				if(test[j] > test[i]){
					flag = j;
				}
				System.out.println(flag);
			}
			if(flag != -1){
				temp = test[i];
				for(int j = i ; j > flag ; j--){
					test[j] = test[j-1];
				}
				test[flag] = temp;
				System.out.println(Arrays.toString(test));
			}
			System.out.println("=====================================");
		}*/
		
		// 정답
		for(int i = 1 ; i < test.length ; i++){
			int stdd = test[i];
			int aux = i -1;
			
			while(aux >= 0 && test[aux] > stdd){
				test[aux+1] = test[aux];
				aux--;
			}
			test[aux+1] = stdd;
		}
		
		System.out.println(Arrays.toString(test));
	}
}
