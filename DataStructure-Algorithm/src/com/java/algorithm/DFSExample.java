package com.java.algorithm;

import java.util.Scanner;

public class DFSExample {
	
	static int[][] map;
	static int[][] visited;
	static int map_size;
	static int min;
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		map_size = Integer.parseInt(sc.nextLine().trim());
		map = new int[map_size+1][map_size+1];
		min = map_size * map_size;
		
		//이동할 수 있는 path를 입력받음
		// 0 -> 길ㄴㄴ
		// 1 -> 길ㅇㅇ
		for(int i=0 ; i < map_size ; i++){
			for(int j=0 ; j < map_size ; j++){
				map[i][j] = sc.nextInt();
			}
		}
		
		dfs(0,0,0);
		
		System.out.println("최단거리: "+min);
	}
	
	public static void dfs(int x, int y, int length){
		
		//도착
		if(x == map_size-1 && y == map_size-1){
			System.out.println("도착!!!"+length);
			if(min > length) min = length;
			return;
		}
		
		map[x][y] = 0; //방문한 곳(현재위치)은 0 대입
		
		//왼쪽으로 이동할 경우
		if(x > 0 && map[x-1][y] == 1){
			System.out.print("좌-");
			dfs(x-1, y, length+1);
		}
		
		//오른쪽으로 이동할 경우
		if(x < map_size && map[x+1][y] == 1){
			System.out.print("우-");
			dfs(x+1, y, length+1);
		}
		
		//아래로 이동할 경우
		if(y < map_size && map[x][y+1] == 1){
			System.out.print("아래-");
			dfs(x, y+1, length+1);
		}
		
		//위로 이동할 경우
		if(y > 0 && map[x][y-1] == 1){
			System.out.print("위-");
			dfs(x, y-1, length+1);
		}
		
		System.out.println("막힘-");
		map[x][y] = 1 ; //지나간 자리를 원상태로 돌리기 위해서 1 대입
	}

}
