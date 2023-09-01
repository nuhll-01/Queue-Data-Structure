import javax.swing.plaf.LabelUI;
import java.util.NoSuchElementException;

public class Queue implements Cloneable {

    private int[] data; // The array that holds the items.
    private int manyItems; // The number of elements in the queue.
    private int front; // The index of the front item.
    private int rear; // The index of the rear item

    public Queue() {
        final int INITIAL_CAPACITY = 10;
        manyItems = 0;
        data = new int[INITIAL_CAPACITY];
    }

    public Queue(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Invalid Capacity. " + "\nYou entered: " + initialCapacity);
        }
        manyItems = 0;
        data = new int[initialCapacity];
    }

    public void add(int item) throws OutOfMemoryError {
        if (manyItems == data.length) {
            ensureCapacity((manyItems * 2) + 1);
        }
        if (manyItems == 0) {
            front = 0;
            rear = 0;
        } else {
            rear = nextIndex(rear);
        }
        data[rear] = item;
        manyItems++; // Indicates that there's now an element in the array.
    }

    public int remove() throws NoSuchElementException {
        int answer;

        if (manyItems == 0) {
            throw new NoSuchElementException("Queue Underflow.");
        }
        answer = data[front];
        data[front] = 0;
        front = nextIndex(front);
        manyItems--;
        return answer;
    }

    private int nextIndex(int i) {
        if (i == data.length - 1) {
            return 0;
        } else {
            return ++i;
        }
    }

    public void ensureCapacity(int minimumCapacity) throws OutOfMemoryError {
        int[] biggerArray;
        int n1, n2;
        if (data.length >= minimumCapacity) {
        } else if (manyItems == 0) {
            data = new int[minimumCapacity];
        } else if (manyItems > 0 && front <= rear) {
            biggerArray = new int[minimumCapacity];
            System.arraycopy(data, front, biggerArray, front, manyItems);
            data = biggerArray;
        } else {
            biggerArray = new int[minimumCapacity];
            n1 = data.length - front;
            n2 = rear + 1;
            System.arraycopy(data, front, biggerArray, 0, n1);
            System.arraycopy(data, 0, biggerArray, n1, n2);
            front = 0;
            rear = manyItems - 1;
            data = biggerArray;
        }
    }

    public int indexOf(int element) {
        int answer = -1;
        int i = 0;
        while (i <= manyItems && answer == -1) {
            if (element == data[i]) {
                answer = i;
            }
            i++;
        }
        return answer;
    }

    @Override
    public Queue clone() {
        Queue clone;
        try {
            clone = (Queue) super.clone();
        } catch (CloneNotSupportedException exception) {
            throw new RuntimeException("No 'Cloneable' interface found.");
        }
        clone.data = data.clone();
        return clone;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < manyItems; i++) {
            sb.append(data[(front + i) % data.length]);
            if (i < manyItems - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public void clear() {
        int i;
        for (i = 0; i < data.length; i++) {
            data[i] = 0;
        }
        front = 0;
        rear = 0;
        manyItems = 0;
    }

    public boolean contains(int element) {
        return indexOf(element) != -1;
    }

    public void print() {
        for (int i = 0; i < data.length; ++i) {
            System.out.println(data[i] + " ");
        }
    }

    public boolean isEmpty() {
        return manyItems == 0;
    }

    public int getFront() throws ArrayIndexOutOfBoundsException {
        return data[front];
    }

    public int getRear() {
        return data[rear];
    }

    public int getCapacity() {
        return data.length;
    }

    public int size() {
        return manyItems;
    }
}
