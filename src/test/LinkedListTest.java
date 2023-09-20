package test;


import java.util.HashMap;
import java.util.Map;

public class LinkedListTest {

    static class Node {
        Node next;
        int value;

        public Node(int value) {
            this.value = value;
            next = null;
        }
    }

    public Node deleteDuplicates(Node head) {

       if(head == null || head.next == null) return head;
       Node current = head;
       while (current.next != null){
           if(current.value == current.next.value){
               current.next = current.next.next;
           }else {
               current = current.next;
           }
       }
       return head;

    }

    public boolean hasCycle(Node head) {
        if(head ==null) return false;
        Node current = head;
        Map<Node, Boolean> map = new HashMap<>();
        while (current.next != null){
            if(map.containsKey(current.next)){
                return true;
            }else {
                map.put(current, true);
                current = current.next;
            }
        }
        return false;
    }

    public Node append(Node head, int value) {
        Node temp = new Node(value);
        if (head == null) return temp;

        Node curr = head;

        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = temp;
        return head;
    }

    public Node addAt(Node head, int index, int value){
        int count = 1;
        Node current = head;
        Node temp = new Node(value);

        while (count < index){
            current = current.next;
            count++;
        }
        temp.next = current.next;
        current.next = temp;
        return head;

    }

    public void delete(Node head, int value){
        Node prev = null;
        Node curr = head;

        while (curr != null &&curr.value != value){
            prev = curr;
            curr = curr.next;
        }

        prev.next = curr.next;
    }

    public Node reverse(Node head){
        Node curr = head;
        Node prev = null;
        Node next;

        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }
}
