class BinaryTreeNode<T extends Comparable<T>> {
    private T data;
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public T getElement() {
        return data;
    }

    public BinaryTreeNode<T> getLeftChild() {
        return left;
    }

    public BinaryTreeNode<T> getRightChild() {
        return right;
    }

    public void setLeftChild(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public void setRightChild(BinaryTreeNode<T> right) {
        this.right = right;
    }
}