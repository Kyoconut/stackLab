import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayBasedStack<T> implements StackInterface<T> {
    private T[] stack;
    private int size = 0;
    public static int DEFAULT_CAPACITY = 10;

    public ArrayBasedStack() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayBasedStack(int capacity) {
        stack = (T[])new Object[capacity];
    }

    public void push(T data) {
        if (size >= stack.length) {
            expandArray();
        }
        stack[size++] = data;
    }
    static {
        StackInterface<Integer> myStack = new ArrayBasedStack<>(1);
        myStack.push(123);
        myStack.push(321);
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[--size];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void expandArray() {
        stack = Arrays.copyOf(stack, stack.length * 2);
    }

    @Override
    public void clear() {
        while (!isEmpty()){
            pop();
        }

    }

    @Override
    public T peek() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return stack[size-1];
    }


}

