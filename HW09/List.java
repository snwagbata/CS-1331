import java.util.NoSuchElementException;

/**
 * List Abstract Data Type.
 * @author CS1331 TAs
 * @version 1.0
 * @param <E> type of elements the list contains
 */
public interface List<E> extends Iterable<E> {

    /**
     * Inserts the element at the front of the list.
     * @param element data we are adding to the list
     * @throws IllegalArgumentException if the passed in element is null
     */
    void add(E element) throws IllegalArgumentException;

    /**
     * Inserts the element at the specified index.
     * @param index index to add the element
     * @param element data we are adding to the list
     * @throws IllegalArgumentException if the passed in element is null
     * @throws IndexOutOfBoundsException if the passed in index is invalid. index == list.size() is valid
     */
    void add(int index, E element) throws IllegalArgumentException, IndexOutOfBoundsException;


    /**
     * Removes the element at the specified index and returns it.
     * @param index index of element to be removed
     * @return the removed element at the specified index
     * @throws IndexOutOfBoundsException if the passed in index is invalid
     */
    E remove(int index) throws IndexOutOfBoundsException;

    /**
     * Removes the specified element from the list and returns it.
     * @param element data to be removed
     * @return the removed element from the list
     * @throws NoSuchElementException if the passed in element is not in the list
     */
    E remove(E element) throws NoSuchElementException;

    /**
     * Removes the head (first element) from the list and returns it.
     * @return the removed element from the head of the list, null if the list is empty
     */
    E remove();

    /**
     * Returns the element at the specified index.
     * @param index index of the element to return
     * @return element at the specified index
     * @throws IndexOutOfBoundsException if the passed in index is invalid
     */
    E get(int index) throws IndexOutOfBoundsException;

    /**
     * Checks if a list contains a specific element.
     * @param element data to check for in list
     * @return boolean representing if the list has the element or not
     */
    boolean contains(E element);

    /**
     * Replaces the element at a specific index with the passed in data.
     * @param index index of the element to replace
     * @param element the element to set
     * @return element that has been replaced
     * @throws IndexOutOfBoundsException if the passed in index is invalid
     * @throws IllegalArgumentException if the passed in element is null
     */
    E set(int index, E element) throws IndexOutOfBoundsException, IllegalArgumentException;

    /**
     * Clears the list.
     */
    void clear();

    /**
     * Checks if the list is empty.
     * @return true if the list is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in the list.
     * @return int representing size of list
     */
    int size();
}
