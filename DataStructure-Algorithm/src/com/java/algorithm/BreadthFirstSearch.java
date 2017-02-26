package com.java.algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BreadthFirstSearch {
	
	static int[][] ad; //인접행렬
	static boolean[] isVisits; //정점의 방문 확인
	static int vCount; //정점(vertex)의 수
	static int eCount; //간선(edge)의 수
	static Queue queue;
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		queue = new LinkedList<Integer>(); //방문하는 정점이 들어가고 나오는 큐
		System.out.println("정점의 수, 간선의 수를 입력해주세요.");
		vCount = sc.nextInt();
		eCount = sc.nextInt();
		ad = new int[vCount][eCount]; //인점행렬 크기 선언
		isVisits = new boolean[vCount]; //방문여부 확인 boolean배열 크기 선언
		
		for(int i = 0 ; i < eCount ; i++){
			System.out.println("간선을 입력해주세요.");
			int v1 = sc.nextInt(); //v1에서
			int v2 = sc.nextInt(); //v2의 간선
			
			ad[v1-1][v2-1] = 1; //간선은 인접행렬에서 1로 표시
		}
		
		bfs(1); //정점 1부터 시작
	}
	
	public static void bfs(int v){
		
		isVisits[v-1] = true; //처음 방문한 정점 표시
		queue.add(v); //처음 방문한 정점 Enqueue
		
		while(!queue.isEmpty()){ //큐에 정점이 모두 Dequeue되면 끝
			
			v = (int)queue.poll(); //방문할 곳 Dequeue
			
			//v(현재 정점)와 인접한 정점들 큐에 넣기!!!
			for(int i = 1 ; i <= vCount ; i++){
				if(ad[v-1][i-1] == 1 && !isVisits[i-1]){ //현재 방문한 정점에서 가까운 정점 찾기(이미 방문한 곳은 ㄴㄴ)
					System.out.println(v + "->" + i);
					isVisits[i-1] = true;
					queue.add(i); //인접한 정점 Enqueue
				}
			}
		}
	}

}
