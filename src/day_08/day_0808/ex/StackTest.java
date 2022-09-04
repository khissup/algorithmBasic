package day_08.day_0808.ex;
/*
## 단순 연결 리스트### 구현- 컬렉션 API를 쓰면 직접 구현하지 않아도 된다는 장점이 있지만,
필요에 따라 직접 구현하는 경우 컬렉션 API에 비해 향상된 성능을 기대할 수 있다.
- 그래프 문제 해결을 위해 연결 리스트를 구현하여 인접 리스트로 활용할 수 있다.- 링크가 한 개


중간부터 reference 된 경우 모든 노드를 탐색할 수 없음 - 이전 노드를 찾으려면 처음부터
**현재 노드를 가리키는 노드**를 발견할 때 까지 탐색해야 함 - **링크 필드가 Null인 경우 마지막 노드**


삽입 연산> 위치에 따라 알고리즘이 달라질 수 있다.> - 첫 번째 노드로 삽입 (공백 리스트든, 아니든 똑같음)
1. 새로 노드 만들기 2. 데이터 필드 작성 3. 리스트의 처음으로 지정하도록 링크


1. head가 가지고 있는 링크를 새로 생성한 노드의 링크 필드에 복사
2. head의 링크 필드에 새로 생성한 노드를 할당 > 코드를 보면 사실 생성자 한 줄에 끝나버린다… >


마지막 노드로 삽입 1. 새로 노드 만들기 2. 데이터 필드 작성
3. 기존의 마지막 노드가 새로 생성한 노드를 지정하도록 링크
1. 링크 필드가 null인 노드를 탐색 2. 찾은 노드의 링크 필드에 새로 생성한 노드를 할당 >


마지막 노드를 찾는 작업이 많은 경우 마지막 노드를 링크하고 있는 tail을 두는 것이 좋은 방법이 될 수 있음 >


가운데 노드로 삽입 1. 새로 노드 만들기 2. 데이터 필드 작성
3. 들어가려는 자리의 선행 노드가 새로 생성한 노드를 지정하도록 링크

1. 새로 생성한 노드의 링크 필드에 선행 노드의 링크 필드를 복사 2. 선행 노드의 링크 필드에 새로 생성한 노드를 할당


삭제 연산- 첫 번째 노드 삭제 1. 삭제할 노드의 링크 필드를 head에 복사
2. 삭제할 노드의 링크 필드에 null 저장> 삽입이든 삭제든 논리적 순서를 유지하기만 하면 됨.
차례대로 계속 덧붙이는 형태의 삽입만 일어나고, 차례대로 지워나가는 형태의 삭제만 일어난다면?


첫 노드로 삽입, 첫 노드로 삭제하는 알고리즘이 제일 쉽고 편할 것. > - 나머지는 한 번 생각해보자


단순 연결 리스트의 활용- 스택 - 인접리스트 구현에서 활용할 수 있음
 */
public class StackTest {
    public static void main(String[] args) {
        IStack<String> stack = new StackPractice<>();
        System.out.println(stack.isEmpty() + "/" + stack.size());

        stack.push("데이터1");
        stack.push("데이터22");
        stack.push("데이터333");

        System.out.println("peek item : " + stack.peek());
        System.out.println(stack.isEmpty() + "/" + stack.size());
        System.out.println("pop item : " + stack.pop());
        System.out.println("pop item : " + stack.pop());
        System.out.println(stack.isEmpty() + "/" + stack.size());
        System.out.println("pop item : " + stack.pop());
        System.out.println(stack.isEmpty() + "/" + stack.size());
        stack.pop();
    }
}
