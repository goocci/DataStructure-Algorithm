package com.java.problem;
import java.util.Scanner;

public class 그릇 {
	
    public static void main(String[] args) {

    	Scanner sc = new Scanner(System.in);
    	int total = 0;
    	String[] plate = new String[50];
    	
    	String nString = "";
		
    	
    	nString = sc.nextLine();
    	if(nString.length() < 3 || nString.length() > 50){
    		System.out.println("문자열의 길이는 3이상 50이하 입니다. 다시 입력해주세요.");
    		nString = sc.nextLine();
    	}
		for(int i = 0 ; i < nString.length() ; i++){
			plate[i] = nString.charAt(i)+"";
		}
    	
    	total += 10;
    	
    	for(int i = 1 ; i < nString.length() ; i++){
    		
    		if(plate[i-1].equals("(") && plate[i].equals("(")){
    			total += 5;
    		}
    		if(plate[i-1].equals("(") && plate[i].equals(")")){
    			total += 10;
    		}
    		if(plate[i-1].equals(")") && plate[i].equals("(")){
    			total += 10;
    		}
    		if(plate[i-1].equals(")") && plate[i].equals(")")){
    			total += 5;
    		}
    		if(plate[i] == ""){
    			break;
    		}
    	}
    	System.out.println(total);
    	
    }
}
