import static org.junit.jupiter.api.Assertions.*;

class PriorityQueueTest {
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    @org.junit.jupiter.api.Test
    void add() {
        pq.add(1);
        pq.add(2);
        pq.add(3);
        pq.add(4);
    }

    @org.junit.jupiter.api.Test
    void contains() {
        pq.add(1);
        pq.add(2);
        pq.add(3);
        pq.add(4);
        assertTrue(pq.contains(3));
    }

    @org.junit.jupiter.api.Test
    void peek() {
        pq.add(1);
        pq.add(2);
        pq.add(3);
        pq.add(4);
        assertEquals(pq.peek(), 1);
    }

    @org.junit.jupiter.api.Test
    void poll() {
        pq.add(1);
        pq.add(2);
        pq.add(3);
        pq.add(4);
        assertEquals(pq.poll(), 1);
        pq.add(0);
        assertEquals(pq.poll(), 0);
    }

    @org.junit.jupiter.api.Test
    void remove() {
        pq.add(1);
        pq.add(2);
        pq.add(3);
        pq.add(4);
        assertEquals(pq.remove(2), true);
    }

    @org.junit.jupiter.api.Test
    void size() {
        pq.add(1);
        pq.add(2);
        pq.add(3);
        pq.add(4);
        assertEquals(pq.size(), 4);
    }
}