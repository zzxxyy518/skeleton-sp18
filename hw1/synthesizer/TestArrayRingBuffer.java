package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void testFillCount() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
        arb.enqueue(5);
        arb.enqueue(4);
        arb.enqueue(1);
        assertEquals(3,arb.fillCount);
    }

    @Test
    public void testCapacity(){
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
        assertEquals(10,arb.capacity);
    }

    @Test
    public void testPeek(){
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
        arb.enqueue(5);
        arb.enqueue(4);
        arb.enqueue(1);
        assertEquals(5, (int) arb.peek());
    }

    @Test
    public void testDequeue(){
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
        arb.enqueue(5);
        arb.enqueue(4);
        arb.enqueue(1);
        assertEquals(5,(int) arb.dequeue());
        assertEquals(2,arb.fillCount);
    }

    @Test
    public void testOther(){
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
        assertNull(arb.peek());
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
