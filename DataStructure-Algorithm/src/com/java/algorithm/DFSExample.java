package com.java.algorithm;

import java.util.Scanner;

public class DFSExample {
	
	static int[][] map;
	static int n;
	static int m;
	static int min;
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n+1][m+1];
		min = n * m;
		
		//이동할 수 있는 path를 입력받음
		// 0 -> 길ㄴㄴ
		// 1 -> 길ㅇㅇ
		String nString = "";
		for(int i = 0 ; i < n ; i++){
			nString = sc.next();
			for(int j = 0 ; j < m ; j++){
				map[i][j] = Integer.parseInt(nString.charAt(j)+"");
			}
		}
		
		dfs(0,0,1);
		
		System.out.println("최단거리: "+min);
	}
	
	public static void dfs(int x, int y, int length){
		
		//도착
		if(x == m-1 && y == n-1){
			System.out.println("도착!!!"+length);
			if(min > length) min = length;
			return;
		}
		
		map[y][x] = 0; //방문한 곳(현재위치)은 0 대입
		
		//왼쪽으로 이동할 경우
		if(x > 0 && map[y][x-1] == 1){
			System.out.print("좌-");
			dfs(x-1, y, length+1);
		}
		
		//오른쪽으로 이동할 경우
		if(x < m && map[y][x+1] == 1){
			System.out.print("우-");
			dfs(x+1, y, length+1);
		}
		
		//아래로 이동할 경우
		if(y < n && map[y+1][x] == 1){
			System.out.print("아래-");
			dfs(x, y+1, length+1);
		}
		
		//위로 이동할 경우
		if(y > 0 && map[y-1][x] == 1){
			System.out.print("위-");
			dfs(x, y-1, length+1);
		}
		
		System.out.println("막힘-");
		map[y][x] = 1 ; //지나간 자리를 원상태로 돌리기 위해서 1 대입
	}

}
