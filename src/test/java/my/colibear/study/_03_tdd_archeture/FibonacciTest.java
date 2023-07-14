package my.colibear.study._03_tdd_archeture;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class FibonacciTest {
    @Test
    public void testFibs() {
        assertThat(fib(0), equalTo(BigInteger.ONE));
        assertThat(fib(1), equalTo(BigInteger.ONE));
        assertThat(fib(2), equalTo(new BigInteger("2")));
        assertThat(fib(3), equalTo(new BigInteger("3")));
        assertThat(fib(40), equalTo(new BigInteger("165580141")));
    }

    // 1. ,{} -> Nil
    private BigInteger fib(int n) {
//        return null;
        // 2. Nil -> 상수
//        return new BigInteger("1");
        // 3. 무조건 - > 선택적
//        if (n > 1) return new BigInteger("2");
//        return new BigInteger("1");
        // 4. 명령문 -> 재귀
        // 시간과 메모리 측면에서 굉장히 비싸다.
//        if (n > 1) {
//            return fib(n - 1).add(fib(n - 2));
//        } else {
//            return new BigInteger("1");
//        }
        // 5. 4의 개선 : 선택적 -> 반복
//        return fib(BigInteger.ONE, BigInteger.ONE, n);

        BigInteger fm2 = BigInteger.ONE;
        BigInteger fm1 = BigInteger.ONE;
        while (n > 1) {
            BigInteger f = fm1.add(fm2);
            fm2 = fm1;
            fm1 = f;
            n --;
        }
        return fm1;
    }

//    private BigInteger fib(BigInteger fm1, BigInteger fm2, int n) {
//        if (n > 1)
//            return fib(fm1, fm1.add(fm2), n - 1);
//        else
//            return fm1;
//    }

    /*
    결국 하고 싶은 말은무엇이냐
    필자는 이 순서대로 변환을 선택하면 더 나은 구현이 만들어질 가능성이 높다는 것이다 (필자의 생각이자 가정일 뿐이다.)
    1. {} -> Nil
    2, Nil -> 상수
    3. 상수 -> 변수
    4. 무조건적 -> 선택적 (상수에서 if 같은 조건을 이용해 선택)
    5. 값 -> 리스트 (여러 값을 받을 수 있도록)
    6. 선택적 -> 반복 (if 문을 while 문 같은 반복문으로 변경)
    7. 명령문 -> 재귀 (단순한 커맨드 에서 재귀 호출을 이용한 반복)
    8. 값 -> 변경된 값

    솔찍히 다 기억 못하겠지만
    일단 TDD 어렵고 좋다. 더 좋은 객체 만들 수 있을 것 같다.
    알고리즘 구현도 많은 도움을 받을 수 있을 것 같다.
     */
}
