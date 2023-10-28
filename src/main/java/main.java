import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        // Creating a binary search tree
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        // Inserting elements into the binary search tree
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(2);
        bst.insert(4);
        bst.insert(6);
        bst.insert(8);


        // Printing the binary search tree structure
        BinaryTreePrint treePrinter = new BinaryTreePrint();
        treePrinter.printTree(bst.getRoot());


    }
}
