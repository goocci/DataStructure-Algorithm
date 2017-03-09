package com.java.problem;
import java.util.Arrays;
import java.util.Scanner;

public class 수찾기 {
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int n, m;
		int[] nArr, sorted, mArr, checkArr;
		
		n = sc.nextInt();
		if(n < 1 && n > 100000){
			n = sc.nextInt();
		}
		nArr = new int[n];
		
		for(int i = 0 ; i < n ; i++){
			nArr[i] = sc.nextInt();
		}
		Arrays.sort(nArr);
		
		m = sc.nextInt();
		if(m < 1 && m > 100000){
			m = sc.nextInt();
		}
		mArr = new int[m];
		checkArr = new int[m];
		
		for(int i = 0 ; i < m ; i++){
			mArr[i] = sc.nextInt();
		}
		
		for(int i = 0 ; i < m ; i++){
			checkArr[i] = 0;
		}
		
		
		for(int i = 0 ; i < m ; i++){
			
			int mid;
			int high = n-1;
			int low = 0;
			
			while(high >= low){
				mid = (high+low) / 2;
				if(mArr[i] == nArr[mid]){
					checkArr[i] = 1;
					break;
				} else if(mArr[i] < nArr[mid]){
					high = mid-1;
				} else{
					low = mid+1;
				}
			}
		}
		
		for(int i = 0 ; i < m ; i++){
			System.out.println(checkArr[i]);
		}
				
	}

}
