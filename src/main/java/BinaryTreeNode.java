public class BinaryTreeNode<T> {
    private T data;
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public BinaryTreeNode getLeftChild() {
        return left;
    }
    public BinaryTreeNode getRightChild() {
        return right;
    }

    public void setLeftChild(BinaryTreeNode<T> leftChild){
        this.left=leftChild;
    }
    public void setRightChild(BinaryTreeNode<T> rightChild){
        this.right=rightChild;
    }


    public int getElement() {
        return (int) data;
    }
}