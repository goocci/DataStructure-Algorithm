package com.java.datastructure;

public class CircularQueue {

	private int front;
    private int rear;
    private int queueSize;
    private char ItemArray[];
    
//    - 원형 큐에서는 초기 공백 상태일 때 front와 rear 값이 0이되고, 
//    - 공백 상태와 포화 상태를 쉽게 구분하기 위해서 자리 하나를 항상 비워둔다.
//    - 원형큐는 논리적으로 배열의 처음과 끝이 연결되어 있는 것으로 간주하는 것이다.
 
    public CircularQueue(int queueSize) {
        this.front = 0;
        this.rear = 0;
        this.queueSize = queueSize;
        ItemArray = new char[queueSize];
    }
 
    //큐가 비어있는지 확인
    public boolean isEmpty() {
        return (front==rear);
    }
 
    //큐가 가득차 있는지 확인
    public boolean isFull() {
        return ((rear+1)%this.queueSize==front);
    }
 
    //큐의 삽입 연산
    public void enQueue(char item) {
        if(isFull()){
            System.out.println("큐가 포화 상태");
        }else{
            rear = (rear+1)%(queueSize);
            ItemArray[rear] = item; 
        }
    }
 
    //큐의 삭제 후 반환 연산
    public char deQueue() {
        if(isEmpty()){
            System.out.println("큐가 공백 상태");
            return 0;
        }else{
            front = (front+1)%queueSize;
            return ItemArray[front];
        }
    }
 
    //큐의 삭제 연산
    public void delete() {
        if(isEmpty()){
            System.out.println("삭제할 큐가 없음");
        }else{
            front = (front+1)%queueSize;
        }
    }
 
    //큐의 현재 front값 출력
    public char peek() {
        if(isEmpty()){
            System.out.println("큐가 비어있음");
            return 0;
        }else{
            return ItemArray[(front+1)%queueSize];
        }
    }
 
    //전체 큐값 출력
    public void print(){
        if(isEmpty()){
            System.out.println("큐가 비어있음");
        }else{
            int f = front;
            
            while(f!=rear){
                f = (f+1)%queueSize;
                System.out.print(ItemArray[f] + " ");
            }
            System.out.println();
        }
    }

}
