package linkedList;

public class LinkedList3 {

    Node2 head;

    public LinkedList3(int data) {
        head = new Node2(data);
    }

    static class Node2{
        int data;
        Node2 next;

        public Node2(int data) {
            this.data = data;
            next = null;
        }
    }

    public void append(int data){
        Node2 current = head;
        while (current.next != null){
            current = current.next;
        }

        current.next = new Node2(data);

    }

    public void push(int data){
        Node2 node = new Node2(data);
        node.next = head;
        head = node;

    }

    public void insertAt(int index, int data){
        Node2 node = new Node2(data);
        int count = 1;
        Node2 current = head;
        while (count < index){
            current = current.next;
            count++;
        }
        node.next = current.next;
        current.next = node;
    }

    public void delete(int key){
        Node2 current = head;
        Node2 prev = null;

        while (current != null && current.data != key){
            prev = current;
            current = current.next;
        }

        if(current == null) return;

        prev.next = current.next;
    }

    public void deleteAt(int index){
        Node2 current = head;
        int count = 1;

        if(index ==0){
            head = head.next;
            return;
        }

        while (count < index){
            count++;
            current = current.next;
        }

        current.next = current.next.next;

    }

    public void print(){
        Node2 current = head;
        while (current != null){
            System.out.print(current.data+" ");
            current = current.next;
        }
    }

    public void reverse(){
        Node2 prev = null;
        Node2 curr = head;
        Node2 next = head;

        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;

    }

    public int size(){
        Node2 current = head;
        int count = 0;
        while (current != null){
            count++;
            current = current.next;
        }

        return count;
    }

}

class T{
    public static void main(String [] args){
        LinkedList3 list = new LinkedList3(0);
        list.append(1);
        list.append(2);
        list.append(3);
        list.push(-1);
        list.insertAt(2, 11);
        //list.delete(11);
        list.print();
        /*list.delete(2);
        System.out.println();
        list.print();
        System.out.println();*/
        //System.out.println("Size of the list is : "+list.size());
    }
}
