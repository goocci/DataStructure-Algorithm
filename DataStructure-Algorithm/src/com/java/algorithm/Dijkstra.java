package com.java.algorithm;

import java.util.Stack;

public class Dijkstra {
	
	static int inf = 99999; //무한대 값
	
	public static void main(String[] args){
		
		int[][] weightMatrix = {
			//  0    1    2    3    4    5    6
	/* 0 */ {   0,   7, inf, inf,   3,  10, inf},
	/* 1 */ {   7,   0,   4,  10,   2, inf, inf},
	/* 2 */ { inf,   4,   0,   2, inf,   6, inf},
	/* 3 */ { inf,  10,   2,   0,  11,   9,   4},
	/* 4 */ {   3,   2, inf,  11,   0, inf,   5},
	/* 5 */ {  10, inf,   6,   9, inf,   0, inf},
	/* 6 */ { inf, inf, inf,   4,   5, inf,   0}

		};
		
		dtra(weightMatrix, 0, 3); //0부터 3까지 최단거리
	}
	
	public static void dtra(int[][] graph, int start, int end){
		
		int vCount = graph[0].length; //정점의 수
		boolean[] isVisits = new boolean[vCount]; //방문 확인 배열
		int[] distance = new int[vCount]; //거리 배열(누적)
		int[] historyPath = new int[vCount]; //히스토리 배열
		
		int nextVertex = start; //distance배열에서 최소값을 가지는 정점
		int min = 0; //distance배열의 최소값
		
		//초기화
		for(int i = 0 ; i < vCount ; i++){
			isVisits[i] = false; //모두 아직 방문하지 않음
			distance[i] = inf; //전부 다 무한대
			historyPath[i] = inf; //전부 다 무한대
		}
		distance[start] = 0; //distance배열에서 시작점은 0으로 초기화
		
		//다익스트라 실행
		while(true){
			
			min = inf; //최소값을 무한대로 초기화
			
			/*인접 정점 중 최소거리의 정점을 찾는 반복문*/
			for(int i = 0 ; i < vCount ; i++){
				if(isVisits[i] == false && distance[i] < min){
					//가장먼저 방문했던 정점은 제외
					//최소값의 간선 찾기위한 조사(선택정렬)
					nextVertex = i; //다음으로 이동할 정점 선택
					min = distance[i]; //다음으로 이동한 최소값
				}
			}
			
			//distance배열 확인
			for (int i = 0; i < vCount; i++) {
	            System.out.print(distance[i]+" ");
	        }
			System.out.println();
			
			/*도착*/
			if(min == inf){
				break; //최소값이 무한대이면 모든 정점을 지난 것, 끝
			}
			
			/*방문할 정점 체크*/
			isVisits[nextVertex] = true;
			
			/*(방문한 정점의 누적 거리 + 그 위치에서 다른 정점들과의 거리) < (누적거리를 가지는 distance배열 요소들의 값) ---> 교체 */
			for(int i = 0 ; i < vCount ; i++){
				//정점에서 방문한 다른 정점과의 거리
				int distanceVertex = distance[nextVertex] + graph[nextVertex][i];
				
				if(distanceVertex < distance[i]){
					//정점에서 다른 정점까지의 거리가 distance배열보다 작으면 교체
					distance[i] = distanceVertex;
					historyPath[i] = nextVertex; //교체된다면 그 지점의 정점을 기록
				}
			}
		}
		System.out.println(start+" 에서 "+end+" 까지의 최단거리 : "+distance[end]);
        printPath(historyPath, start, end);

	}
	
	public static void printPath(int[] historyPath, int start, int end) { // 경로계산
        Stack<Integer> path = new Stack<Integer>();
        int vertex = end; // 거꾸로 탐색
        while (true) {
            path.push(vertex);
            if (vertex == start)
                break; // 시작점이면 리턴
            vertex = historyPath[vertex]; // 탐색
        }
 
        System.out.print(start + " 부터 " + end + " 까지의 경로 :");
        while (!path.isEmpty())
            // 출력
            System.out.print(" " + path.pop());
    }
}
