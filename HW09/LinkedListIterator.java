import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterator for LinkedList.
 * @author Somtochukwu Nwagbata
 * @version 1.0
 * @param <T> type of elements the list contains
 */
public class LinkedListIterator<T> implements Iterator<T> {
    private Node<T> next;

    LinkedListIterator(Node<T> next) {
        this.next = next;
    }

    // I think you would basically pass in the head of the list and then kind of
    // tell if there's a next node from their
    @Override
    public boolean hasNext() {
        if (next != null) {
            return true;
        }
        return false;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T temp = next.getData();
        this.next = next.getNext();
        return temp;
    }

}
