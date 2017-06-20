package com.java.problem;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/11286
 */
public class 절대값힙 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        // PriorityQueue 는 내부적으로 Comparator를 지니면서 원소들을 기준으로 오름차순이나 내림차순으로 정렬해서 원소들을 하나씩 뺀다.
        PriorityQueue<Integer> min_heap_positive = new PriorityQueue<>(); // 오름차순
        PriorityQueue<Integer> min_heap_negative = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순

        // 첫째 줄에 연산의 개수 N(1≤N≤100,000)이 주어진다.
        int N;
        while(true){
            N = sc.nextInt();
            if(N >= 1 && N <= 100000){
                break;
            }
        }

        // 다음 N개의 줄에는 연산에 대한 정보를 나타내는 정수 x가 주어진다.
        // 만약 x가 0이 아니라면 배열에 x라는 값을 넣는(추가하는) 연산이고, x가 0이라면 배열에서 가장 절대값이 가장 작은 값을 출력하고 그 값을 배열에서 제거하는 경우이다.
        // 입력되는 정수는 -2^31보다 크크거나 같고, 2^31보다 작다.
        for(int i = 0 ; i < N ; i++){
            int x;
            while (true){
                x = sc.nextInt();
                if(x >= -Math.pow(2, 31) && x <= Math.pow(2, 31)) break;
            }

            if(x == 0) {
                Integer result = 0;
                Integer positive_min_val = min_heap_positive.peek();
                Integer negative_max_val = min_heap_negative.peek();
                if(positive_min_val == null && negative_max_val ==null) {
                    result = 0;
                } else if(positive_min_val == null || negative_max_val == null){
                    if(positive_min_val == null) {
                        result = negative_max_val;
                        min_heap_negative.poll();
                    } else {
                        result = positive_min_val;
                        min_heap_positive.poll();
                    }
                } else if(positive_min_val > Math.abs(negative_max_val)) {
                    result = negative_max_val;
                    min_heap_negative.poll();
                } else if(positive_min_val < Math.abs(negative_max_val)) {
                    result = positive_min_val;
                    min_heap_positive.poll();
                } else if(positive_min_val.equals(Math.abs(negative_max_val))) {
                    // 절대값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.
                    result = negative_max_val;
                    min_heap_negative.poll();
                }
                System.out.println(result);
            }

            if(x < 0) min_heap_negative.add(x);
            if(x > 0) min_heap_positive.add(x);
        }

    }
}
