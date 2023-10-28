import java.util.ArrayList;

class BinaryTree<E extends Comparable<E>> {
    private BinaryTreeNode<E> root;

    public BinaryTreeNode<E> getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode<E> root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return countNodes(root);
    }

    private int countNodes(BinaryTreeNode<E> node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.getLeftChild()) + countNodes(node.getRightChild());
    }

    public boolean contains(E element) {
        return containsElement(root, element);
    }

    private boolean containsElement(BinaryTreeNode<E> node, E target) {
        if (node == null) {
            return false;
        }

        if (target.equals(node.getElement())) {
            return true;
        }

        return containsElement(node.getLeftChild(), target) || containsElement(node.getRightChild(), target);
    }


}
