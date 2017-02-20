package com.java.algorithm;

import java.util.Scanner;

public class DepthFirstSearch {
	
	static int vertex; //정점(vertex)의 개수
	static int startVertex; //시작 정점
	static int[][] vertexMap; //인접행렬 생성
	static int[] vertexVisit; //정점의 방문 여부를 가리키는 배열
	static int vt1, vt2;
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		vertex = sc.nextInt(); //정점의 개수 입력
		startVertex = Integer.parseInt(sc.nextLine().trim()); // 시작할 정점 입력
		vertexMap = new int[vertex+1][vertex+1]; //정점의 시작은 0이 아닌 1로 시작하기위해 +1
		vertexVisit = new int[vertex+1];
		
		while(true){
			vt1 = sc.nextInt(); //정점의 연결 입력
			vt2 = sc.nextInt();
			
			if(vt1 == 0) break;
			
			vertexMap[vt1][vt2] = vertexMap[vt2][vt1] = 1; // 정점 vt1과 vt2 연결되었음을 표기
		}
		
		dfs(startVertex); //깊이우선탐색 시작
		
	}
	
	public static void dfs(int start){
		vertexVisit[start] = 1; //방문한 정점은 1로~
		
		for(int i = 1; i <= vertex; i++){
			if(vertexMap[start][i] == 1 && vertexVisit[i] == 0){ //현재 정점과 i번 정점은 연결되어 있어야 && i번 정점은 방문안한곳 이어야 한다.
				System.out.println(start + "->" + i + " 이동"); //i번의 정점으로 이동 출력
				dfs(i); //i번 정점을 방문한 정점으로 체크하고 i번 정점에서 다시 길을 찾기위해 재귀함수호출
			}
			//막다른 곳이면  이전의 재귀함수의 나머지 for문으로 돌아간다!!!!!
		}
	}

}
