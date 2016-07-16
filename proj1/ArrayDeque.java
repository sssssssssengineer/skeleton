/**
 * Created by CYS on 2016/7/16.
 * Array based doubly ended queue.
 */
public class ArrayDeque<Item> {
    private static int INIT_CAPACITY = 8;
    private static int RFACTOR = 2;
    public Item[] items;
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

    /** For ArrayDequeTest */
    public void setItem(Item item, int index){ items[index] = item; }
    public Item getItem(int index){ return items[index]; }

    /** Determine the next index when moving */
    private int nextLeft(int index){
        return (index == 0) ? (capacity - 1) : (index - 1);
    }
    private int nextRight(int index){
        return (index == capacity - 1) ? 0 : (index + 1);
    }

    /** Add item to ArrayDeque */
    public void addFront(Item item){
        //resize if full
        items[front] = item;
        front = nextLeft(front);
        size = size + 1;
    }
    public void addLast(Item item){
        //resize if full
        items[rear] = item;
        rear = nextRight(rear);
        size = size + 1;
    }



    /** Determine the endpoint of deque traversal */
    private int beforeRear(int rear){
        return (rear == 0) ? (capacity - 1) : (rear - 1);
    }
    private int afterFront(int front){
        return (front == capacity - 1) ? 0 : (front + 1);
    }

    /** Print deque, from afterFront to beforeRear */
    public void printDeque(){
        if (!isEmpty()){
            int runner = afterFront(front);
            while (runner != beforeRear(rear)){
                System.out.print(getItem(runner) + " ");
                runner = nextRight(runner);
            }
            System.out.print(getItem(runner));
        }
    }
    /** Trivial methods */
    public boolean isEmpty(){ return size == 0; }
    public int size(){ return size; }

}
