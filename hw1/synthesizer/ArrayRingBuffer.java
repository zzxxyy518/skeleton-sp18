package synthesizer;

public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    int first;
    int last;
    T[] values;
    public ArrayRingBuffer(int capacity){
        this.fillCount=0;
        first=0;
        last=0;
        this.capacity=capacity;
        values=(T[]) new Object[capacity];
    }

    @Override
    public T peek() {
        return values[first];
    }

    @Override
    public T dequeue() {
        T res=values[first];
        first=(first+1)%capacity;
        fillCount--;
        return res;
    }

    @Override
    public void enqueue(T x) {
        fillCount++;
        values[last]=x;
        last=(last+1)%capacity;
    }
}
