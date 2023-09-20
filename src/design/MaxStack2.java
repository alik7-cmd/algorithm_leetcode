package design;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxStack2 {

    private Deque<Integer> stack;
    private Deque<Integer> max;

    public MaxStack2() {
        stack = new ArrayDeque<>();
        max = new ArrayDeque<>();
    }

    public void push(int x){
        stack.push(x);
        if(stack.size() ==1){
            max.push(x);
            return;
        }

        max.push(Math.max(max.peek(), x));

    }

    public int getMax(){
        return max.peek();
    }

    public int popMax(){

        int res = max.peek();
        Deque<Integer> temp = new ArrayDeque<>();

        while (stack.peek() != res){
            temp.push(stack.pop());
            max.pop();
        }

        stack.pop();
        max.pop();

        while (!temp.isEmpty()){
            stack.push(temp.pop());
        }

        return res;


    }

    public int pop(){
        max.pop();
        return stack.pop();
    }


}
