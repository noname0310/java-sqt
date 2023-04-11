/**
 * LinkedList based queue implementation.<br/>
 * @param <E> Container type
 */
public class LinkedQueue<E> implements Queue<E> {
    private static final class Node<E> {
        public E value;
        public Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    private int length;
    private final Node<E> front;
    private Node<E> rear;

    /**
     * Create <code>LinkedQueue</code> with given node pool.<br/>
     */
    public LinkedQueue() {
        this.length = 0;
        this.front = new Node<>(null, null);
        this.rear = this.front;
    }

    /**
     * remove all items in this container.<br/>
     * Time complexity: O(1).<br/>
     */
    @Override
    public void clear() {
        this.front.next = null;
        this.rear = this.front;
        this.length = 0;
    }

    /**
     * Add given item to the end of this queue.<br/>
     * Time complexity: O(1).<br/>
     * @param it The element being enqueued
     */
    @Override
    public void enqueue(E it) {
        this.rear.next = new Node<>(it, null);
        this.rear = this.rear.next;
        this.length += 1;
    }

    /**
     * Removes and returns the item at the beginning of this queue.<br/>
     * Time complexity: O(1).<br/>
     * @return Item that removed from beginning of this queue
     * @throws IndexOutOfBoundsException when queue is empty
     */
    @Override
    public E dequeue() {
        Node<E> removeNode = this.front.next;
        if (removeNode == null) {
            throw new IndexOutOfBoundsException("Queue is empty");
        }

        this.front.next = this.front.next.next;
        if (this.front.next == null) {
            this.rear = this.front;
        }

        this.length -= 1;

        return removeNode.value;
    }

    /**
     * Get item at the beginning of this queue.<br/>
     * Time complexity: O(1).<br/>
     * @return Item that beginning of this queue
     * @throws IndexOutOfBoundsException when queue is empty
     */
    @Override
    public E frontValue() {
        if (this.front.next == null) {
            throw new IndexOutOfBoundsException("Queue is empty");
        }
        return this.front.next.value;
    }

    /**
     * Get number of items contained in this queue.<br/>
     * Time complexity: O(1).<br/>
     * @return length of this queue
     */
    @Override
    public int length() {
        return this.length;
    }
}
