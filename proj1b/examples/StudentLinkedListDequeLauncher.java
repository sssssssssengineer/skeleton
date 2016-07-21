/**
 * Created by CYS on 2016/7/21.
 */
public class StudentLinkedListDequeLauncher {
    public static void main(String[] args){
        StudentLinkedListDeque<Integer> slld = new StudentLinkedListDeque<Integer>();
        slld.addFirst(1);
        slld.addLast(2);
        slld.printDeque();
        slld.removeLast();
        System.out.println(slld.get(0));
    }
}
