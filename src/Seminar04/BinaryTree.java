package src.Seminar04;

public class BinaryTree<V extends Comparable<V>>{

    private Node root;

    class Node {
        private V data;
        private Node left;
        private Node right;
    }

    public boolean findNode(V data) {
        Node node = root;

        while (node != null) {
            if (node.data.equals(data)) {
                return true;
            }
            if (node.data.compareTo(data) > 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return false;
    }
}
