package com.java.problem;
import java.util.Scanner;

public class 소수찾기 {
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int n;
		int[] arr;
		int total = 0;
		
		n = sc.nextInt();
		if(n < 0 || n > 100){
			n = sc.nextInt();
		}
		arr = new int[n];
		
		for(int i = 0 ; i < n ; i++){
			arr[i] = sc.nextInt();
			if(arr[i] < 0 || arr[i] > 1000){
				arr[i] = sc.nextInt();
			}
		}
		
		for(int i = 0 ; i < n ; i++){
			if(arr[i] == 2 || arr[i] == 3){
				total += 1;
				continue;
			}
			for(int j = 2 ; j < arr[i] ; j++){
				if(j == arr[i]-1) total += 1;
				if(arr[i] % j == 0){
					break;
				}
			}
		}
		
		System.out.println(total);
		
	}

}
