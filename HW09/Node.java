/**
 * Node of a linked list.
 * @author Somtochukwu Nwagbata
 * @version 1.0
 * @param <T> type of data stored in the node
 */
public class Node<T> {
    private T data;
    private Node<T> next;

    /**
     * Constructor for a node.
     * @param data data to be stored in the node
     * @param next next node in the list
     */
    Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    /**
     * Constructor for a node.
     * @param data data to be stored in the node
     */
    Node(T data) {
        this(data, null);
    }

    /**
     * No-arg constructor for a node.
     */
    Node() {
    }

    /**
     * Returns the data stored in the node.
     * @return data stored in the node
     */
    public T getData() {
        return data;
    }

    /**
     * Sets the data stored in the node.
     * @param data data to be stored in the node
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Sets the next node in the list.
     * @param next next node in the list
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * Returns the next node in the list.
     * @return next node in the list
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * equals method for a node.
     * @param obj object to be compared to
     * @return true if the objects are equal and false otherwise
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Node<?>) {
            Node<T> other = (Node<T>) obj;
            return other.data.equals(data) && other.next.equals(next);
        }

        return false;
    }
}
