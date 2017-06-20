package com.java.problem;

import java.util.*;

/**
 * Created by uujc0207 on 2017. 5. 19..
 */
public class 현관비밀번호 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] M_arr = new int[M];
        for(int i = 0 ; i < M ; i++){
            M_arr[i] = sc.nextInt();
        }

        perm(M_arr, 0, M, N);

        System.out.println("모든 경우의 수 :");
        System.out.println(password_list);

        password_list = checkEvenOdd(password_list);
        System.out.println("짝수/홀수 확인 :");
        System.out.println(password_list);

        for(int i = 0 ; i < password_list.size() ; i++){
            Collections.sort(password_list.get(i));
        }

        System.out.println("오름차순 정렬 :");
        System.out.println(password_list);

        // HashSet 데이터 형태로 생성되면서 중복 제거됨
        HashSet hs = new HashSet(password_list);

        // ArrayList 형태로 다시 생성
        ArrayList<ArrayList> new_password_list = new ArrayList<ArrayList>(hs);

        System.out.println("중복 제거 :");
        System.out.println(new_password_list);

        System.out.println("가능한 비밀번호 개수: " + new_password_list.size());
    }

    // N의 개의 숫자들로 구성된 모든 비밀번호
    public static void perm(int[] M_arr, int depth, int M, int N){
        // depth 는 현재 트리구조에서 어떤 깊이에서 교환작업을 하고있는지에 대한 변수
        // M은 총 배열안에 들어있는 숫자를 뜻하며 고정값
        // N는 몇개를 뽑아내서 순열을 만들것인지를 뜻하며 고정값

        if(depth == N){
            print(M_arr, N);
        }

        for(int i = depth ; i < M ; i++){ // !!!!! depth 는 M 까지 !!!!!
            swap(M_arr, i, depth);
            perm(M_arr, depth + 1, M, N);
            swap(M_arr, i, depth);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static ArrayList<ArrayList> password_list = new ArrayList<>();

    public static void print(int[] arr, int N) {
        ArrayList<Integer> password = new ArrayList<>();

        for (int i = 0 ; i < N ; i++) {
            password.add(arr[i]);
        }
        password_list.add(password);
    }

    public static ArrayList<ArrayList> checkEvenOdd(ArrayList<ArrayList> password_list){

        ArrayList<ArrayList> password_list0 = new ArrayList<>();

        for(int i = 0 ; i < password_list.size() ; i++){
            int flag_even = 0;
            int flag_odd = 0;
            for(int j = 0 ; j < password_list.get(i).size() ; j++){
                if(flag_even == 1 && flag_odd == 1){
                    password_list0.add(password_list.get(i));
                    break;
                }
                if(Integer.parseInt(password_list.get(i).get(j).toString()) == 0){ // 0 도 짝수
                    flag_even = 1;
                    continue;
                }
                if(Integer.parseInt(password_list.get(i).get(j).toString()) % 2 == 0){ // 짝수일 경우
                    flag_even = 1;
                } else if(Integer.parseInt(password_list.get(i).get(j).toString()) % 2 == 1){ // 홀수일 경우
                    flag_odd = 1;
                }
            }
        }

        return password_list0;
    }
}
