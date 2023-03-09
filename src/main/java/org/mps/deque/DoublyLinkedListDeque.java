package org.mps.deque;

import java.util.Deque;

public class DoublyLinkedListDeque<T> implements DoubleEndedQueue<T> {

    private DequeNode<T> first;
    private DequeNode<T> last;
    private int size;

    public DoublyLinkedListDeque() {
        // TODO
        first = last = null;
        size = 0;

    }

    @Override
    public void prepend(T value) {
        // TODO
        if (value == null)
            throw new DoubleEndedQueueException("No se puede almacenar un valor nulo.");

        DequeNode nodo;

        // Si en la deque hay nodo(s)
        if (first != null) {
            nodo = new DequeNode(value, null, first);
            first.setPrevious(nodo);
            first = nodo;
        } else { // La deque esta vacia
            nodo = new DequeNode(value, null, null);
            first = last = nodo;
        }
        size++;
    }

    @Override
    public void append(T value) {
        // TODO
        if (value == null)
            throw new DoubleEndedQueueException("No se puede almacenar un valor nulo");

        DequeNode nodo;

        if (last != null) {
            nodo = new DequeNode(value, last, null);
            last.setNext(nodo);
            last = nodo;
        } else {
            nodo = new DequeNode(value, null, null);
            first = last = nodo;
        }
        size++;
    }

    @Override
    public void deleteFirst() {
        // TODO
        if (this.size() == 0)
            throw new DoubleEndedQueueException("La deque esta vacia.");

        first = first.getNext();

        if (first == null) {
            last = null;
        } else {
            first.setPrevious(null);
        }
        size--;
    }

    @Override
    public void deleteLast() {
        // TODO
        if (this.size() == 0)
            throw new DoubleEndedQueueException("La deque esta vacia.");

        last = last.getPrevious();

        if (last == null) {
            first = null;
        } else {
            last.setNext(null);
        }
        size--;
    }

    @Override
    public T first() {
        // TODO
        if (first == null)
            throw new DoubleEndedQueueException("La deque esta vacia.");

        return first.getItem();
    }

    @Override
    public T last() {
        // TODO
        if(last == null)
            throw new DoubleEndedQueueException("La deque esta vacia.");
        return last.getItem();
    }

    @Override
    public int size() {
        // TODO
        return size;
    }
}
