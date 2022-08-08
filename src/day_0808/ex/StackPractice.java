package day_0808.ex;

public class StackPractice<E> implements IStack<E> {
    // 원래 스택은 단순연결리스트로 만들지는 않지만
    // 단순연결리스트 + 스택 연습차원에서 하는것임

    private Node<E> top; // 더미노드 아님!
    // size변수 두고 push, pop할때 관리하면되지만, 스택순회하는거 보기위해 일부러 안뒀음
    @Override
    public void push(E data) { // 첫 노드 삽입 알고리즘
        top = new Node<E>(data, top);
    }

    @Override
    public E pop() {
        if(isEmpty()) {
            System.out.println("공백스택이어서 작업이 불가능합니다");
            return null;
        }
        Node<E> popNode = top;
        top = popNode.link;
        popNode.link = null;
        return popNode.data;
    }

    @Override
    public E peek() {
        if(isEmpty()) {
            System.out.println("공백스택이어서 작업이 불가능합니다");
            return null;
        }
        return top.data;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public int size() {
        int cnt = 0;
        for (Node<E> temp = top; temp!= null; temp = temp.link) {
            cnt++;
        }
        return cnt;
    }
}
