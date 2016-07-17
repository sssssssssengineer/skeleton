/**
 * Created by CYS on 2016/7/16.
 * Array based doubly ended queue.
 */
public class ArrayDeque<Item> {
    private static int INIT_CAPACITY = 8;
    private static int RESIZE_FACTOR = 2;
    private static double USAGE_FACTOR = 0.25;
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

    /** Getter and setter */
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
        if (size == capacity){ expand(); }
        items[front] = item;
        front = nextLeft(front);
        size = size + 1;
    }
    public void addLast(Item item){
        if (size == capacity){ expand(); }
        items[rear] = item;
        rear = nextRight(rear);
        size = size + 1;
    }

    /** Remove item from ArrayDeque */
    public Item removeFirst(){
        front = nextRight(front);
        Item toRemove = getItem(front);
        setItem(null, front);
        size = size - 1;
        //shrink if too spacious
        return toRemove;
    }
    public Item removeLast(){
        rear = nextLeft(rear);
        Item toRemove = getItem(rear);
        setItem(null, rear);
        size = size - 1;
        //shrink if too spacious
        return toRemove;
    }

    /** Get item via index */
    public Item get(int index){
        int start = nextRight(front);
        int actualIndex = (start + index) % capacity;
        return getItem(actualIndex);
    }

    /**
     * Performance optimization: resize
     * Expand when it's full, shrink when it's too spacious
     */
    public void expand(){
        Item[] newItems = (Item[]) new Object[capacity * RESIZE_FACTOR];
        /*
        int runner = nextRight(front);
        int newItemsIndex = 1;
        while (runner != nextLeft(rear)){
            newItems[newItemsIndex] = getItem(runner);
            newItemsIndex++;
            runner = nextRight(runner);
        }
        newItems[newItemsIndex] = getItem(runner);
        items = newItems;
        capacity *= RESIZE_FACTOR;
        front = 0;
        rear = newItemsIndex + 1;
        */
        int beginIndex = nextRight(front);
        int endIndex = nextLeft(rear);
        if (endIndex < beginIndex){
            System.arraycopy(items, beginIndex, newItems, 1, capacity - beginIndex);
            System.arraycopy(items, 0, newItems, capacity - beginIndex + 1, endIndex + 1);
        } else {
            System.arraycopy(items, beginIndex, newItems, 1, endIndex - beginIndex + 1);
        }
        items = newItems;
        rear = capacity + 1;
        capacity *= RESIZE_FACTOR;
        front = 0;
    }
    public void shrink(){
        Item[] newItems = (Item[]) new Object[capacity / RESIZE_FACTOR];
        int beginIndex = nextRight(front);
        int endIndex = nextLeft(rear);
        if (endIndex < beginIndex){
            System.arraycopy(items, beginIndex, newItems, 1, capacity - beginIndex);
            System.arraycopy(items, 0, newItems, capacity - beginIndex + 1, endIndex + 1);
        } else {
            System.arraycopy(items, beginIndex, newItems, 1, capacity);
        }
        items = newItems;
        rear = capacity + 1;
        capacity *= RESIZE_FACTOR;
        front = 0;
    }


    /** Present deque using a String */
    public String dequeString(){
        String res = new String();
        if (isEmpty()) { return res; }
        int runner = nextRight(front);
        while (runner != nextLeft(rear)){
            res = res + getItem(runner).toString() + " ";
            runner = nextRight(runner);
        }
        res = res + getItem(runner).toString();
        return res;
    }


    /** Trivial methods */
    public boolean isEmpty(){ return size == 0; }
    public int size(){ return size; }



}
