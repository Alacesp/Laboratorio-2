package org.mps.deque;

import java.util.Comparator;

/**
 * @author Alvaro Acedo Espejo
 * @author Jose Torres Postigo
 */
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
            throw new DoubleEndedQueueException("You cannot store a null value.");

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
            throw new DoubleEndedQueueException("You cannot store a null value.");

        DequeNode nodo;

        // Si en la deque hay nodo(s)
        if (last != null) {
            nodo = new DequeNode(value, last, null);
            last.setNext(nodo);
            last = nodo;
        }

        // Si la deque esta vacia
        else {
            nodo = new DequeNode(value, null, null);
            first = last = nodo;
        }
        size++;
    }

    @Override
    public void deleteFirst() {
        // TODO
        if (this.size() == 0)
            throw new DoubleEndedQueueException("Deque is empty.");

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
            throw new DoubleEndedQueueException("Deque is empty.");

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
            throw new DoubleEndedQueueException("Deque is empty.");

        return first.getItem();
    }

    @Override
    public T last() {
        // TODO
        if(last == null)
            throw new DoubleEndedQueueException("Deque is empty.");
        return last.getItem();
    }

    @Override
    public int size() {
        // TODO
        return size;
    }

    @Override
    public T get(int index) {
        if(index < 0 || index > this.size())
            throw new IndexOutOfBoundsException("The index must be in the bounds of the deque");

        DequeNode<T> aux = this.first;
        int i = 0;

        while(i != index){
            aux = aux.getNext();
            i++;
        }

        return aux.getItem();
    }

    @Override
    public boolean contains(T value){
        int i=0;
        boolean f = false;
        DequeNode<T> aux=first;
        while(i<this.size() && !f){
            if(aux.getItem()==value){
                f = true;
            }else{
                aux = aux.getNext();
                i++;
            }
        }
        return f;
    }

    @Override
    public void remove(T value){
        int i=0;
        boolean f = false;
        DequeNode<T> aux=first;
        DequeNode<T> previous;
        while(i<this.size() && !f){
            if(aux.getItem()==value){
                previous = aux.getPrevious();
                previous.setNext(aux.getNext());
                aux.getNext().setPrevious(previous);
                f = true;
            }else{
                aux = aux.getNext();
                i++;
            }
        }
    }

    @Override
    public void sort(Comparator<? super T> comparator) {
        if (this.size() == 0)
            throw new DoubleEndedQueueException("You cannot sort an empty deque.");
        if(this.size() == 1)
            throw new DoubleEndedQueueException("You cannot sort one-element deque.");

        int i = 0;
        DequeNode<T> current = this.first;

        while (i < this.size()) {
            T temp;
            int j = i + 1;
            DequeNode<T> next = current.getNext();

            while(j<this.size()){
                if(comparator.compare(current.getItem(), next.getItem()) < 0){
                    temp = current.getItem();
                    current.setItem(next.getItem());
                    next.setItem(temp);
                }
                next = next.getNext();
                j++;
            }
            current = current.getNext();
            i++;
        }
    }
}
