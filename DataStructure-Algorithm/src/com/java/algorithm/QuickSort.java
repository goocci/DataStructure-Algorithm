package com.java.algorithm;

import java.util.Arrays;
/*
- 리스트 가운데서 하나의 원소를 고름(pivot 선정)
- pivot 앞에는 pivot보다 작은 값이 오고, pivot 뒤에는 pivot보다 큰 값들이 오도록 리스트를 둘로 분할한다.
- 분할된 두 개의 리스트에 대해 재귀함수를 통해 이 과정을 반복한다.
- 시간복잡도 : 최악 O(n^2), 평균 O(nlogn)
*/
public class QuickSort {
	
	public void sort(int[] data, int l, int r){
        int left = l;
        int right = r;
        int pivot = data[(l+r)/2];
        
        do{
        	// left가 pivot보다 작으면 오른쪽으로 이동, 크거나 같으면 정지
            while(data[left] < pivot) left++;
            // right가 pivot보다 크면 왼쪽으로 이동, 작거나 같으면 정지
            while(data[right] > pivot) right--;
            // 정지된 left의 위치가 정지된 right의 위치보다 작거나 같으면 값을 swap
            if(left <= right){    
                int temp = data[left];
                data[left] = data[right];
                data[right] = temp;
                left++;
                right--;
            }
        } while (left <= right); // left의 위치가 right의 위치와 같거나 커지는 시점이 마지막 while
        
        // left의 위치가 right의 위치와 같거나 커지는 곳을 기준으로 리스트를 분할해서 재귀함수를 통해 이러한 과정을 반복
        if(l < right) sort(data, l, right);
        if(r > left) sort(data, left, r);
    }
    
    public static void main(String[] args) {
        
    	int[] test = { 3, 10, 6, 9, 2, 7, 5, 4, 8, 1 };;
        
        QuickSort quick = new QuickSort();
        quick.sort(test, 0, test.length - 1);

        System.out.println(Arrays.toString(test));
    }

}
