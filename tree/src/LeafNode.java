public class LeafNode<E> implements BinNode<E> {
    private E value;

    public LeafNode(E value) {
        this.value = value;
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
        return null;
    }

    @Override
    public BinNode<E> right() {
        return null;
    }

    @Override
    public boolean isLeaf() {
        return true;
    }
}
