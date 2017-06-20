package com.java.problem;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/1927
 */
public class 최소힙 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        // PriorityQueue 는 내부적으로 Comparator를 지니면서 원소들을 기준으로 오름차순이나 내림차순으로 정렬해서 원소들을 하나씩 뺀다.
        PriorityQueue<Integer> min_heap = new PriorityQueue<>();

        // 첫째 줄에 연산의 개수 N(1≤N≤100,000)이 주어진다.
        int N;
        while(true){
            N = sc.nextInt();
            if(N >= 1 && N <= 100000){
                break;
            }
        }

        // 다음 N개의 줄에는 연산에 대한 정보를 나타내는 정수 x가 주어진다.
        // 만약 x가 자연수라면 배열에 x라는 값을 넣는(추가하는) 연산이고, x가 0이라면 배열에서 가장 작은 값을 출력하고 그 값을 배열에서 제거하는 경우이다.
        // 입력되는 자연수는 2^31보다 작다.

        for(int i = 0 ; i < N ; i++){
            int x;
            while (true){
                x = sc.nextInt();
                if(x >= 0 && x <= Math.pow(2, 31)){
                    break;
                }
            }
            if(x == 0){
                Integer output = min_heap.poll();
                if(output == null) output = 0;
                System.out.println(output);
                continue;
            }
            min_heap.add(x);
        }


    }
}
