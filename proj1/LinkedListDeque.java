/**
 * Created by CYS on 2016/7/16.
 * Linked List based Deque with two sentinels, header and trailer.
 */
public class LinkedListDeque<Item> {
    public class Node{
        Item item;
        Node prev, next;
        public Node(){}
        public Node(Item item, Node prev, Node next){
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private int size;
    private Node header;
    private Node trailer;

    public LinkedListDeque(){
        size = 0;
        header = new Node();
        trailer = new Node();
        header.next = trailer;
        trailer.prev = header;
    }

    public void addFirst(Item item){
        size = size + 1;
        Node oldFirst = header.next;
        Node newFirst = new Node(item, header, oldFirst);
        oldFirst.prev = newFirst;
        header.next = newFirst;
    }

    public void addLast(Item item){
        size = size + 1;
        Node oldLast = trailer.prev;
        Node newLast = new Node(item, oldLast, trailer);
        oldLast.next = newLast;
        trailer.prev = newLast;
    }

    public boolean isEmpty(){
        if (size == 0){
            return true;
        }
        return false;
    }

    public int size(){ return size; }

    public void printDeque(){
        if (!isEmpty()){
            Node runner = header.next;
            while (runner.next != trailer){
                System.out.print(runner.item + " ");
                runner = runner.next;
            }
            System.out.println(runner.item);
        }
    }

    public Item removeFirst(){
        if (isEmpty()){ return null; }
        size = size - 1;
        Node toRemove = header.next;
        Node newFirst = toRemove.next;
        header.next = newFirst;
        newFirst.prev = header;
        toRemove.prev = null;
        toRemove.next = null;
        return toRemove.item;
    }

    public Item removeLast(){
        if (isEmpty()){ return null; }
        size = size - 1;
        Node toRemove = trailer.prev;
        Node newLast = toRemove.prev;
        trailer.prev = newLast;
        newLast.next = trailer;
        toRemove.prev = null;
        toRemove.next = null;
        return toRemove.item;
    }

    public Item get(int index){
        if (isEmpty()){ return null; }
        if (index > size - 1) { return null; }
        Node runner = header.next;
        while (index > 0){
            runner = runner.next;
            index = index - 1;
        }
        return runner.item;
    }
}
