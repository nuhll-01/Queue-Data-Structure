import java.util.NoSuchElementException;
public class Queue  {

    private float[] data; // The array that holds the items.
    private int manyItems; // The number of elements in the queue.
    private int front; // The index of the front item.
    private int rear; // The index of the rear item

    public Queue() {
        final int INITIAL_CAPACITY = 10;
        manyItems = 0;
        data =  new float[INITIAL_CAPACITY];
    }

    public Queue(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Invalid Capacity. " + "\nYou entered: " + initialCapacity);
        }
        manyItems = 0;
        data = new float[initialCapacity];
    }

    public void add(float item) throws OutOfMemoryError {
        // if (manyItems == data.length) {
        //     ensureCapacity((manyItems * 2) + 1);
        // }
        if (manyItems == 0) {
            front = 0;
            rear = 0;
        } else {
            rear = nextIndex(rear);
        }
        data[rear] = item;
        manyItems++; // Indicates that there's now an element in the array.
    }

    private int nextIndex(int i) {
        if (i == data.length - 1) {
            return 0;
        } else {
            return i + 1;
        }
    }

    public float remove() throws NoSuchElementException {
        if (manyItems == 0) {
            throw new NoSuchElementException("Queue is empty.");
        }
        float answer  = data[front];
        data[front++] = 0;
        return answer;
    }

    public void print() {
        for (int i = 0; i < manyItems; i++) {
            System.out.println(data[i]);
        }
    }

    // public void ensureCapacity(int minimumCapacity) {
    //     float[] biggerArray;
//
    //     int intValue = manyItems;
    //     if (data.length < minimumCapacity) {
    //         biggerArray = new float[minimumCapacity];
    //         System.arraycopy(data, 0, biggerArray, 0, intValue);
    //         data = biggerArray;
    //     }
    // }

    public boolean isEmpty() {
        return manyItems == 0;
    }

    public int getCapacity() {
        return data.length;
    }

    public int size() {
        return manyItems;
    }
}
