package com.java.problem;

import java.util.Scanner;

/**
 * Baekjoon Online Judge
 * 2579번
 */
public class 계단오르기 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int i;
        int n = sc.nextInt();
        int d[][] = new int[n+1][2];
        int a[] = new int[n+1];

        for(i = 1 ; i <= n ; i++) a[i] = sc.nextInt();

        d[1][0] = d[1][1] = a[1];

        for(i = 2 ; i <= n ; i++){
            d[i][0] = d[i-1][1]+a[i];
            d[i][1] = Math.max(d[i-2][0], d[i-2][1]) + a[i];
        }
        System.out.println(Math.max(d[n][0], d[n][1]));
        sc.close();
    }
}
