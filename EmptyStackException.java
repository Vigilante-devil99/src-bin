import java.util.Arrays;
import java.util.EmptyStackException;

public class ResizableArrayStack<T> {
    private static final int DEFAULT_CAPACITY = 4;
    private Object[] data;
    private int size;

    public ResizableArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    public ResizableArrayStack(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.data = new Object[initialCapacity];
        this.size = 0;
    }

    public void push(T element) {
        if (size == data.length) {
            resize(2 * data.length);
        }
        data[size++] = element;
    }

 
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T element = (T) data[--size];
        data[size] = null; 

      
        if (size > 0 && size == data.length / 4 && data.length / 2 >= DEFAULT_CAPACITY) {
            resize(data.length / 2);
        }

        return element;
    }

 
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (T) data[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return data.length;
    }

    private void resize(int newCapacity) {
        data = Arrays.copyOf(data, newCapacity);
    }
}
