public class Node <T>{
    Node next;
    Node prev;
    T item;
    public Node(T item){
        this.item=item;
        next=null;
        prev=null;
    }
}
