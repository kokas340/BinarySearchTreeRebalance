public class main {
    public static void main(String[] args) {

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10);
        BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(15);
        BinaryTreeNode<Integer> leftGrandchild = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> rightGrandchild = new BinaryTreeNode<>(7);
        BinaryTreeNode<Integer> rightGrandchild2 = new BinaryTreeNode<>(7);

        root.setLeftChild(leftChild);
        root.setRightChild(rightChild);
        leftChild.setLeftChild(leftGrandchild);
        leftChild.setRightChild(rightGrandchild);


        BinaryTreePrint treePrinter = new BinaryTreePrint();
        treePrinter.printTree(root);
    }
}
