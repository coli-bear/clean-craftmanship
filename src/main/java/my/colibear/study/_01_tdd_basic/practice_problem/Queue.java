package my.colibear.study._01_tdd_basic.practice_problem;

import java.util.ArrayList;
import java.util.List;

public class Queue<T> {
    private int size = 0;
    private int capacity = 0;
    // 간단한 샘플예제로 만들거라  List 로 구현했다. 토달지 말자
    private transient List<T> elements;

    public Queue() {
        this(10);
    }

    public Queue(int capacity) {
        this.capacity = capacity;
        this.elements = new ArrayList<>(capacity);
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public void push(T element) {
        if (size >= this.capacity) {
            throw new Overflow();
        }
        this.elements.add(size++, element);
    }

    public T pop() {
        if (size <= 0) {
            throw new Underflow();
        }
        this.size--;
        return this.elements.remove(0);
    }

    public int size() {
        return this.size;
    }

    public static class Underflow extends RuntimeException {
    }

    public static class Overflow extends RuntimeException {
    }
}
