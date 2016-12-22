/**
 * Created by User on 20.12.2016.
 */
public class LinkedList<T> {
    private Node<T> head = null;
    int count = 0;

    public void put(T value){
        if(head == null){
            head = new Node<T>(value);
            head.next = null;
        }else{
            Node<T> newNode = new Node<T>(value);
            newNode.next = head;
            head = newNode;
        }
        count++;
    }

    public T pull(){
        if(head != null){
            T val = head.value;
            head = head.next;
            count--;
            return val;
        }
        return null;
    }

    public T getByIndex(int index){
        int i = 0;
        Node<T> node = head;
        while(count > i){
            if(i == index && node != null){
                return node.value;
            }else if(node == null){
                return null;
            }
            node = node.next;
            i++;
        }
        return null;
    }

    public void setByIndex(int index,T val){
        int i = 0;
        Node<T> node = head;
        while(true){
            if(i == index || node == null){
                node.value = val;
            }
            node = node.next;
            i++;
        }
    }


    class Node<T>{
        T value;
        Node next;

        Node(T value){
            this.value = value;
        }
    }
}
