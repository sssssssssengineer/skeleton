/**
 * Created by CYS on 2016/7/16.
 * Array based doubly ended queue.
 */
public class ArrayDeque<Item> {
    private static int INIT_CAPACITY = 8;
    private static int RFACTOR = 2;
    private Item[] items;
    private int size;
    private int capacity;
    private int front, rear;

    public ArrayDeque(){
        items = (Item[]) new Object[INIT_CAPACITY];
        capacity = INIT_CAPACITY;
        size = 0;
        front = 0;
        rear = 1;
    }

    public void addFront(){

    }
}
