package my.colibear.study._01_tdd_basic;



import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 정수를 담는 스택에 대한 테스트
 * - 문제를 풀어가며 테스트를 통해 닥을 얻을 수 있으며, 테스트가 갖는 문서로서의 가치를 보여 주는 실례
 * <p>
 * 아래의 내용을 항상 이 책을 읽는동안 만드는 테스트 파일에 항상 적어보자 (복붙 해도 좋다. 읽어보자)
 * <p>
 * 테스트 주도 개발은 다음과 같은 일을 하기 위한 규율 이다.
 * <p>
 * 1. 테스트 묶음을 만든다.
 * - 리팩터링을 가능하게 하는 테스트 묶음이어야 한다.
 * - 통과 여부가 배포 여부를 결정할 정도로 테스트 묶음을 믿을 수 있어야 한다.
 * - 테스트 묶음을 모두 통과하면 시스템을 배포할 수 있다.
 * <p>
 * 2. 테스트와 리팩터링이 가능할 정도로 결합도가 낮은 제품 코드를 만든다.
 * <p>
 * 3. 주기가 극단적으로 짧은 피드백 고리를 만들어서 프로그램 작성 작업의 리듬과 생산성을 안정적으로 유지한다.
 * <p>
 * 4. 충분히 분리된 테스트와 제품 코드를 만든다.
 * - 두 군데 모두에서 변경을 반복하는 거추장스러운 일 없이 둘 다 편하게 관리가 가능하다.
 * <p>
 * =================================================================================
 * [테스트 주도 개발의 세 가지 법칙]
 * 1. 실패하는 테스트 없이 제품코드를 쓰지 말라.
 * - 테스트 코드 먼저 작성하면 제품 코드(구현부)가 없어 실패할 것이다.
 * <p>
 * 2. 테스트 또는 컴파일이 실패하는 데 필요한 만큼만 테스트 코드를 쓰라.
 * - 그 다음 제품 코드를 작성하여 테스트를 통과 시켜라
 * <p>
 * 3. 실패한 테스트를 고치는데 필요한 만큼만 제품 코드를 작성하라.
 * - 테스트가 끝나면 테스트를 추가해라
 * <p>
 * =================================================================================
 * <p>
 * 테스트 주도 개발을 하게 되면 문서화가 쉽다.
 * - TDD 는 전체 시스템을 위한 코드 예제를 사용하게 되며, 우리가 사용하는 테스트는 시스템이 어떻게 동작하는지
 * 세부사항을 사소한 것 까지 빠짐없이 설명한다.
 * <p>
 * 설계의 구멍을 방지할 수 있다.
 * - 테스트를 개발 이후에 작성한다면 재미가 없는 형식적인 테스트가 될 것이다.
 * - 테스트를 만들기 힘든 경우를 볼 수 있는데 이런 경우 테스트하기 좋게 코드를 설계하지 않았기 때문에 테스트를 만들기 힘들다.
 * - 그저 돌아가기만 할 뿐이다.
 * - 이 결과 테스트 묶음에 구멍을 남기게 되고 이는 배포에 대한 신뢰성 저하로 이어진다.
 * - 배포에 대한 확신을 갖기 위해서는 좋은 테스트를 만들어야 하며, 이는 테스트 묶음에 구멍이 없게 만들어야 한다는 것을 의미한다.
 * <p>
 * 테스트 주도 개발을하는 부가적인 이유들
 * - 작동하는 코드를 쓰는데 더 많은 시간을 사용하고, 디버깅하는데 적은 시간을 사용한다.
 * - 완벽에 가까운 저수준 문서 한 벌이 만들어 진다.
 * - 재미있으며, 동기 부여가 된다.
 * - 배포에 대한 확신을 주는 테스트 묶음을 만들게 된다.
 * - 결합도가 낮은 설계를 만든다.
 * <p>
 * =================================================================================
 * [보이 스카웃의 법칙]
 * 받았을 떄보다(check-out) 더 깨끗한 코드를 제출하라(check-in)
 * =================================================================================
 * <p>
 * TDD 의 진짜 이유
 * - Clean Code, Refactoring 이것이 진정한 TDD 의 이유이다.
 * <p>
 * <p>
 * =================================================================================
 * [TDD 의 네번째 법칙]
 * Refactoring 을 TDD 사이클의 4번째 속성으로 넣자
 */

// public class Stack 에 대한 테스트 코드
public class StackTest {

    private Stack stack = new Stack();

    @Test
    public void nothing() throws Exception {
        // 아무것도 하지 않는 테스트 - 실행 환경이 잘 동작하는지 확인 할 수 있음.
    }

    /**
     * 첫 번쨰 규칙 : 작성하고 싶은 코드를 작성하도록 만드는 테스트를 작성하자.
     * 두 번쨰 규칙 : 컴파일에 필요한 부분만 코드로 작성한다.
     * 세 번째 규칙 : 필요한 것 이상의 코드는 쓰지 않는다.
     * <p>
     * <Test 1> 스택을 생성한다.
     * <p>
     * ${@link Stack} 객체 생성 line 5 (2. MyStack 객체 생성)
     */
    @Test
    public void canCreateStack() throws Exception {
        // 1. MyStack 인스턴스를 생성하는 코드를 작성한다.
        // 3. Stack 으로 객체 명 변경 -> 테스트 이상 없이 동작하는것을 확인
        // 실패 -> 통과 -> 정리의 순으로 개발 진행
//        Stack stack = new Stack(); // refactoring 을 하자. 필드로 추출
        assertTrue(this.stack.isEmpty());
    }

    @Test
//    public void canPush() throws Exception { // canPush 또한 테스트 이름으로 적합하지 않아 아래와 같이 명확한 테스트 명으로 바꾼다.
    public void afterOnePush_isNotEmpty() throws Exception {
        // 4. 단정문으로 검증
        // 5. stack.isEmpty() 빨강
        // stack 에 값을 밀어 넣는 것;
        this.stack.push(0);
        assertFalse(this.stack.isEmpty());
        assertEquals(1, this.stack.size());
    }

    @Test
    public void afterOnePushAndOnePop_isEmpty() throws Exception {
        this.stack.push(0);
        this.stack.pop();
        assertTrue(this.stack.isEmpty());
        assertEquals(0, this.stack.size());
    }

    @Test
    public void afterTwoPush_sizeIsTwo() throws Exception {
        this.stack.push(0);
        this.stack.push(0);
        assertFalse(this.stack.isEmpty());
        assertEquals(2, this.stack.size());
    }

    // 빈 스택에서 pop 을 하면 스택에 데이터가 없어 Underflow exception 이 발생한다.
    @Test
    public void poppingEmptyStack_throwsUnderflow() {
        assertThrows(Stack.Underflow.class, () -> this.stack.pop());
    }

    @Test
    public void afterPushingX_willPopX() throws Exception {
        this.stack.push(99);
        assertEquals(99, this.stack.pop());
        this.stack.push(88);
        assertEquals(88, this.stack.pop());
    }

    @Test
    public void afterPushingXandY_willPopYthenX() throws Exception {
        this.stack.push(99);
        this.stack.push(88);
        assertEquals(88, this.stack.pop());
        assertEquals(99, this.stack.pop());
    }

}
