import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Random;

public class TestArrayDequeGold {
    private final static Random RG=new Random();
    private static StudentArrayDeque<Integer> actual=new StudentArrayDeque<>();
    private static ArrayDequeSolution<Integer> expected=new ArrayDequeSolution<>();

    static {
        for(int i=0;i<10;i++){
            double numberBetweenZeroAndOne = StdRandom.uniform();
            if(numberBetweenZeroAndOne<0.5){
                actual.addFirst(i);
                expected.addFirst(i);
            }else{
                actual.addLast(i);
                expected.addLast(i);
            }
        }
    }
    @Test
    public void testAdd(){
        int index=RG.nextInt(10);
        assertEquals(expected.size(),actual.size());
        assertEquals(expected.get(index),actual.get(index));
    }


    @Test
    public void testRemoveFirst(){
        Integer exp=expected.removeFirst();
        Integer act=expected.removeFirst();
        assertEquals(exp,act);
        assertEquals(expected.size(),actual.size());
    }

    @Test
    public void testRemoveLast(){
        expected.addLast(5);
        expected.addLast(5);
        Integer exp=expected.removeLast();
        Integer act=expected.removeLast();
        assertEquals(exp,act);
        assertEquals(expected.size(),actual.size());
    }

    public static void main(String[] args) {
        actual.printDeque();
        expected.printDeque();
    }
}
