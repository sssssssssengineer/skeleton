/**
 * Created by CYS on 2016/7/16.
 * Linked List based Deque with circular sentinel topology.
 */
public class LinkedListDeque2<Item> {
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
    private Node sentinel;

    public LinkedListDeque2(){
        size = 0;
        sentinel = new Node();
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public void addFirst(Item item){
        size = size + 1;
        Node oldFirst = sentinel.next;
        Node newFirst = new Node(item, sentinel, oldFirst);
        oldFirst.prev = newFirst;
        sentinel.next = newFirst;
    }

    public void addLast(Item item){
        size = size + 1;
        Node oldLast = sentinel.prev;
        Node newLast = new Node(item, oldLast, sentinel);
        oldLast.next = newLast;
        sentinel.prev = newLast;
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
            Node runner = sentinel.next;
            while (runner.next != sentinel){
                System.out.print(runner.item + " ");
                runner = runner.next;
            }
            System.out.println(runner.item);
        }
    }

    public Item removeFirst(){
        if (isEmpty()){ return null; }
        size = size - 1;
        Node toRemove = sentinel.next;
        Node newFirst = toRemove.next;
        sentinel.next = newFirst;
        newFirst.prev = sentinel;
        toRemove.prev = null;
        toRemove.next = null;
        return toRemove.item;
    }

    public Item removeLast(){
        if (isEmpty()){ return null; }
        size = size - 1;
        Node toRemove = sentinel.prev;
        Node newLast = toRemove.prev;
        sentinel.prev = newLast;
        newLast.next = sentinel;
        toRemove.prev = null;
        toRemove.next = null;
        return toRemove.item;
    }

    public Item get(int index){
        if (isEmpty()){ return null; }
        if (index > size - 1) { return null; }
        Node runner = sentinel.next;
        while (index > 0){
            runner = runner.next;
            index = index - 1;
        }
        return runner.item;
    }

    private Item getRecursive(Node runner, int index){//private helper function
        if (index == 0){
            return runner.item;
        }
        return getRecursive(runner.next, index - 1);
    }

    public Item getRecursive(int index){
        if (isEmpty()){ return null; }
        if (index > size - 1) { return null; }
        return getRecursive(sentinel.next, index);
    }
}
