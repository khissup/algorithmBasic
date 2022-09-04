package day_08.day_0811.ex;
// 완전이진트리 순서에 맞게 채워나갈 예정

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CompleteBinaryTree {
    private char[] nodes;
    private int lastIndex; // 마지막 노드의 인덱스 <- 여기 0으로 자동 초기화된다고함..?
    private final int SIZE;

    public CompleteBinaryTree(int size) {
        SIZE = size;
        nodes = new char[size + 1]; // 1인덱스부터 사용. 그래야 *2 개념이 됨됨
   }

   public boolean add(char e) { // 완전 이진트리에 맞게 추가
        if(lastIndex == SIZE) {
            return false;
        }
        nodes[++lastIndex] = e;
        return true;
   }

   public void bfs() {
       Queue<Integer> queue = new LinkedList<>();
       queue.offer(1); // 루트노드 인덱스 부터

       while (!queue.isEmpty()) { // 방문대상이 있을때까지 반복
           int current = queue.poll(); // 방문차례인 대상 정보 꺼내기
           System.out.print(nodes[current] + " "); // 방문해서 해야할일 처리

           // 현재 방문노드의 자식들을 대기열에 넣기
           if(current * 2 <= lastIndex) queue.offer(current * 2); // 왼쪽자식
           if(current * 2 + 1 <= lastIndex) queue.offer(current * 2 + 1); // 오른쪽자식
       }
       System.out.println();
   }

    public void bfs2() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1); // 루트노드 인덱스 부터

        while (!queue.isEmpty()) { // 방문대상이 있을때까지 반복
            int size = queue.size(); // 큐 크기 확인 (동일 너비 대상인 개수만 뽑을려고 하는것임)

            while(--size >= 0) { // 반복 진입 전 구한 큐 크기 만큼만 반복
                int current = queue.poll(); // 방문차례인 대상 정보 꺼내기
                System.out.print(nodes[current] + " "); // 방문해서 해야할일 처리

                // 현재 방문노드의 자식들을 대기열에 넣기
                if(current * 2 <= lastIndex) queue.offer(current * 2); // 왼쪽자식
                if(current * 2 + 1 <= lastIndex) queue.offer(current * 2 + 1); // 오른쪽자식
            }
            System.out.println();
        }
        System.out.println();
    }

    public void dfs() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1); // 루트노드 인덱스 부터

        while (!stack.isEmpty()) { // 방문대상이 있을때까지 반복
            int current = stack.pop(); // 방문차례인 대상 정보 꺼내기
            System.out.print(nodes[current] + " "); // 방문해서 해야할일 처리

            // 현재 방문노드의 자식들을 대기열에 넣기
            if(current * 2 <= lastIndex) stack.push(current * 2); // 왼쪽자식
            if(current * 2 + 1 <= lastIndex) stack.push(current * 2 + 1); // 오른쪽자식
        }
        System.out.println();
    }

    public void dfsByPreOrder(int current) {
        System.out.print(nodes[current] + " "); // 방문해서 해야할일 처리
        if(current * 2 <= lastIndex) dfsByPreOrder(current * 2);
        if(current * 2 + 1 <= lastIndex) dfsByPreOrder(current * 2 + 1);
    }
    
    public void dfsByInOrder(int current) {
        if(current * 2 <= lastIndex) dfsByInOrder(current * 2);
        System.out.print(nodes[current] + " "); // 방문해서 해야할일 처리
        if(current * 2 + 1 <= lastIndex) dfsByInOrder(current * 2 + 1);
    }

    // 중위호출은 이진트리이기 때문에 가능함
    public void dfsByInOrder2(int current) {
        if(current > lastIndex) return;
        
        dfsByInOrder(current * 2);
        System.out.print(nodes[current] + " "); // 방문해서 해야할일 처리
        dfsByInOrder(current * 2 + 1);
    }
    
    public void dfsByPostOrder(int current) {
        if(current > lastIndex) return;

        dfsByPostOrder(current * 2);
        dfsByPostOrder(current * 2 + 1);
        System.out.print(nodes[current] + " "); // 방문해서 해야할일 처리
    }
    
}
