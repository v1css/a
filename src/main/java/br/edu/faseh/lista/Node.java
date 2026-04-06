package br.edu.faseh.lista;

// You can extend comparable interface,
// this enables you to check if two elements are or not equals.

public class Node<T> {

    private T value;
    private Node next;

    public Node(T value) {
        this.value = value;
        this.next = null;
    }

    public Node(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}


