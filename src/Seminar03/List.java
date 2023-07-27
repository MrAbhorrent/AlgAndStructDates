package src.Seminar03;

import java.sql.PreparedStatement;

public class List<V> {
    private Node head;

    public class Node{
        V data;
        Node next;

        Node() {
            data = null;
            next = null;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            Node node = (Node) obj;
            return this.data.equals(node.data);
        }
    }

    public Node find(V value) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.data == value) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    public void addFirst(V data) {
        Node newNode = new Node();
        newNode.data = data;
        if ( head != null) {
            newNode.next = head;
        }
        head = newNode;
    }

    public void add(V data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;
        if (head != null) {
            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        } else {
            addFirst(data);
        }
    }

    public void deleteFirst() {
        head = head.next;
    }

    public void revert() {
        if ( head != null) {
            Node currentNode = head.next;
            head.next = null;
            while (currentNode != null) {
                Node tempNode = currentNode.next;
                currentNode.next = head;
                head = currentNode;
                currentNode = tempNode;
            }
        }
    }

    public void bubbleSort() {
        Node tempNode;
        Node currentNode = head;
        V temData;
        if (currentNode != null) {
            while (currentNode != null) {
                tempNode = currentNode.next;
                while (tempNode != null) {
                    if ((Integer)currentNode.data > (Integer) tempNode.data) {
                        temData = currentNode.data;
                        currentNode.data = tempNode.data;
                        tempNode.data = temData;
                    }
                    tempNode = tempNode.next;
                }
                currentNode = currentNode.next;
            }
        }
    }

    public String printList() {
        Node currentNode = head;
        StringBuilder stringBuilder = new StringBuilder();
        while (currentNode != null) {
            stringBuilder.append(currentNode.data);
            if (currentNode.next != null) {
                stringBuilder.append(" -> ");
            }
            currentNode = currentNode.next;
        }
        return stringBuilder.toString();
    }
}
