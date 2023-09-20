package linkedList;



class LinkedList2 {
    Node head;

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    private LinkedList2(Node head) {
        this.head = head;
    }

    public LinkedList2(int data) {
        Node head = new Node(data);
        this.head = head;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void traverseLinkedList(Node head){
        Node current = head;
        while (current != null){
            System.out.print(current.data+" ");
            current = current.next;
        }
    }

    public void append(int val) {
        Node node = new Node(val);
        if (head == null) return;
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = node;
    }

    public Node push(int val){
        Node node = new Node(val);
        if(head == null) return node;
        node.next = head;
        head = node;
        return head;
    }

    public Node insertAt(int position, int val){
        Node node = new Node(val);
        Node current = head;
        int count = 1;
        while (count < position){
            current = current.next;
            count++;

        }
        node.next = current.next;
        current.next = node;

        return head;

    }

    public void delete(int key){
        Node prev = null;
        Node temp = head;

        while (temp != null && temp.data != key){
            prev = temp;
            temp = temp.next;
        }
        if(temp == null) return;
        prev.next = temp.next;
    }

    public void deleteAt(int position){
        int count = 1;
        Node current = head;
        if(position == 0) {
            head = current.next;
            return;
        }
        while (count < position){
            current = current.next;
            count++;
        }
        current.next = current.next.next;

    }

    public int size(){
        if(head == null) return 0;
        int count = 0;

        Node current = head;
        while (current!= null){
            current = current.next;
            count++;
        }

        return count;

    }

    /**
     * Time Complexity: O(n)
     * @param head
     * @return
     */
    public Node reverse(Node head){
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;

    }

    public Node deepCopy(Node head){

        Node newHead = new Node(head.data);
        Node current = head.next;
        Node newCurrent = newHead;

        while (current != null){
            newCurrent.next = new Node(current.data);
            newCurrent = newCurrent.next;
            current = current.next;
        }

        traverseLinkedList(newHead);

        return newHead;

    }
}

class TestLinkedList{
    public static void main(String [] args){
        LinkedList2 ll = new LinkedList2(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.append(5);
        ll.push(0);
        ll.traverseLinkedList(ll.head);
        ll.deepCopy(ll.head);

        System.out.println();
        System.out.println(ll.size());

        //LinkedList<String> ll1 = new LinkedList<>();
    }
}
