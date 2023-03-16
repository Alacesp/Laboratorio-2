package org.mps.deque;

<<<<<<< HEAD
/**
 * @author Alvaro Acedo Espejo
 * @author Jose Torres Postigo
 */
=======
import java.util.Deque;

>>>>>>> b1d37d899afbf71d07d08c461fbc0c1d255b67b6
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
<<<<<<< HEAD
            throw new DoubleEndedQueueException("You cannot store a null value.");
=======
            throw new DoubleEndedQueueException("No se puede almacenar un valor nulo.");
>>>>>>> b1d37d899afbf71d07d08c461fbc0c1d255b67b6

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
<<<<<<< HEAD
            throw new DoubleEndedQueueException("You cannot store a null value.");

        DequeNode nodo;

        // Si en la deque hay nodo(s)
=======
            throw new DoubleEndedQueueException("No se puede almacenar un valor nulo");

        DequeNode nodo;

>>>>>>> b1d37d899afbf71d07d08c461fbc0c1d255b67b6
        if (last != null) {
            nodo = new DequeNode(value, last, null);
            last.setNext(nodo);
            last = nodo;
<<<<<<< HEAD
        }

        // Si la deque esta vacia
        else {
=======
        } else {
>>>>>>> b1d37d899afbf71d07d08c461fbc0c1d255b67b6
            nodo = new DequeNode(value, null, null);
            first = last = nodo;
        }
        size++;
    }

    @Override
    public void deleteFirst() {
        // TODO
        if (this.size() == 0)
<<<<<<< HEAD
            throw new DoubleEndedQueueException("Deque is empty.");
=======
            throw new DoubleEndedQueueException("La deque esta vacia.");
>>>>>>> b1d37d899afbf71d07d08c461fbc0c1d255b67b6

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
<<<<<<< HEAD
            throw new DoubleEndedQueueException("Deque is empty.");
=======
            throw new DoubleEndedQueueException("La deque esta vacia.");
>>>>>>> b1d37d899afbf71d07d08c461fbc0c1d255b67b6

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
<<<<<<< HEAD
            throw new DoubleEndedQueueException("Deque is empty.");
=======
            throw new DoubleEndedQueueException("La deque esta vacia.");
>>>>>>> b1d37d899afbf71d07d08c461fbc0c1d255b67b6

        return first.getItem();
    }

    @Override
    public T last() {
        // TODO
        if(last == null)
<<<<<<< HEAD
            throw new DoubleEndedQueueException("Deque is empty.");
=======
            throw new DoubleEndedQueueException("La deque esta vacia.");
>>>>>>> b1d37d899afbf71d07d08c461fbc0c1d255b67b6
        return last.getItem();
    }

    @Override
    public int size() {
        // TODO
        return size;
    }
}
