

public class main {
    public static void main(String[] args) {
        // Creating a binary search tree

     BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(1);
        bst.insert(3);
        bst.insert(2);

        bst.rebalanceAndPrint();
        //ADDING ELEMENTS
        System.out.println("\n \n                                   --------------ADDING ELEMENTS----------------");
        bst.insert(6);
        bst.insert(4);
        bst.insert(8);
        bst.insert(9);
        bst.insert(11);
        bst.insert(-1);
        bst.insert(99);
        bst.rebalanceAndPrint();

        System.out.println("\n \n                                   --------------REMOVING ELEMENTS----------------");
        bst.removeElement(6);

        bst.rebalanceAndPrint();

        System.out.println("\n ");
        System.out.println("FIND MIN VALUE -> "+bst.findMin());
        System.out.println("FIND Max VALUE -> "+bst.findMax());
       System.out.println("FIND VALUE -> "+bst.contains(8));
    }
}
