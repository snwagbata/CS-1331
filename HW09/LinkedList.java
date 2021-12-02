import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * LinkedList class.
 * 
 * @author Somtochukwu Nwagbata
 * @version 1.0
 * @param <T> type of elements the list contains
 */
public class LinkedList<T> implements List<T> {
    private int size;
    private Node<T> head;

    /**
     * Constructor for a linked list.
     */
    public LinkedList() {
    }

    /**
     * Constructor for a linked list from array.
     * 
     * @param list array of elements to be stored in the list
     */
    public LinkedList(T[] list) {
        if (list.length > 0) {

            this.size = list.length;
            Node<T> first = new Node<T>(list[0]);
            Node<T> temp = first;

            for (int i = 1; i < size; i++) {
                Node<T> cur = new Node<T>(list[i]);
                temp.setNext(cur);
                temp = temp.getNext();
            }

            this.head = first;
        }
    }

    /**
     * Iterator for LinkedList.
     * 
     * @return iterator for the list
     */
    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<T>(this.head);
    }

    /**
     * Returns the head of the list.
     * 
     * @return head of the list
     */
    public Node<T> getHead() {
        return head;
    }

    /**
     * Inserts the element at the front of the list.
     * 
     * @param element data we are adding to the list
     * @throws IllegalArgumentException if the passed in element is null
     */
    @Override
    public void add(T element) {
        if (element == null) {
            throw new IllegalArgumentException();
        }

        Node<T> temp = new Node<T>(element);
        temp.setNext(head);
        head = temp;
        size++;
    }

    /**
     * Inserts the element at the specified index.
     * 
     * @param index   index to add the element
     * @param element data we are adding to the list
     * @throws IllegalArgumentException  if the passed in element is null
     * @throws IndexOutOfBoundsException if the passed in index is invalid. index ==
     *                                   list.size() is valid
     */
    @Override
    public void add(int index, T element) {
        if (element == null) {
            throw new IllegalArgumentException();
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            Node<T> zero = new Node<T>(element, head);
            head = zero;
            size++;
            return;
        }

        if (index == size) {
            Node<T> last = new Node<T>(element);
            Node<T> temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(last);
            size++;

            return;
        }

        Node<T> temp = head;
        Node<T> previous = new Node<T>();
        int count = 0;

        while (previous != null) {
            if (count == index) {
                Node<T> added = new Node<>(element, temp);
                previous.setNext(added);
                size++;
                return;
            }
            previous = temp;
            temp = temp.getNext();
            count++;
        }

    }

    /**
     * Removes the element at the specified index and returns it.
     * 
     * @param index index of element to be removed
     * @return the removed element at the specified index
     * @throws IndexOutOfBoundsException if the passed in index is invalid
     */
    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            Node<T> temp = head;
            head = head.getNext();
            size--;
            return temp.getData();
        }

        Node<T> temp = head;
        Node<T> previous = new Node<T>();
        int count = 0;

        while (previous != null) {
            if (count == index) {
                previous.setNext(temp.getNext());
                size--;
                return temp.getData();
            }
            previous = temp;
            temp = temp.getNext();
            count++;
        }

        return null;
    }

    /**
     * Removes the specified element from the list and returns it.
     * 
     * @param element data to be removed
     * @return the removed element from the list
     * @throws NoSuchElementException if the passed in element is not in the list
     */
    @SuppressWarnings("all")
    @Override
    public T remove(T element) throws NoSuchElementException {
        if (element == null) {
            throw new IllegalArgumentException();
        }
        if (size == 0) {
            throw new NoSuchElementException();
        }

        if (head.getData().equals(element)) {
            T removed = head.getData();
            head = head.getNext();
            size--;
            return removed;
        }

        Node<T> temp = head;
        Node<T> previous = new Node<>();

        // Store Node being removed to a temporary variable and then equal that node to
        // the
        // .getNext
        while (temp != null) {
            if (temp.getData().equals(element)) {
                T removed = temp.getData();
                previous.setNext(temp.getNext());
                size--;

                return removed;
            }
            previous = temp;
            temp = temp.getNext();
        }
        if (temp == null) {
            throw new NoSuchElementException();
        }

        return null; // I love dead code
    }

    /**
     * Removes the head (first element) from the list and returns it.
     * 
     * @return the removed element from the head of the list, null if the list is
     *         empty
     */
    @Override
    public T remove() {
        if (size == 0) {
            return null;
        }
        T temp = head.getData();
        size--;
        head = head.getNext();

        return temp;
    }

    /**
     * Remove duplicates from the list.
     */
    public void removeDuplicates() {
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (get(i).equals(get(j))) {
                    remove(j);
                    j--; // Reason: As we removed an element, the list shifts left, as the list has
                         // shifted left, if we continue along the original iteration, we would miss
                         // checking the first element that shifted into the position of the element that
                         // was removed. So we need to decrement j to compensate for the shift.
                }
            }
        }
    }

    /**
     * Returns the element at the specified index.
     * 
     * @param index index of the element to return
     * @return element at the specified index
     * @throws IndexOutOfBoundsException if the passed in index is invalid
     */
    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> temp = head;
        int count = 0;

        while (temp != null) {
            if (count == index) {
                return temp.getData();
            }
            temp = temp.getNext();
            count++;
        }

        return null;
    }

    /**
     * Checks if a list contains a specific element.
     * 
     * @param element data to check for in list
     * @return boolean representing if the list has the element or not
     */
    @Override
    public boolean contains(T element) {
        if (element == null) {
            throw new IllegalArgumentException();
        }

        Node<T> temp = head;

        for (int i = 0; i < size; i++) {
            if (get(i).equals(element)) {
                return true;
            }
            temp = temp.getNext();
        }

        return false;
    }

    /**
     * Replaces the element at a specific index with the passed in data.
     * 
     * @param index   index of the element to replace
     * @param element the element to set
     * @return element that has been replaced
     * @throws IndexOutOfBoundsException if the passed in index is invalid
     * @throws IllegalArgumentException  if the passed in element is null
     */
    @Override
    public T set(int index, T element) {
        if (element == null) {
            throw new IllegalArgumentException();
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        // keep a counter similar to get and have the code go to the Node being changed
        // using the iterator and then change the data at the node
        Node<T> temp = head;
        int count = 0;

        while (temp != null) {
            if (count == index) {
                T replaced = temp.getData();
                temp.setData(element);
                return replaced;
            }
            temp = temp.getNext();
            count++;
        }
        return null;
    }

    /**
     * Clears the list.
     */
    @Override
    public void clear() {
        head = null;
        size = 0;

    }

    /**
     * Checks if the list is empty.
     * 
     * @return true if the list is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        if (size == 0 || head == null) {
            return true;
        }
        return false;
    }

    /**
     * Returns the number of elements in the list.
     * 
     * @return int representing size of list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns an array representation of the list.
     * 
     * @return array representation of the list
     */
    @SuppressWarnings("unchecked")
    public T[] toArray() {
        T[] arr = (T[]) new Object[size];
        for (int i = 0; i < size; i++) {
            arr[i] = get(i);
        }

        return arr;
    }
}
