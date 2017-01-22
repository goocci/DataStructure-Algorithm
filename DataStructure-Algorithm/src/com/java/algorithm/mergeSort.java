package com.java.algorithm;

import java.util.Arrays;

public class mergeSort {
	
	public static void main(String[] args){
		
		int[] test = { 3, 10, 6, 9, 2, 7, 5, 4, 8, 1 };
		merge_Sort(test);
		System.out.println(Arrays.toString(test));
	}
	
	public static int[] merge_Sort(int array[]){
		if(array.length > 1){
			
			int lefthalf = array.length / 2;
			int righthalf = array.length - lefthalf;
			
			int[] arr1 = new int[lefthalf];
			int[] arr2 = new int[righthalf];
			// arr1는 왼쪽에 나눠진 배열, arr2는 오른쪽에 나눠진 배열
			for(int i = 0; i < lefthalf; i++){
				arr1[i] = array[i];
			}
			for(int i = lefthalf; i < lefthalf+righthalf; i++){
				arr2[i - lefthalf] = array[i];
			}
			
			// 재귀 호출 반복이 반복됨... 
			arr1 = merge_Sort(arr1);
			arr2 = merge_Sort(arr2);
			// 1칸으로 모두 쪼개지면...↓
			
			// 병합 시작
			int i = 0, j = 0, k = 0;
			
			// arr1과 arr2 중 하나라도 모든 요소들이 array(병합배열)로 정렬되어 들어오기 전까지 반복문
			while(arr1.length != j && arr2.length != k){
				if(arr1[j] < arr2[k]){
					array[i] = arr1[j];
					i++;
					j++;
				} else {
					array[i] = arr2[k];
					i++;
					k++;
				}
			}
			
			// 모든 요소들이 array로 들어오지 않은 arr1 or arr2의 추가적인 array에 들어가는 반복문
			while(arr1.length != j){
				array[i] = arr1[j];
				i++;
				j++;
			}
			while(arr2.length != k){
				array[i] = arr2[k];
				i++;
				k++;
			}
		}
		
		return array;
	}
}
