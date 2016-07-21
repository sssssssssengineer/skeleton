import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by CYS on 2016/7/21.
 */

public class TestArrayDeque1B {
    @Test
    public void testSize(){
        StudentArrayDeque<Integer> actual = new StudentArrayDeque<Integer>();
        actual.addFirst(5);
        actual.removeFirst();
        actual.removeFirst();
        int expectedSize = 0;
        assertEquals(expectedSize, actual.size());
    }
    public static void main(String[] args) {
        jh61b.junit.TestRunner.runTests("all", ArithmeticTest.class);
    }
}
