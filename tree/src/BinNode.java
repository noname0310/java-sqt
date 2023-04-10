public interface BinNode<E> {
    /** Get and set the element value */
    E element();
    void setElement(E v);
    /** @return The left child */
    BinNode<E> left();
    /** @return The right child */
    BinNode<E> right();
    /** @return True if a leaf node, false otherwise */
    boolean isLeaf();
}
