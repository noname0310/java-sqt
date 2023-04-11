/**
 * Fixed size array based Queue that use circular queue method.<br/>
 * @param <E> Container type
 */
public final class ArrayQueue<E> implements Queue<E> {
    private int front;
    private int rear;
    private final E[] data;

    /**
     * Create <code>ArrayQueue</code> with given size.<br/>
     * @param size Size of queue
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue(int size) {
        this.front = 0;
        this.rear = 0;
        this.data = (E[]) new Object[size + 1];
    }

    /**
     * remove all items in this container.<br/>
     * Time complexity: O(n).<br/>
     */
    @Override
    public void clear() {
        for (int i = this.front; i != this.rear; i = (i + 1) % this.data.length) {
            this.data[i] = null;
        }
        this.front = 0;
        this.rear = 0;
    }

    /**
     * Add given item to the end of this queue.<br/>
     * Time complexity: O(1).<br/>
     * @param it The element being enqueued
     * @throws IndexOutOfBoundsException when queue is full
     */
    @Override
    public void enqueue(E it) {
        if ((this.rear + 1) % this.data.length == this.front) {
            throw new IndexOutOfBoundsException("Queue is full");
        }
        this.data[this.rear] = it;
        this.rear = (this.rear + 1) % this.data.length;
    }

    /**
     * Removes and returns the item at the beginning of this queue.<br/>
     * Time complexity: O(1).<br/>
     * @return Item that removed from beginning of this queue
     * @throws IndexOutOfBoundsException when queue is empty
     */
    @Override
    public E dequeue() {
        if (this.front == this.rear) {
            throw new IndexOutOfBoundsException("Queue is empty");
        }
        E it = this.data[this.front];
        this.data[this.front] = null;
        this.front = (this.front + 1) % this.data.length;
        return it;
    }

    /**
     * Get item at the beginning of this queue.<br/>
     * Time complexity: O(1).<br/>
     * @return Item that beginning of this queue
     * @throws IndexOutOfBoundsException when queue is empty
     */
    @Override
    public E frontValue() {
        if (this.front == this.rear) {
            throw new IndexOutOfBoundsException("Queue is empty");
        }
        return this.data[this.front];
    }

    /**
     * Get number of items contained in this queue.<br/>
     * Time complexity: O(1).<br/>
     * @return length of this queue
     */
    @Override
    public int length() {
        int capacity = this.data.length;
        return (this.rear - this.front + capacity) % capacity;
    }
}
