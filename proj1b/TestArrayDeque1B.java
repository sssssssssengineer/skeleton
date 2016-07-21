import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by CYS on 2016/7/21.
 */

public class TestArrayDeque1B {
    @Test
    public void testSize(){
        StudentArrayDeque<Integer> actual = new StudentArrayDeque<Integer>();
        FailureSequence fs = new FailureSequence();

        actual.addFirst(5);
        DequeOperation dequeOp1 = new DequeOperation("addFirst", 5);
        fs.addOperation(dequeOp1);

        actual.removeFirst();
        DequeOperation dequeOp2 = new DequeOperation("removeFirst");
        fs.addOperation(dequeOp2);

        actual.removeFirst();
        DequeOperation dequeOp3 = new DequeOperation("removeFirst");
        fs.addOperation(dequeOp3);

        int expectedSize = 0;
        assertEquals("\n" + fs.toString(), expectedSize, actual.size());

    }
    public static void main(String[] args) {
        jh61b.junit.TestRunner.runTests("all", TestArrayDeque1B.class);
    }
}
