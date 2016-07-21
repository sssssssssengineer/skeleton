import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by CYS on 2016/7/21.
 */
public class TestLinkedListDeque1B {
    @Test
    public void testSize(){
        StudentLinkedListDeque<Integer> actual = new StudentLinkedListDeque<Integer>();
        actual.addFirst(1);
        actual.addLast(2);
        assertEquals(Integer.valueOf(1), actual.get(0));
        actual.removeLast();
        assertEquals(Integer.valueOf(1), actual.get(0));
    }
    public static void main(String[] args){
        jh61b.junit.TestRunner.runTests("all", ArithmeticTest.class);
    }
}
