package com.java.algorithm;

import java.util.Arrays;

/*
 * 힙(HeapTree:부모노드가 자식노드보다 항상 크다, 따라서 root노드가 max)이라는 자료구조를 이용하여 정렬하는 방법
힙은 삭제 연산을 수행하면 '가장 최상위 루트원소(root노드)'를 반환한다.
최상위 루트원소는 힙 내부에서 가장 큰 원소이다.
*/

public class HeapSort {
	
	public static void main(String[] args) {
        int[] test = { 3, 6, 9, 2, 7, 5, 4, 10, 8, 1 };
        HeapSort.heapSort(test);
        System.out.println(Arrays.toString(test));
    }
	
	public static void heapSort(int[] arr) {
        Heap heap = new Heap();
 
        for (int i = 0; i < arr.length; i++) {
            heap.insertHeap(arr[i]);
        }
 
        for (int i = arr.length - 1; i >= 0; --i) {
            arr[i] = heap.deleteHeap();
 
        }
    }

}

class Heap{
	
	private int heapSize;
    private int itemHeap[]; // 힙트리
 
    public Heap() {
        heapSize = 0;
        itemHeap = new int[50];
    }

    public void insertHeap(int item) {
        int i = ++heapSize;
        // item : 힙트리 생성을 위해 주어지는 배열의 요소값들
        while ((i != 1) && (item > itemHeap[i / 2])) {
            itemHeap[i] = itemHeap[i / 2];
            i /= 2;
        }
 
        itemHeap[i] = item;
    }
 
    public int getHeapSize() {
        return this.heapSize;
    }
    
    public int deleteHeap() {
    	// max 값인 root노드를 제거해서 반환하고 그 제거된 root노드의 자식 노드 중 큰 값을 root 자리로 ~
    	// root노드로 올라간 자식노드의 자리에는 또 그 자식노드의 자식노드 중 큰 값을 그 자리로...
        int parent, child;
        int item, tmp;
        item = itemHeap[1];
        tmp = itemHeap[heapSize--];
        parent = 1;
        child = 2;
 
        while (child <= heapSize) {
            if ((child < heapSize) && (itemHeap[child] < itemHeap[child + 1]))
                child++;
 
            if (tmp >= itemHeap[child])
                break;
 
            itemHeap[parent] = itemHeap[child];
            parent = child;
            child *= 2;
        }
 
        itemHeap[parent] = tmp;
        return item;
    }

}
