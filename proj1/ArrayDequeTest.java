import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by CYS on 2016/7/16.
 */
public class ArrayDequeTest {

    @Test
    public void testAdd(){
        ArrayDeque<String> expected = new ArrayDeque<String>();
        expected.setItem("one", 1);
        expected.setItem("two", 2);
        expected.setItem("zero", 0);
        expected.setItem("seven", 7);
        ArrayDeque<String> actual = new ArrayDeque<String>();
        actual.addLast("one");
        actual.addLast("two");
        actual.addFront("zero");
        actual.addFront("seven");
        assertEquals(expected.getItem(1), actual.getItem(1));
        assertEquals(expected.getItem(2), actual.getItem(2));
        assertEquals(expected.getItem(0), actual.getItem(0));
        assertEquals(expected.getItem(7), actual.getItem(7));
    }

    @Test
    public void testDequeToString(){
        ArrayDeque<Integer> actual = new ArrayDeque<Integer>();
        actual.addFront(0);
        actual.addFront(7);
        actual.addFront(6);
        actual.addLast(1);
        assertEquals(actual.dequeString(), "6 7 0 1");
    }

    public static void main(String[] args) {
        jh61b.junit.TestRunner.runTests("all", ArithmeticTest.class);
    }
}
