public interface Stack<E> {
    /** Reinitialize the stack. */
    void clear();
    
    /** Push an element onto the top of the stack.
    @param it The element being pushed onto the stack. */
    void push(E it);
    
    /** Remove and return the element at the top of the stack.
    @return The element at the top of the stack. */
    E pop();
    
    /** @return A copy of the top element. */
    E topValue();
    
    /** @return The number of elements in the stack. */
    int length();
}
    