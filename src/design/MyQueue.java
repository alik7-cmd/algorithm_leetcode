package design;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyQueue {

    private Deque<Integer> stack1;
    private Deque<Integer> stack2;


    public MyQueue() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        stack2.clear();
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int res = stack2.pop();

        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return res;

    }

    public int peek() {
        stack2.clear();
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int res = stack2.peek();

        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return res;
    }

    public boolean empty() {

        return stack1.isEmpty();

    }
}
