public class TreeTest {
    public static void main(String[] args){
        //build tree
        var nodeG = new LeafNode<>("G");
        var nodeH = new LeafNode<>("H");
        var nodeI = new LeafNode<>("I");

        var nodeD = new LeafNode<>("D");
        var nodeE = new InternalNode<>("E", null, nodeG);
        var nodeF = new InternalNode<>("F", nodeH, nodeI);

        var nodeB = new InternalNode<>("B", nodeD, nodeE);
        var nodeC = new InternalNode<>("C", null, nodeF);

        var nodeA = new InternalNode<>("A", nodeB, nodeC);

        //traversal
        preorderTraversal(nodeA, System.out::print);
        System.out.println();
        inorderTraversal(nodeA, System.out::print);
        System.out.println();
        postorderTraversal(nodeA, System.out::print);
        System.out.println();
    }

    public interface TraversalCallback<T> {
        void call(T value);
    }

    public static <T> void preorderTraversal(BinNode<T> node, TraversalCallback<T> callback) {
        if (node == null) return;
        callback.call(node.element());
        preorderTraversal(node.left(), callback);
        preorderTraversal(node.right(), callback);
    }

    public static <T> void inorderTraversal(BinNode<T> node, TraversalCallback<T> callback) {
        if (node == null) return;
        inorderTraversal(node.left(), callback);
        callback.call(node.element());
        inorderTraversal(node.right(), callback);
    }

    public static <T> void postorderTraversal(BinNode<T> node, TraversalCallback<T> callback) {
        if (node == null) return;
        postorderTraversal(node.left(), callback);
        postorderTraversal(node.right(), callback);
        callback.call(node.element());
    }
}
