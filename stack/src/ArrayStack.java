/**
 * Stack implementation using an array.<br/>
 * @param <E> Container type
 */
public final class ArrayStack<E> implements Stack<E> {
    private int top;
    private E[] data;

    private static final int DEFAULT_SIZE = 1;

    /**
     * Create <code>ArrayStack</code>.<br/>
     */
    @SuppressWarnings("unchecked")
    public ArrayStack() {
        this.top = 0;
        this.data = (E[]) new Object[DEFAULT_SIZE];
    }

    @SuppressWarnings("unchecked")
    private void tryGrow() {
        if (this.top < this.data.length) {
            return;
        }

        E[] newData = (E[]) new Object[this.data.length * 2];
        System.arraycopy(this.data, 0, newData, 0, this.data.length);
        this.data = newData;
    }

    /**
     * Remove all items in this container.<br/>
     * Time complexity: O(n).<br/>
     */
    @Override
    public void clear() {
        for (int i = 0; i < this.top; i++) {
            this.data[i] = null;
        }
        this.top = 0;
    }

    /**
     * Add given item to the top of this stack.<br/>
     * Time complexity: O(1).<br/>
     * @param it The element being pushed
     */
    @Override
    public void push(E it) {
        this.tryGrow();
        this.data[this.top] = it;
        this.top += 1;
    }

    /**
     * Removes and returns the item at the top of this stack.<br/>
     * Time complexity: O(1).<br/>
     * @return Item that removed from top of this stack
     * @throws IndexOutOfBoundsException when stack is empty
     */
    @Override
    public E pop() {
        if (this.top == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        this.top -= 1;
        E item = this.data[this.top];
        this.data[this.top] = null;
        return item;
    }

    /**
     * Returns the item at the top of this stack.<br/>
     * Time complexity: O(1).<br/>
     * @return Item at the top of this stack
     * @throws IndexOutOfBoundsException when stack is empty
     */
    @Override
    public E topValue() {
        if (this.top == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return this.data[this.top - 1];
    }

    /**
     * Returns the number of items in this stack.<br/>
     * Time complexity: O(1).<br/>
     * @return Number of items in this stack
     */
    @Override
    public int length() {
        return this.top;
    }
}
