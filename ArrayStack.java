public class ArrayStack<T> {
    private Object[] data;
    private int top;
    private int capacity;

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        this.data = new Object[capacity];
        this.top = -1;
    }

    public void push(T element) {
        if (isFull()) {
            throw new IllegalStateException("Stack Overflow: Stack is full");
        }
        data[++top] = element;
    }


    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack Underflow: Stack is empty");
        }
        T element = (T) data[top];
        data[top--] = null; 
        return element;
    }

 
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return (T) data[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public int size() {
        return top + 1;
    }
}
