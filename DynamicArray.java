import java.util.Arrays;

public class DynamicArray {
    private int[] data;
    private int size;

    public DynamicArray(int initialCapacity) {
        data = new int[initialCapacity];
        size = 0;
    }

    public DynamicArray() {
        this(2);
    }

    public void add(int element) {
        if (size == data.length) {
            resize(data.length * 2);
        }
        data[size++] = element;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return data[index];
    }

    private void resize(int newCapacity) {
        data = Arrays.copyOf(data, newCapacity);
    }

    public int size() {
        return size;
    }

    public void print() {
        System.out.println(Arrays.toString(Arrays.copyOf(data, size)));
    }

    public static void main(String[] args) {
        DynamicArray arr = new DynamicArray(2);

        arr.add(10);
        arr.add(20);
        arr.print();

        arr.add(30);
        arr.add(40);
        arr.add(50);
        arr.print();
    }
}
