class BinarySearchTree<T extends Comparable<T>> {
    private BinaryTreeNode<T> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(T data) {
        this.root = insertRec(this.root, data);
    }

    private BinaryTreeNode<T> insertRec(BinaryTreeNode<T> node, T data) {
        if (node == null) {
            return new BinaryTreeNode<>(data);
        }

        if (data.compareTo(node.getElement()) < 0) {
            node.setLeftChild(insertRec(node.getLeftChild(), data));
        } else if (data.compareTo(node.getElement()) > 0) {
            node.setRightChild(insertRec(node.getRightChild(), data));
        }

        return node;
    }

    public BinaryTreeNode<T> getRoot() {
        return root;
    }
}

