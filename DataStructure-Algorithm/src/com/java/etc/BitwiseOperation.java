package com.java.etc;

public class BitwiseOperation {
	
	public static void main(String[] args) {

    	int a = 60; // 0011 1100
    	int b = 13; // 0000 1101
    	int c = 0;
    	
    	// 비트 AND 연산자(&) : 양쪽 비트가 모두 1일 때만 결과가 1, 그렇지 않으면 0
    	c = a & b; // 0000 1100
    	System.out.println("AND : " + c);
    	
    	// 비트 OR 연산자(|) : 양쪽 비트 중 어느 하나라도 1이면 결과가 1, 모두 0일 때만 0,
    	c = a | b; // 0011 1101
    	System.out.println("OR : " + c);
    	
    	// 비트 XOR 연산자(^) : 양쪽 비트가 서로 다를 때만 1, 같을 때는 0
    	c = a ^ b; // 0011 0001
    	System.out.println("XOR : " + c);
    	
    	// 비트 NOT 연산자(~) : 양쪽 비트 연산자와는 다르게 피 연산자를 하나만 갖는 단항 연산자,
    	//                   모든 비트값을 반대로 만든다
    	c = ~a; // 1100 0011
    	System.out.println("NOT : " + c);
    	
    	// 좌측 쉬프트 연산자 (<<) : 왼편에 있는 피연산자의 비트 값을 연산자 오른편에 지정한 수 만큼 왼쪽으로 이동
    	//						오른쪽에 남는 비트는 0으로 채움, 부호를 고수
    	c = a << 2; // 1111 0000
    	System.out.println("Left : " + c);
    	
    	// 우측 쉬프츠 연산자 (>>) : 왼편에 있는 피연산자의 비트 값을 오른편에 지정한 수 만큼 오른쪽으로 이동
    	//						비어있는 왼쪽 비트는 부호와 같은 값으로 채움, 부호를 고수
    	c = a >> 2; // 0000 1111
    	System.out.println("RIGht : " + c);
    }

}
