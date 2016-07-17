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
    public void testDequeString(){
        ArrayDeque<Integer> actual = new ArrayDeque<Integer>();
        actual.addFront(0);
        actual.addFront(7);
        actual.addFront(6);
        actual.addLast(1);
        assertEquals(actual.dequeString(), "6 7 0 1");
    }

    @Test
    public void testRemove(){
        ArrayDeque<String> actual = new ArrayDeque<String>();
        actual.addFront("c");
        actual.addFront("b");
        actual.addFront("a");
        actual.removeFirst();
        assertEquals(actual.dequeString(), "b c");
        actual.removeLast();
        assertEquals(actual.dequeString(), "b");
    }

    @Test
    public void testGet(){
        ArrayDeque<Integer> actual = new ArrayDeque<Integer>();
        actual.addFront(0);
        actual.addFront(7);
        assertEquals(actual.get(1), Integer.valueOf(0));
        assertEquals(actual.get(0), Integer.valueOf(7));
    }

    @Test
    public void testExpand(){
        ArrayDeque<Integer> actual = new ArrayDeque<Integer>();
        for (int i = 1; i < 9; i++){
            actual.addLast(i);
        }
        actual.addFront(0);
        assertEquals(actual.dequeString(), "0 1 2 3 4 5 6 7 8");
        assertEquals(actual.size(), 9);
    }

    @Test
    public void testShrink(){
        ArrayDeque<Integer> actual = new ArrayDeque<Integer>();
        for (int i = 0; i < 32; i++){
            actual.addLast(i);
        }
        for (int i = 0; i < 24; i++){
            actual.removeLast();
        }
        actual.removeLast();
        assertEquals(actual.dequeString(), "0 1 2 3 4 5 6");
        assertEquals(actual.size(), 7);
    }

    public static void main(String[] args) {
        jh61b.junit.TestRunner.runTests("all", ArithmeticTest.class);
    }
}
