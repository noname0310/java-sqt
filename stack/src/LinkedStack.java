/**
 * Linked list based stack implementation.<br/>
 * @param <E> Container type
 */
public final class LinkedStack<E> implements Stack<E> {
    @SuppressWarnings("ClassCanBeRecord")
    private static final class Node<E> {
        public final E value;
        public final Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    private int length;
    private Node<E> top;

    /**
     * Create <code>LinkedStack</code>.<br/>
     */
    public LinkedStack() {
        this.length = 0;
        this.top = null;
    }

    /**
     * Remove all items in this container.<br/>
     * Time complexity: O(1).<br/>
     */
    @Override
    public void clear() {
        this.top = null;
        this.length = 0;
    }

    /**
     * Add given item to the top of this stack.<br/>
     * Time complexity: O(1).<br/>
     * @param it The element being pushed
     */
    @Override
    public void push(E it) {
        this.top = new Node<>(it, this.top);
        this.length += 1;
    }

    /**
     * Removes and returns the item at the top of this stack.<br/>
     * Time complexity: O(1).<br/>
     * @return Item that removed from top of this stack
     * @throws IndexOutOfBoundsException when stack is empty
     */
    @Override
    public E pop() {
        if (this.length == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }

        E value = this.top.value;
        this.top = this.top.next;
        this.length -= 1;
        return value;
    }

    /**
     * Ger item at the top of this stack.<br/>
     * Time complexity: O(1).<br/>
     * @return Item at the top of this stack
     * @throws IndexOutOfBoundsException when stack is empty
     */
    @Override
    public E topValue() {
        if (this.length == 0) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }

        return this.top.value;
    }

    /**
     * Get the number of elements in this stack.<br/>
     * Time complexity: O(1).<br/>
     * @return Length of this stack
     */
    @Override
    public int length() {
        return this.length;
    }
}
