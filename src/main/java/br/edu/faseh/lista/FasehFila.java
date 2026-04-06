package br.edu.faseh.lista;

public class FasehFila<T> {
    private FasehList<T> internalList = new FasehList<>();

    // Adiciona ao final da fila (Entrada de pacientes)
    public void enqueue(T value) {
        internalList.insertAtEnd(value);
    }

    // Remove do início (Chamar o próximo)
    public T dequeue() {
        if (isEmpty()) return null;
        Node<T> removed = internalList.removeAtBeginning();
        return (removed != null) ? removed.getValue() : null;
    }

    public boolean isEmpty() {
        return internalList.getTotalElements() == 0;
    }

    @Override
    public String toString() {
        return internalList.toString();
    }
}
