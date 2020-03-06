import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testOne(){
        char a='a';
        char b='b';
        assertTrue(offByOne.equalChars(a,b));
        assertFalse(offByOne.equalChars(',','a'));
        assertFalse(offByOne.equalChars('b','!'));
        assertFalse(offByOne.equalChars('a','a'));
        assertFalse(offByOne.equalChars('!','!'));
    }

    @Test
    public void testCase(){
        assertFalse(offByOne.equalChars('a','a'));
        assertFalse(offByOne.equalChars('a','A'));
        assertFalse(offByOne.equalChars('A','A'));
    }

}
