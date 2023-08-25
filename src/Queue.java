import java.util.NoSuchElementException;
public class Queue  {
    private float front; // The index of the front item.
    private float rear; // The index of the rear item
    private float manyItems; // The number of elements in the queue.
    private float[] data; // The array that holds the items.

    public Queue() {
        final int INITIAL_CAPACITY = 10;
        manyItems = 0.0f;
        data =  new float[INITIAL_CAPACITY];
    }

    public Queue(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Invalid Capacity. " + "\nYou entered: " + initialCapacity);
        }
        manyItems = 0.0f;
        data = new float[initialCapacity];
    }

    public void add(float item) throws OutOfMemoryError {
        if (manyItems == data.length) {
            ensureCapacity((int) (manyItems * 2) + 1);
        }
        rear++;
        data[(int) rear] = item;
        manyItems++; // Indicates that there's now an element in the array.
    }

    public void remove() throws NoSuchElementException {
        if (manyItems == 0.0) {
            throw new NoSuchElementException("Queue is empty.");
        }

    }

    public void ensureCapacity(int minimumCapacity) {
        float[] biggerArray;

        int intValue = (int) manyItems;
        if (data.length < minimumCapacity) {
            biggerArray = new float[minimumCapacity];
            System.arraycopy(data, 0, biggerArray, 0, intValue);
            data = biggerArray;
        }
    }

    public boolean isEmpty() {
        return manyItems == 0.0;
    }

    public int size() {
        return (int) manyItems;
    }
}
