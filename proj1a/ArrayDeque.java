import java.lang.reflect.Array;

public class ArrayDeque<T> implements Deque<T>{
    private final static int FACTOR=4;
    private final static int INIT_SIZE=8;
    private T[] values;
    private int size;
    private int first;
    private int last;

    public ArrayDeque(){
        T[] values=(T[]) new Object[INIT_SIZE];
        size=0;
        first=0;
        last=1;
    }

    @Override
    public void addFirst(T item) {
        first--;
        if(first<0) first+=1+values.length;
        if(last==first){
            T[] tmp=(T[]) new Object[values.length*INIT_SIZE];
            for(int i=0;i<size;i++){

            }
        }
    }

    @Override
    public void addLast(T item) {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void printDeque() {

    }

    @Override
    public T removeFirst() {
        return null;
    }

    @Override
    public T removeLast() {
        return null;
    }

    @Override
    public T get(int index) {
        return null;
    }
}
