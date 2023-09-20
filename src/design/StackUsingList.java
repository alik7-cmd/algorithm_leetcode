package design;

import java.util.ArrayList;
import java.util.List;

public class StackUsingList {

    private List<Integer> list;

    public StackUsingList() {
        list = new ArrayList<>();
    }

    public void push(int x){
        list.add(x);
    }

    public int pop(){
        int lastIndex = list.size()-1;
        return list.remove(lastIndex);
    }

    public int peek(){
        int lastIndex = list.size()-1;
        return list.get(lastIndex);
    }

    public int min(){
        return -1;
    }
}
