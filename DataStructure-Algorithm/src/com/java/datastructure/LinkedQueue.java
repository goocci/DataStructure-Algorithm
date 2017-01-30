package com.java.datastructure;

public class LinkedQueue {
//	- 순차 자료구조 방식은 사용 크기가 제한되어 있어 큐를 마음대로 변경할 수 없고, 
//	    원소가 없을 때도 크기를 유지하므로 메모리가 낭비된다. 
//	    이와 같은 문제를 해결하기 위해 연결 자료구조 방식을 이용하여 크기에 제한이 없도록 한다.
	
//	- 첫번째 노드를 가리키는 참조변수 front 와 마지막 노드를 가리키는 참조변수 rear 를 사용한다.
//	- 초기 상태(공백 큐)는 front와 rear를 널(NULL)로 설정하여 표현한다.
	
	private QueueNode front;
    private QueueNode rear;
    
    public LinkedQueue() {
        front = null;
        rear = null;
    }    
    
    public boolean isEmpty() {
        return (front==null);
    }
 
    public void enQueue(char item) {
        QueueNode node = new QueueNode(item);
        System.out.println(node);
        if(isEmpty()){
            front = node;
            rear = node;
        }else{
            rear.next = node;
            rear = node;
        }
    }
 
    public char deQueue() {
        if(isEmpty()){
            System.out.println("큐의 내용이 존재하지 않습니다.");
            return 0;
        }else{
            char item = front.item;
            front = front.next;
            if(front==null){
                rear=null;
            }
            return item;
        }
    }
 
    public void delete() {
        if(isEmpty()){
            System.out.println("큐의 내용이 존재하지 않습니다.");
        }else{
            front = front.next;
            if(front==null){
                rear=null;
            }
        }
        
    }
 
    public char peek() {
        if(isEmpty()){
            System.out.println("큐의 내용이 존재하지 않습니다.");
            return 0;
        }else{
            return front.item;
        }
    }
 
    public void print() {
        if(isEmpty()){
            System.out.println("큐의 내용이 존재하지 않습니다.");
        }else{
            QueueNode node = front;
            while(node!=null){
                System.out.print(node.item + " ");
                node = node.next;
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        char deletedItem;
        LinkedQueue queue = new LinkedQueue();
        
        queue.enQueue('A');
        queue.print();
        
        queue.enQueue('B');
        queue.print();
        
        deletedItem = queue.deQueue();
        if(deletedItem!=0){
            System.out.println("deletedItem : " + deletedItem);
        }
        queue.print();
        
        queue.enQueue('C');
        queue.print();
        
        deletedItem = queue.deQueue();
        if(deletedItem!=0){
            System.out.println("deletedItem : " + deletedItem);
        }
        queue.print();
        
        deletedItem = queue.deQueue();
        if(deletedItem!=0){
            System.out.println("deletedItem : " + deletedItem);
        }
        queue.print();
        
        deletedItem = queue.deQueue();
        if(deletedItem!=0){
            System.out.println("deletedItem : " + deletedItem);
        }
        queue.print();
    }
	
}

class QueueNode {
    char item;
    QueueNode next;
    
    public QueueNode() {
        this.next = null;
    }
    
    public QueueNode(char item){
        this.item = item;
        next = null;
    }
    
    public char getItem(){
        return this.item;
    }
}
