package com.java.datastructure;

/*
 * 단순 연결 리스트(simple linked list, singly linked list)는 가장 단순한 연결 리스트의 형태로 각 노드들은 다음 노드를 가리키는 하나의 참조만을 갖는다. 
다음 노드의 참조밖에 가지고 있지 않으므로 노드의 접근은 한 방향으로만 가능하다.

헤더는 처음 노드의 참조만 가지고 있으며 처음 노드는 두번째 노드, 두번째 노드는 세번째 노드를 가리키고 있으며 마지막 노드가 가리키는 참조값은 null이 된다.
즉, 헤더가 가리키는 노드가 처음 노드며 참조값이 null인 노드가 마지막 노드가 되는 것이다.
*/

public class LinkedList {
    
    private Node header;
    private int size;
    
    public LinkedList(){
        
        header = new Node(null);
        size = 0;
    }
    
    // 단순 연결 리스트 노드
    private class Node{
        
        private Object data;
        private Node nextNode;
        
        Node(Object data){
            
            this.data = data;
            this.nextNode = null;
        }
        
    }
    
    // index 위치의 노드 데이터를 반환한다.
    public Object get(int index){
        return getNode(index).data;
    }
    
    // index 위치의 노드를 반환한다.
    private Node getNode(int index){
        
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index : " + index + ", Size : " + size);
        }
        
        Node node = header.nextNode;
        for(int i =0; i < index; i++){
            node = node.nextNode;
        }
        
        return node;
    }
    
    // 첫번째 노드의 데이터를 반환한다.
    public Object getFirst(){
        return get(0);
    }
    
    // 해당 데이터의 노드 위치 index를 반환한다.
    public int getNodeIndex(Object obj){
        
        if(size<=0){
            return -1;
        }
        
        int index=0;
        Node node = header.nextNode;
        Object nodeData = node.data;
        
        // header에서 부터 순차적으로 nodeData와 값을 비교한다.
        while(!obj.equals(nodeData)){
            node = node.nextNode;
            
            if(node==null){
                return -1;
            }
            
            nodeData = node.data;
            index++;
        }
        
        return index;
    }
    
    // data를 리스트의 첫번째에 삽입한다.
    public void addFirst(Object data){
        
        Node newNode = new Node(data);
        newNode.nextNode = header.nextNode;
        header.nextNode = newNode;
        size++;
        
    }
    
    // index 위치에 data를 삽입한다.
    public void add(int index, Object data){
        
        if(index==0){
            addFirst(data);
            return;
        }
        
        Node previous = getNode(index-1);
        Node next = previous.nextNode;
        
        Node newNode = new Node(data);
        previous.nextNode = newNode;
        newNode.nextNode = next;
        size++;
    }
    
    // 리스트의 마지막에 data 를 삽입한다.
    public void addLast(Object data){
        add(size, data);
    }
    
    // 리스트의 마지막에 data를 삽입한다.
    public void add(Object data){
        addLast(data);
    }
    
    // 첫번째 노드를 제거하고 데이터를 반환한다.
    public Object removeFirst(){
        
        Node firstNode = getNode(0);
        header.nextNode = firstNode.nextNode;
        size--;
        return firstNode.data;
        
    }
    
    // index 위치의 노드를 제거하고 데이터를 반환한다.
    public Object remove(int index){
        
        if(index<0 || index>=size){
            
            throw new IndexOutOfBoundsException("Index : " + index + ", Size : " +size);
        
        }else if(index ==0){
            
            return removeFirst();
        
        }
        
        Node previous = getNode(index-1);
        Node removeNode = previous.nextNode;
        Node next = removeNode.nextNode;
        previous.nextNode = next;
        size--;
        
        return removeNode.data;
    }
    
    // 리스트에서 data를 가진 노드를 제거하고 제거여부를 반환한다.
    public boolean remove(Object data){
        
        int nodeIndex = getNodeIndex(data);
        
        if(nodeIndex == -1){
            return false;
        }else{
            remove(nodeIndex);
            return true;
        }
    }
    
    // 리스트의 마지막 노드를 제거하고 데이터를 반환한다.
    public Object removeLast(){
        return remove(size-1);
    }
    
    // 리스트의 크기를 반환한다.
    public int size(){
        return size;
    }
    
    // 리스트의 데이터 String으로 반환
    public String toString(){
        
        StringBuffer result = new StringBuffer("[");
        Node node = header.nextNode;
        
        if(node!=null){
            result.append(node.data);
            node = node.nextNode;
            
            while(node != null){
                result.append(", ");
                result.append(node.data);
                node = node.nextNode;
            }
        }
        
        result.append("]");
        return result.toString();
    }
    
    public static void main(String[] args){
    	LinkedList list = new LinkedList();
        
        list.add(100);
        list.add(200);
        list.add(400);
        list.add(500);
        System.out.println(list);
        
        list.add(2, 300);
        list.addFirst(50);
        System.out.println(list);
        
        System.out.println(list.get(4));
        
        list.remove(2);
        list.remove(new Integer(400));
        System.out.println(list);
        
        list.removeFirst();
        list.removeLast();
        System.out.println(list);
        
        System.out.println("크기 " + list.size());
    }

}
