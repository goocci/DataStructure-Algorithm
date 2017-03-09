package com.java.problem;
import java.util.Scanner;

public class 덩치 {
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int n;
		int[][] arr;
		
		n = sc.nextInt();
		if(n < 2 && n > 50){
			System.out.println("2 ~ 50 입력 바랍니다.");
			n = sc.nextInt();
		}
		arr = new int[n][2];
		
		for(int i = 0 ; i < n ; i++){
			for(int j = 0 ; j < 2 ; j++){
				arr[i][j] = sc.nextInt();
				if(arr[i][j] < 10 && arr[i][j] > 200){
					System.out.println("10 ~ 200 입력 바랍니다.");
					arr[i][j] = sc.nextInt();
				}
			}
		}
		
		int[] k = new int[n];
		for(int i = 0 ; i < k.length ; i++){
			k[i] = 1;
		}
		
		for(int i = 0 ; i < n ; i++){
			for(int j = 0 ; j < n ; j++){
				if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]){
					k[i] += 1;
				}
			}
		}
		
		for(int i = 0 ; i < k.length ; i++){
			System.out.print(k[i]+" ");
		}
		
	}

}
