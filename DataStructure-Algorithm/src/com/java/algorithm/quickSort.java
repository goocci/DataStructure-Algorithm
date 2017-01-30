package com.java.algorithm;

import java.util.Arrays;

public class quickSort {
	
	public void sort(int[] data, int l, int r){
        int left = l;
        int right = r;
        int pivot = data[(l+r)/2];
        
        do{
        	// left가 pivot보다 작으면 오른쪽으로 이동, 크거나 같으면 정지
            while(data[left] < pivot) left++;
            // right가 pivot보다 크면 왼쪽으로 이동, 작거나 같으면 정지
            while(data[right] > pivot) right--;
            // 정지된 left의 위치가 정지된 right의 위치보다 작거나 같으면 swap
            if(left <= right){    
                int temp = data[left];
                data[left] = data[right];
                data[right] = temp;
                left++;
                right--;
            }
        } while (left <= right); // left의 위치와 right의 위치가 같아지는 시점이 마지막 while
        
        if(l < right) sort(data, l, right);
        if(r > left) sort(data, left, r);
    }
    
    public static void main(String[] args) {
        
    	int[] test = { 3, 10, 6, 9, 2, 7, 5, 4, 8, 1 };;
        
        quickSort quick = new quickSort();
        quick.sort(test, 0, test.length - 1);

        System.out.println(Arrays.toString(test));
    }

}
