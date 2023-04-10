public class InternalNode<E> implements BinNode<E> {
    private E value;
    private final BinNode<E> left;
    private final BinNode<E> right;

    public InternalNode(E value, BinNode<E> left, BinNode<E> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    @Override
    public E element() {
        return this.value;
    }

    @Override
    public void setElement(E v) {
        this.value = v;
    }

    @Override
    public BinNode<E> left() {
        return this.left;
    }

    @Override
    public BinNode<E> right() {
        return this.right;
    }

    @Override
    public boolean isLeaf() {
        return false;
    }
}
