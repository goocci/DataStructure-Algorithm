package com.java.problem;
import java.util.Scanner;

/**
 * Created by uujc0207 on 2017. 5. 19..
 */
public class 소수합 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        int prime_sum = findPrimeAndSum(M, N);
        System.out.println();
        System.out.println("소수합: "+prime_sum);
    }

    public static int findPrimeAndSum(int M, int N){

        int prime_sum = 0;

        for(int i = N+1 ; i < M ; i++){
            if(i == 2) {
                prime_sum += i; // 2는 무조건 소수
                System.out.print(i+" ");
            }
            for(int j = 2 ; j < i ; j++){
                if(j == i-1) {
                    prime_sum += i; // 소수임
                    System.out.print(i+" ");
                }
                if(i % j == 0) break; // 소수아님
                else continue;
            }
        }

        return prime_sum;
    }
}
