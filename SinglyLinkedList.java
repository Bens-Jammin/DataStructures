import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<T>{

    protected static class Node<T>{
        T data;
        Node<T> next;

        Node(T data){
            this.data = data;
            next = null;
        }
    }

    private class LinkedListIterator implements Iterator<T> {

        private Node<T> current;


        LinkedListIterator(){
            current = null;
        }


        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if(current == null){
                current = head;
            }

            T data = current.data;
            current = current.next;
            return data;
        }
        

        public boolean hasNext() {
            if(current == null){
                return head != null;
            }

            return current.next != null;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;


    public SinglyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }


    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }


    public void add(T data){
        Node<T> newNode = new Node<>(data);
        if(head == null){
            head = newNode;
            tail = head;
            size++;
            return;
        }
        tail.next = newNode;
        tail = tail.next;
        size++;
        return;
    }


    public boolean isEmpty(){
        return size != 0;
    }

    // need a get(), remove(), toString() methods I think
}