class BinaryTreeNode<E extends Comparable<E>> {
    private E element;
    private BinaryTreeNode<E> left;
    private BinaryTreeNode<E> right;

    public void setElement(E element){
        this.element=element;
    }
    public E getElement(){
        return element;
    }

    public void addLeftChild(BinaryTreeNode left){
        this.left=left;
    }
    public void addRightChild(BinaryTreeNode right){
        this.right=right;
    }
    public  BinaryTreeNode getLeftChild(){
        return (left == null) ? null : left;
    }
    public  BinaryTreeNode getRightChild(){
        return (right == null) ? null : right;
    }

}