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


    public Iterator<T> getIterator() {
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

    // TODO: optimize this ?
    public T get(int index){
        Iterator<T> iter = getIterator();
        int count = 0;
        while (count < index -1){
            if(iter.hasNext()){
                count++;
                iter.next();
            }else{
                return null;
            }
        }
        if(iter.hasNext()){
            return iter.next();
        }
        return null;
    }


    public T remove(int index){
        Node<T> current = head;
        for (int i=0; i<index-1; i++){
            if(current == null){
                return null;
            }
            current = current.next;
        }

        T data = current.next.data;
        current.next = current.next.next;
        return data; 
    }


    public String toString(){
        String LinkedListString = "";
        Iterator<T> iter = getIterator();
        while(iter.hasNext()){
            LinkedListString += "("+iter.next()+") ->";
        }
        LinkedListString += "(null)";
        
        return LinkedListString;
    }
}