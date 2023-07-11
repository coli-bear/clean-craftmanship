package my.colibear.study._01_tdd_basic.practice_problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {

    private final Queue<Integer> queue = new Queue<>();

    @Test
    public void nothing() throws Exception {

    }

    @Test
    public void createQueue_isEmpty() throws Exception {
        assertTrue(this.queue.isEmpty());
    }

    @Test
    public void createQueue_capacity10_isEmpty() throws Exception {
        Queue<Integer> queueCapacity = new Queue<>(10);
        assertTrue(queueCapacity.isEmpty());
    }

    @Test
    public void afterPush_isNotEmpty() throws Exception {
        this.queue.push(0);
        assertFalse((this.queue.isEmpty()));
    }

    @Test
    public void afterPushAndPop_isEmpty() throws Exception {
        this.queue.push(0);
        Integer pop = this.queue.pop();
        assertTrue(this.queue.isEmpty());
        assertEquals(0, pop);
    }

    @Test
    public void afterPushing_size1() throws Exception {
        this.queue.push(0);
        assertEquals(1, this.queue.size());
    }

    @Test
    public void afterPushingXAndPoppingX_isEmpty() throws Exception {
        this.queue.push(123);
        assertEquals(123, this.queue.pop());
        this.queue.push(3);
        assertEquals(3, this.queue.pop());
    }

    @Test
    public void afterPushingXAndY_willPopXThenY() throws Exception {
        this.queue.push(123);
        this.queue.push(456);
        assertFalse(this.queue.isEmpty());
        assertEquals(123, this.queue.pop());
        assertEquals(456, this.queue.pop());

        assertTrue(this.queue.isEmpty());
        assertEquals(0, this.queue.size());
    }

    @Test
    public void afterPopping_Underflow() {
        assertThrows(Queue.Underflow.class, this.queue::pop);
    }

    @Test
    public void afterPushing_Overflow() {
        final Queue<Integer> overflowQueue = new Queue<>(1);
        overflowQueue.push(1);
        assertThrows(Queue.Overflow.class, () -> overflowQueue.push(1));
    }

}
