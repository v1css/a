package br.edu.faseh.lista;
public class FasehList<T> {
    // Hold the reference to the first node of this List.
    private Node<T> firstNode;
    private Node<T> lastNode;
    private int totalElements;

    private final int NAO_ENCONTRADO = -1;

    public void insertAtBeginning(T value) {
        Node<T> newNode = new Node<>(value);
        if (this.totalElements == 0) {
            this.firstNode = newNode;
            this.lastNode = newNode;
        } else {
            newNode.setNext(firstNode);
            this.firstNode = newNode;
        }
        this.totalElements++;
    }
    public int getTotalElements() {
        return this.totalElements;
    }

    public void insertAtEnd(T value) {
        Node<T> newNode = new Node<>(value);
        if (this.totalElements == 0){
            this.firstNode = newNode;
            this.lastNode = newNode;
        } else {
            this.lastNode.setNext(newNode);
            this.lastNode = newNode;
        }
        this.totalElements++;
    }

    public Node<T> removeAtBeginning() {
        Node<T> aux = firstNode;
        firstNode = firstNode.getNext();
        totalElements--;
        return aux;
    }

    public int busca(T value) {

        Node<T> noAtual = this.firstNode;
        int pos = 0;

        while (noAtual != null) {

            if (noAtual.getValue().equals(value)) {
                return pos;
            }
            pos++;
            noAtual = noAtual.getNext();
        }

        return NAO_ENCONTRADO;
    }


    public Node<T> removeByKey(T value) {
        if (firstNode == null) {
            return null;
        }

        if (firstNode.getValue().equals(value)) {
            Node<T> removedNode = firstNode;
            firstNode = firstNode.getNext();
            totalElements--;
            return removedNode;
        }

        Node<T> current = firstNode;
        Node<T> previous = null;

        while (current != null && !current.getValue().equals(value)) {
            previous = current;
            current = current.getNext();
        }

        if (current != null) {
            previous.setNext(current.getNext());
            totalElements--;
            return current;
        }

        return null;
    }


    @Override
    public String toString() {


        if (this.totalElements == 0) {
            return "[]";
        }

        StringBuilder builder = new StringBuilder("[");

        Node<T> atual = this.firstNode;
        for (int i = 0; i < this.totalElements - 1; i++) {
            builder.append(atual.getValue()).append(",");
            atual = atual.getNext();
        }
        builder.append(atual.getValue()).append("]");


        return builder.toString();
    }
    // Design the other list methods.
//    Insert at the end, in order, remove at the end,
//    remove elements by value, search an element.
}