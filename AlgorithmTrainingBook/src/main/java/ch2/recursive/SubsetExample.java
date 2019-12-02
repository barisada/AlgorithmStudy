package ch2.recursive;

import java.util.*;

public class SubsetExample {

    private Stack<Integer> subset = new Stack<>();

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3);

        SubsetExample ex = new SubsetExample();
        ex.printSubset(list, 0);
    }

    public void printSubset(List<Integer> list, int index){
        if(list.size() == index){
            System.out.println(subset);
        } else {
            int cur = list.get(index);
            subset.push(cur);
            printSubset(list, index + 1);

            subset.pop();
            printSubset(list, index + 1);
        }

    }
}
