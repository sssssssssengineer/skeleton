import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by CYS on 2016/7/21.
 */
public class TestLinkedListDeque1B {
    @Test
    public void testRemoveLast(){
        StudentLinkedListDeque<Integer> actual = new StudentLinkedListDeque<Integer>();
        FailureSequence fs = new FailureSequence();

        actual.addFirst(1);
        DequeOperation dequeOp1 = new DequeOperation("addFirst", 1);
        fs.addOperation(dequeOp1);

        actual.addLast(2);
        DequeOperation dequeOp2 = new DequeOperation("addLast", 2);
        fs.addOperation(dequeOp2);

        actual.removeLast();
        DequeOperation dequeOp3 = new DequeOperation("removeLast");
        fs.addOperation(dequeOp3);

        assertEquals("\n" + fs.toString(), Integer.valueOf(1), actual.get(0));
    }
    public static void main(String[] args){
        jh61b.junit.TestRunner.runTests("all", TestLinkedListDeque1B.class);
    }
}
