package design;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Shuffle {

    private int [] array;
    private int [] original;
    private Random random;

    public Shuffle(int[] nums) {
        array = nums;
        original = array.clone();
        random = new Random();

    }

    public int[] reset() {
        array = original;
        original = original.clone();
        return original;
    }

    private List<Integer> asList(){
        List<Integer> list = new ArrayList<>();
        for(int n : array){
            list.add(n);
        }
        return list;
    }

    public int[] shuffle() {

        List<Integer> list = asList();

        for(int i = 0; i< array.length;i++){
            int index = random.nextInt(list.size());
            array[i] = list.get(index);
            list.remove(index);
        }

        return array;

    }
}
