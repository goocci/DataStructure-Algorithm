package com.java.problem;
import com.sun.jdi.connect.Connector;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 마이다스수 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int midas_num = 0;

        ArrayList[] measures_arr = findMeasure(N);

        System.out.println("약수: "+Arrays.toString(measures_arr));

        for(int i = 1 ; i < measures_arr.length ; i++){
            measures_arr[i] = findPrime(measures_arr[i]);
        }

        System.out.println("소수: "+Arrays.toString(measures_arr));

        for(int i = 2 ; i < measures_arr.length ; i++){
            if(Integer.parseInt(measures_arr[i].get(measures_arr[i].size()-1).toString()) <= M){ // 소수 리스트에서 맨 마지막 값과 비교
                midas_num++;
            }
        }

        System.out.println("마이다스 갯수: "+midas_num);

    }

    // 약수 구하기
    public static ArrayList[] findMeasure(int N) {

        ArrayList[] measures_arr = new ArrayList[N+1];

        for(int i = 1 ; i < measures_arr.length ; i++){
            ArrayList<Integer> measure_list = new ArrayList<>();
            measure_list.add(1); // 1은 무조건 약수
            for(int j = 2 ; j <= i ; j++){ // 자신도 무조건 약수이기 때문에 'j <= i'
                if(i % j == 0){
                    measure_list.add(j);
                } else continue;
            }
            measures_arr[i] = measure_list;
        }
        return measures_arr;
    }

    // 소수 구하기
    public static ArrayList<Integer> findPrime(ArrayList<Integer> measures){
        ArrayList<Integer> prime_list = new ArrayList<>();

        for(int i = 0 ; i < measures.size() ; i++){
            if(measures.get(i) == 2) prime_list.add(2);
            for(int j = 2 ; j < measures.get(i) ; j++){
                if(j == measures.get(i)-1) { // 소수일 경우
                    prime_list.add(measures.get(i));
                }
                if(measures.get(i) % j == 0 ) {
                    break; // 나머지 0 -> 소수X
                }
                else {
                    continue;
                }
            }
        }

        return prime_list;
    }
}