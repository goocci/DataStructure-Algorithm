package com.java.algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class BFSExample {
 
    static int[][] graph = new int[100][100]; //최대 크기 100
    static boolean[][] visited = new boolean[100][100];
    static int n = 0; //행 길이
    static int m = 0; //열 길이
    static int len[] = { 0, 0, 1, -1 }; // 하 상(이동 상황)
    static int wid[] = { 1, -1, 0, 0 }; // 우 좌(이동 상황)
 
    public static void main(String[] args) {
    	
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = input.nextInt();
        
        //맵 입력
        String nString = "";
        for (int i = 0; i < n; i++) {
            nString = input.next();
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(nString.charAt(j) + "");
            }
        }
        
        //방문맵 초기화
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                visited[i][j] = false;
            }
        }
 
        find();
    }
 
    private static void find() {
 
        int roadCount = 0;
        int qSize;
        int temp; //행*100 + 열
        int r; //행 좌표
        int c; //열 좌표
        int finish = 0;
 
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(0);
 
        while (finish != 1) {
            qSize = q.size(); //갈림길 갯수
            
            //큐의 데이터를 기준으로 길이 갈라지고~ 
            for (int i = 0; i < qSize; i++) {
                temp = q.poll();
                
                r = temp / 100;
                c = temp % 100;
                
                //목적지 도착
                if (r == n - 1 && c == m - 1) {
                    roadCount++;
                    System.out.println(roadCount);
                    finish = 1;
                }
 
                for (int j = 0; j < 4; j++) {
                	//상하좌우(4번) 이동 상황
                    int nr = r + wid[j];
                    int nc = c + len[j];
                    
                    //맵을 벗어나는 경우
                    if (nr >= n || nr < 0 || nc >= m || nc < 0)
                        continue;
                    
                    //막힌 곳일 경우
                    if (graph[nr][nc] == 0)
                        continue;
 
                    //방문한 곳일 경우
                    if (visited[nr][nc])
                        continue;
                    
                    //길을 찾음
                    visited[nr][nc] = true; //방문 표시
                    q.offer(nr * 100 + nc); //Enqueue
                }
            }
            //모든 갈림길에서의 다음 길을 찾은 후에(모든 갈림길에서 동등하게 증가한다고 생각)
            roadCount++; //이동거리증가
        }
    }
}
