package src.Seminar04;

public class RedBlackTree{

    private Node root;

    class Node {
        private int data;
        private Node left;
        private Node right;
        private RedBlackColor color;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
            color = RedBlackColor.RED;
        }
    }

    RedBlackTree() {
        root = null;
    }

    public  boolean add(int data) {
        boolean result;
        if (root != null) {
            result = addNode(root, data);
            root = rebalance(root);
            root.color = RedBlackColor.BLACK;
        } else {
            root = new Node(data);
            root.color = RedBlackColor.BLACK;
            result = true;
        }
        return result;
    }

    private boolean addNode(Node node, int data) {
        if ( data == node.data) {
            return false;
        } else if (data < node.data) {
            if (node.left != null) {
                boolean result = addNode(node.left, data);
                node.left = rebalance(node.left);
                return result;
            } else {
                node.left = new Node(data);
                node.left.color = RedBlackColor.RED;
                return true;
            }
        } else {
            if (node.right != null) {
                boolean result = addNode(node.right, data);
                node.right = rebalance(node.right);
                return result;
            } else {
                node.right = new Node(data);
                node.right.color = RedBlackColor.RED;
                return true;
            }
        }
    }

    private Node rebalance(Node node) {
        Node result = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if (result.right != null && result.right.color == RedBlackColor.RED && (result.left == null || result.left.color == RedBlackColor.BLACK)) {
                needRebalance = true;
                result = rightSwap(result);
            }
            if (result.left != null && result.left.color == RedBlackColor.RED && result.left.left != null && result.left.left.color == RedBlackColor.RED) {
                needRebalance = true;
                result = rightSwap(result);
            }
            if (result.left != null && result.left.color == RedBlackColor.RED && result.right != null && result.right.color == RedBlackColor.RED) {
                needRebalance = true;
                colorSwap(result);
            }
        } while (needRebalance);
        return result;
    }

    private Node rightSwap(Node node) {
        Node rightChild = node.right;
        Node changeChild = rightChild.left;
        rightChild.right = node;
        node.right = changeChild;
        rightChild.color = RedBlackColor.RED;
        System.out.printf("Перекраска узла %d в цвет %s%n", node.data, node.color);
        return rightChild;
    }

    private Node leftSwap(Node node) {
        Node leftChild = node.left;
        Node changeChild = leftChild.right;
        leftChild.right = node;
        node.left = changeChild;
        leftChild.color = node.color;
        node.color = RedBlackColor.RED;
        return leftChild;
    }

    private void colorSwap(Node node) {
        node.left.color = node.right.color = RedBlackColor.BLACK;
        node.color = RedBlackColor.RED;
    }

    public boolean findNode(int data) {
        Node node = root;

        while (node != null) {
            if (node.data == data) {
                return true;
            }
            if (node.data > data) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return false;
    }
}
