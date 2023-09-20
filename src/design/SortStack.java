package design;

import java.util.Stack;

public class SortStack {

    public static Stack<Integer> sort(Stack<Integer> stack){

        Stack<Integer> temp = new Stack<>();

        while (!stack.isEmpty()){
            int a = stack.pop();

            while (!temp.isEmpty() && temp.peek() < a){
                stack.push(temp.pop());
            }
            temp.push(a);

        }

        return temp;
    }

    public static void main(String args[])
    {
        Stack<Integer> input = new Stack<Integer>();
        input.add(34);
        input.add(3);
        input.add(31);
        input.add(98);
        input.add(92);
        input.add(23);

        // This is the temporary stack
        Stack<Integer> tmpStack=sort(input);
        System.out.println("Sorted numbers are:");

        while (!tmpStack.empty())
        {
            System.out.print(tmpStack.pop()+" ");
        }
    }
}
