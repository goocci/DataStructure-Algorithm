package com.java.problem;
import java.util.Arrays;
import java.util.Scanner;


public class 숫자삼각형 {
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int n;
		int[][] arr;
		int[][] max;
		
		n = sc.nextInt();
		if(n < 1 || n > 500){
			n = sc.nextInt();
		}
		arr = new int[n][];
		max = new int[n][];
		for(int i = 0 ; i < n ; i++){
			arr[i] = new int[i+1];
		}
		for(int i = 0 ; i < n ; i++){
			max[i] = new int[i+1];
		}
		
		for(int i = 0 ; i < n ; i++){
			for(int j = 0 ; j < arr[i].length ; j++){
				arr[i][j] = sc.nextInt();
				if(arr[i][j] < 0 || arr[i][j] > 99){
					arr[i][j] = sc.nextInt();
				}
			}
		}
		
		max[0][0] = arr[0][0];
		for(int i = 1 ; i < n ; i++){
			for(int j = 0 ; j < max[i].length ; j++){
				if(j == 0){
					max[i][j] = arr[i][j] + max[i-1][j];
					continue;
				} else if(j == max[i].length-1){
					max[i][j] = arr[i][j] + max[i-1][j-1];
					continue;
				}
				if(max[i-1][j-1] >= max[i-1][j]){
					max[i][j] = arr[i][j] + max[i-1][j-1];
					continue;
				} else if(max[i-1][j-1] < max[i-1][j]){
					max[i][j] = arr[i][j] + max[i-1][j];
					continue;
				}
			}
		}
		
		Arrays.sort(max[n-1]);
		System.out.println(max[n-1][n-1]);
	}

}
