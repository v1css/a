package br.edu.faseh.lista;

public class FasehPilha<T> {
    private FasehList<T> internalList = new FasehList<>();

    // insere no topo
    public void push(T value) {
        internalList.insertAtBeginning(value);
    }

    // remove e retorna o topo
    public T pop() {
        if (isEmpty()) return null;
        Node<T> removed = internalList.removeAtBeginning();
        return removed.getValue();
    }

    public boolean isEmpty() {
        return internalList.getTotalElements() == 0;
    }

    public int size() {
        return internalList.getTotalElements();
    }

    @Override
    public String toString() {
        return internalList.toString();
    }
}
