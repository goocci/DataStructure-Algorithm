package com.java.datastructure;

/**
 * [PriorityQueue Example]
 * http://asuraiv.blogspot.kr/2015/11/java-priorityqueue.html
 */

import java.util.PriorityQueue;

/**
 * 일반적으로 Queue라는 자료구조는 '선입선출'(First-In, First-Out)의 대기열 규칙(queuing discipline)을 가지고 있다. 말그대로 먼저들어온 놈이 먼저 나간다는 것이다.
 * 하지만 JAVA에서 제공하는 'PriorityQueue'는 우선순위를 결정하여 들어온 순서와 상관없이 그 우선순위가 높은 엘리먼트가 나가게 된다. 이제부터 간단한 예제를 통해 알아보겠다.
 */

public class PriorityQueueEx {

    public static void main(String[] args) {

        PriorityQueue<Prisoner> priorityQueue = getPriorityQueue();

        System.out.println("=============== Normal Order");

        while (!priorityQueue.isEmpty()) {
            Prisoner prisoner = priorityQueue.poll();
            System.out.println(prisoner.name);
        }
    }

    private static PriorityQueue<Prisoner> getPriorityQueue() {

        Prisoner prisoner1 = new Prisoner("james", 5);
        Prisoner prisoner2 = new Prisoner("smith", 99);
        Prisoner prisoner3 = new Prisoner("alex", 14);
        Prisoner prisoner4 = new Prisoner("silvia", 10);
        Prisoner prisoner5 = new Prisoner("thomson", 1);

        PriorityQueue<Prisoner> priorityQueue = new PriorityQueue<Prisoner>();

        // 우선순위 큐의 'offer'는 큐 한쪽 끝에 엘리먼트를 저장하는데, 이때 '다형성'을 이용하여 추가 되는 엘리먼트 객체를 'Comparable' 인터페이스로 'Up Casting' 한다.
        priorityQueue.offer(prisoner1);
        priorityQueue.offer(prisoner2);
        priorityQueue.offer(prisoner3);
        priorityQueue.offer(prisoner4);
        priorityQueue.offer(prisoner5);

        return priorityQueue;
    }

}

// 이 클래스는 'name' 와 'weight(형량)' 의 2가지 필드가 있다. 이 Prisoner 클래스를 PriorityQueue에 넣고, 형량에 따라 큐에서 나오게(출소하게) 하려고 한다.
// 물론 일반적으로, 형량이 낮으면 먼저 출소하는 것이 인지상정. 이제 이 Prisoner 클래스에 Comparable 인터페이스를 구현 해보자.
class Prisoner implements Comparable<Prisoner>{

    String name;
    int weight; // 형량

    public Prisoner(String name, int weight){
        super();
        this.name = name;
        this.weight = weight;

    }

    @Override
    public int compareTo(Prisoner target){
        if(this.weight > target.weight){
            return 1;
        } else if(this.weight < target.weight){
            return -1;
        }
        return 0;
    }
}