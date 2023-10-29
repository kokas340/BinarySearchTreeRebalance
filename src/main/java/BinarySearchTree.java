import java.util.ArrayList;
import java.util.List;

class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {
    private BinaryTreeNode<E> root;

    public boolean insert(E element) {
        setRoot(insertElement(getRoot(), element));
        return true; // Assuming always successful for simplicity
    }

    private BinaryTreeNode<E> insertElement(BinaryTreeNode<E> node, E element) {
        if (node == null) {
            node = new BinaryTreeNode<>();
            node.setElement(element);
        } else {
            int compareResult = element.compareTo(node.getElement());
            if (compareResult < 0) {
                node.addLeftChild(insertElement(node.getLeftChild(), element));
            } else if (compareResult > 0) {
                node.addRightChild(insertElement(node.getRightChild(), element));
            }
        }
        return node;
    }

    public boolean removeElement(E element) {
        BinaryTreeNode<E>[] result = removeElement(getRoot(), element);
        setRoot(result[0]);
        return result[1] != null;
    }

    private BinaryTreeNode<E>[] removeElement(BinaryTreeNode<E> node, E element) {
        BinaryTreeNode<E>[] result = new BinaryTreeNode[2]; // [0] is new node, [1] is removed node

        if (node == null) {
            result[0] = null;
            result[1] = null;
        } else {
            int compareResult = element.compareTo(node.getElement());
            if (compareResult < 0) {
                BinaryTreeNode<E>[] leftResult = removeElement(node.getLeftChild(), element);
                node.addLeftChild(leftResult[0]);
                result[0] = node;
                result[1] = leftResult[1];
            } else if (compareResult > 0) {
                BinaryTreeNode<E>[] rightResult = removeElement(node.getRightChild(), element);
                node.addRightChild(rightResult[0]);
                result[0] = node;
                result[1] = rightResult[1];
            } else {
                // Node with the element found, remove it
                result[1] = node;
                if (node.getLeftChild() == null) {
                    result[0] = node.getRightChild();
                } else if (node.getRightChild() == null) {
                    result[0] = node.getLeftChild();
                } else {
                    BinaryTreeNode<E>[] minResult = removeMin(node.getRightChild());
                    node.setElement(minResult[1].getElement());
                    node.addRightChild(minResult[0]);
                    result[0] = node;
                    result[1] = minResult[1];
                }
            }
        }

        return result;
    }

    private BinaryTreeNode<E>[] removeMin(BinaryTreeNode<E> node) {
        BinaryTreeNode<E>[] result = new BinaryTreeNode[2]; // [0] is new node, [1] is removed node

        if (node.getLeftChild() == null) {
            result[0] = node.getRightChild();
            result[1] = node;
        } else {
            BinaryTreeNode<E>[] leftResult = removeMin(node.getLeftChild());
            node.addLeftChild(leftResult[0]);
            result[0] = node;
            result[1] = leftResult[1];
        }

        return result;
    }

    public E findMin(){
        BinaryTreeNode<E> current = root;
        while (current.getLeftChild() != null) {
            current = current.getLeftChild();
        }
        return current.getElement();
    }
    public E findMax(){
        BinaryTreeNode<E> current = root;
        while (current.getRightChild() != null) {
            current = current.getLeftChild();
        }
        return current.getElement();
    }

    public boolean contains(E element) {
        return containsElement(root, element);
    }
    private boolean containsElement(BinaryTreeNode<E> node, E target) {
        if (node == null) {
            return false;
        }
        int comparisonResult = target.compareTo(node.getElement());

        if (comparisonResult < 0) {
            return containsElement(node.getLeftChild(), target);
        } else if (comparisonResult > 0) {
            return containsElement(node.getRightChild(), target);
        } else {
            return true;
        }
    }


    public void rebalanceAndPrint() {
        List<E> elements = new ArrayList<>();
        collectElementsInOrder(getRoot(), elements);
        setRoot(sortedListToBST(elements, 0, elements.size() - 1));

        // Print the balanced tree
        BinaryTreePrint printer = new BinaryTreePrint();
        printer.printTree(getRoot());
    }




    private void collectElementsInOrder(BinaryTreeNode<E> node, List<E> elements) {
        if (node != null) {
            collectElementsInOrder(node.getLeftChild(), elements);
            elements.add(node.getElement());
            collectElementsInOrder(node.getRightChild(), elements);
        }
    }

    private BinaryTreeNode<E> sortedListToBST(List<E> elements, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        BinaryTreeNode<E> node = new BinaryTreeNode<>();
        node.setElement(elements.get(mid));
        node.addLeftChild(sortedListToBST(elements, start, mid - 1));
        node.addRightChild(sortedListToBST(elements, mid + 1, end));

        return node;
    }
}

