public class LinkedListDeque<T> implements Deque<T>{
    int size;
    private Node<T> first;
    private Node<T> last;
    public LinkedListDeque(){
        size=0;
        first=new Node<>(null);
        last=new Node<>(null);
        first.next=last;
        first.prev=last;
        last.prev=first;
        last.next=first;
    }

    public LinkedListDeque(LinkedListDeque other){
        size=0;
        first=new Node<>(null);
        last=new Node<>(null);
        first.next=last;
        first.prev=last;
        last.prev=first;
        last.next=first;
        for(int i=0;i<other.size;i++){
            this.addLast((T) other.get(i));
        }
    }
    @Override
    public void addFirst(T item) {
        Node<T> mid= new Node<>(item);
        mid.prev=first;
        mid.next=first.next;
        first.next.prev=mid;
        first.next=mid;
        size++;
    }

    @Override
    public void addLast(T item) {
        Node<T> mid=new Node<>(item);
        mid.next=last;
        mid.prev=last.prev;
        last.prev.next=mid;
        last.prev=mid;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        Node sentinel=first;
        for(int i=0;i<size-1;i++){
            System.out.print(sentinel.next.item+" ");
            sentinel=sentinel.next;
        }
        System.out.print(sentinel.next.item);
        System.out.println();
    }

    @Override
    public T removeFirst() {
        size--;
        T result= (T) first.next.item;
        first.next.next.prev=first;
        first.next=first.next.next;
        return result;
    }

    @Override
    public T removeLast() {
        size--;
        T result= (T) last.prev.item;
        last.prev.prev.next=last;
        last.prev=last.prev.prev;
        return result;
    }

    @Override
    public T get(int index) {
        if(index>size-1||index<0){
            return null;
        }
        Node sentinel=first;
        for(int i=0;i<=index;i++){
            sentinel=sentinel.next;
        }
        return (T) sentinel.item;
    }
}
