package com.java.algorithm;

//모든 경우의 수 구하는 '순열' 알고리즘

/*
 * 기준점(pivot)이 되는 배열의 인덱스를 제공하면, 
해당 인덱스의 뒤쪽에 있는 값들과 위치를 변경후 기준점을 다음의 위치로 옮겨 다시 호출하는 순서로 진행한다. 
*/
public class Permutation {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        perm(arr, 0); //인덱스 0부터 피봇팅 시작
    }

    public static void perm(int[] arr, int pivot) {
        
    	//끝
        if (pivot == arr.length) { 
            print(arr);
            return;
        }
        
        for (int i = pivot; i < arr.length; i++) {
            swap(arr, i, pivot);
            perm(arr, pivot + 1); //배열의 다음 위치로 이동 후 재귀
            swap(arr, i, pivot);
        }

    }
    
    //단순 스왑
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    //출력 메소드
    public static void print(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1)
                System.out.println(arr[i]);
            else
                System.out.print(arr[i] + ",");
        }
    }
}
