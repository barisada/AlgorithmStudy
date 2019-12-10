package ch2.recursive.problem;

import java.util.ArrayList;
import java.util.Stack;
import java.util.stream.Collectors;

public class PermutationSequence {
    Stack<Integer> permutation = new Stack<>();
    boolean[] chosen;
    boolean shouldContinue = true;

    public static void main(String[] args) {
        PermutationSequence ex = new PermutationSequence();
        String answer1 = ex.getPermutation(3,3);
        System.out.println(answer1 + " : " + answer1.equals("213"));
    }

    public String getPermutation(int n, int k) {
        chosen = new boolean[n];
        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = i + 1;
        }
        findNthPermutation(array, 0, new int[1], k);

        return new ArrayList<>(permutation).stream()
                .map(String::valueOf)
                .collect(Collectors.joining(""));
    }

    private void findNthPermutation(int[] array, int upto, int[] count, int end){
        if(array.length == upto){
            count[0]++;
        } else {
            for(int i = 0; i < array.length; i++){
                if(chosen[i]) continue;

                permutation.push(array[i]);
                chosen[i] = true;

                findNthPermutation(array, upto + 1, count, end);

                if(count[0] < end) {
                    permutation.pop();
                    chosen[i] = false;
                }
            }
        }
    }
}
