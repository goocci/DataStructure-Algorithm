package com.java.datastructure;

public class ArrayQueue {

	private int front; //가장 오래전에 입력된 데이터 //데이터 삭제는 front에서
    private int rear; //가장 최근에 입력된 데이터 //데이터 삽입은 rear에서
    private int queueSize;
    private char itemArray[];
 
    //생성자(큐 생성) : 초기 상태의 공백큐는 저장된 원소가 없으므로 front와 rear를 -1로 설정
    public ArrayQueue(int queueSize){
        front = -1;
        rear = -1;
        this.queueSize = queueSize;
        itemArray = new char[this.queueSize];
    }
 
    //큐가 비어있는지 확인
    public boolean isEmpty() {
        return (front==rear);
    }
    
    //큐가 가득 차있는지 확인
    public boolean isFull() {
        return (rear==queueSize-1);
    }
 
    //큐의 삽입 연산 : 큐의 rear에 원소를 삽입
    public void enQueue(char item) {
        if(isFull()){
            System.out.println("큐가 꽉 찼습니다.");
        }else{
            itemArray[++rear] = item;
        }
    }
 
    //큐의 삭제 및 반환 연산
    public char deQueue() {
        if(isEmpty()){
            System.out.println("큐가 비었습니다.");
            return 0;
        }else{
            return itemArray[++front];
        }
    }
 
    //큐 삭제
    public void delete() {
        if(isEmpty()){
            System.out.println("큐가 비었습니다.");
        }else{
            ++front;
        }
        
    }
 
    //현재 큐의 맨 앞의 값
    public char peek() {
        if(isEmpty()){
            System.out.println("큐가 비었습니다.");
            return 0;
        }else{
            return itemArray[front+1];
        }
    }
    
    //전체 큐 출력
    public void printQueue(){
        if(isEmpty()){
            System.out.println("큐가 비었습니다.");
        }else{
            for(int i=front+1; i<=rear; i++){
                System.out.print(itemArray[i] + " ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        int queueSize = 5;
        char deletedItem;
        ArrayQueue queue = new ArrayQueue(queueSize);
        
        queue.enQueue('A');
        queue.printQueue();
        
        queue.enQueue('B');
        queue.printQueue();
        
        queue.enQueue('C');
        queue.printQueue();
        
        queue.enQueue('D');
        queue.printQueue();
        
        deletedItem = queue.deQueue();
        if(deletedItem!=0){
            System.out.println("deleted Item : " + deletedItem);
        }
        
        deletedItem = queue.deQueue();
        if(deletedItem!=0){
            System.out.println("deleted Item : " + deletedItem);
        }
        
        queue.printQueue();
        
    }

}
