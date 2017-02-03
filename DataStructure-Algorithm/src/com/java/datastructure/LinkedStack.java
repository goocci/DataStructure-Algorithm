package com.java.datastructure;

public class LinkedStack {
    
    private Node top;
    
    // 노드 class 단순연결리스트와 같다.
    private class Node{
        
        private Object data;
        private Node nextNode;
        
        Node(Object data){
            this.data = data;
            this.nextNode = null;
        }
    }
    
    // 생성자, stack이 비어있으므로 top은 null이다.
    public LinkedStack(){
        this.top = null;
    }
    
    // 스택이 비어있는지 확인
    public boolean empty(){
        return (top == null);
    }
    
    // item을 스택의 top에 넣는다.
    public void push(Object item){
        
        Node newNode = new Node(item);
        newNode.nextNode = top;
        top = newNode;
        
    }
    
    // top 노드의 데이터를 반환한다.
    public Object peek(){
        if(empty()) throw new ArrayIndexOutOfBoundsException();
        return top.data;
    }
    
    // top 노드를 스택에서 제거한다.
    public Object pop(){
        
        Object item = peek();
        top = top.nextNode;
        return item;
    }
    
    public static void main(String[] args){
    	// 연결리스트 스택 생성
        LinkedStack listStack = new LinkedStack();
        
        System.out.println("List Stack 테스트");
        
        // 스택에 데이터 삽입
        for(int i=1; i<=5; i++){
            listStack.push("ListStack 데이터-"+i);
        }
        
        listStack.push("ListStack 데이터-6");
        
        System.out.println(listStack.pop());
        System.out.println(listStack.pop());
        System.out.println(listStack.peek());
        System.out.println(listStack.peek());    
        System.out.println(listStack.pop());
        System.out.println(listStack.pop());
        System.out.println(listStack.pop());
        System.out.println(listStack.pop());
    }

}
