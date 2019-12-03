package ch2.recursive;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PermutationExample {

    private Stack<Integer> permutation = new Stack<>();
    private boolean[] chosen;

    public static void main(String[] args) {
        PermutationExample ex = new PermutationExample();
        List<Integer> list = Arrays.asList(1,2,3);
        ex.chosen = new boolean[list.size()];
        ex.printPermutation(list, 0);
    }

    public void printPermutation(List<Integer> list, int index){
        if(list.size() == index){
            System.out.println(permutation);
        } else {
            for(int i = 0; i < list.size(); i++){
                if(chosen[i]) continue;

                permutation.push(list.get(i));
                chosen[i] = true;
                printPermutation(list, index + 1);

                permutation.pop();
                chosen[i] = false;
            }
        }
    }
}
