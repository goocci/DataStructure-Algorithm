package com.java.datastructure;

public class ArrayStack {
    
    private int top; // 스택의 가장 위의 데이터 인덱스
    private int maxSize;
    private Object[] stackArray;
    
    // 생성자 : 배열 스택 생성, 스택의 최대 크기로 생성
    public ArrayStack(int maxSize){
        
        this.maxSize = maxSize;
        this.stackArray = new Object[maxSize];
        this.top = -1;
    }
    
    // 스택이 비어있는지 체크
    public boolean empty(){
        return (top == -1);
    }
    
    // 스택이 꽉찼는지 체크
    public boolean full(){
        return (top == maxSize-1);
    }
    
    // 스택에 item 입력
    public void push(Object item){
        
        if(full()) throw new ArrayIndexOutOfBoundsException((top+1)+">=" + maxSize);
        
        stackArray[++top] = item;
    }
    
    // 스택의 가장 위의 데이터 반환
    public Object peek(){
        
        if(empty()) throw new ArrayIndexOutOfBoundsException(top);
        
        return stackArray[top];
    }
    
    // 스택의 가장 위의 데이터 제거
    public Object pop(){
        
        Object item = peek();
        
        top--;
        
        return item; // 제거된 데이터를 반환
    }
    
    public static void main(String[] args){
    	// 크기 5의 배열 스택 생성
        ArrayStack arrayStack = new ArrayStack(5);
        
        System.out.println("Array Stack 테스트");
        
        // 스택에 데이터 삽입
        for(int i=1; i<=5; i++){
            arrayStack.push("ArrayStack 데이터-" + i);
        }
        
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.peek());
        System.out.println(arrayStack.peek());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
    }

}
