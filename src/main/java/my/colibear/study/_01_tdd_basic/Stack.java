package my.colibear.study._01_tdd_basic;


// 2. MyStack 객체 생성
public class Stack {
    // 5. 코드로는 초록이지만 실체 테스트는 실패한다.
    //   - assertTrue 는 true 를 반환해야하지만 규칙 1 : 실패해야 한다 라는 이유로 false 를 반환했다.
    //   - 또한 가장 큰 이유는 우리 테스트가 실패해야 할 때 실패를 하는지 확인을 위해서 이다. 이제 true 로 변경해서 테스트를 성공시키자.

    // 이제 사용하지 않음
//    private boolean empty = true;
    private int size = 0;

    private int[] elements = new int[2];

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void push(int element) {
        this.elements[this.size++] = element;
    }

    public int pop() {
        if (size == 0) {
            throw new Underflow();
        }
        return this.elements[--this.size];
    }

    public int size() {
        return this.size;
    }

    public static class Underflow extends RuntimeException {
    }
}
