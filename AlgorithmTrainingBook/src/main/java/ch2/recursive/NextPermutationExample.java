package ch2.recursive;

import java.util.Arrays;

public class NextPermutationExample {

    public static void main(String[] args) {
        int[] array = {1,3,2};
        int[] array2 = {1,2,3};
        int[] array3 = {3,2,1};
        int[] array4 = {1,1,5};
        int[] array5 = {2,1,3};
        int[] array6 = {2,3,1};
        int[] array7 = {1,5,8,4,7,6,5,3,1};

        NextPermutationExample ex = new NextPermutationExample();
        ex.nextPermutation(array);
        ex.nextPermutation(array2);
        ex.nextPermutation(array3);
        ex.nextPermutation(array4);
        ex.nextPermutation(array5);
        ex.nextPermutation(array6);
        ex.nextPermutation(array7);
        System.out.println(Arrays.toString(array)  + " = " + Arrays.toString(array).equals("[2, 1, 3]"));
        System.out.println(Arrays.toString(array2) + " = " + Arrays.toString(array2).equals("[1, 3, 2]"));
        System.out.println(Arrays.toString(array3) + " =  " + Arrays.toString(array3).equals("[1, 2, 3]"));
        System.out.println(Arrays.toString(array4) + " = " + Arrays.toString(array4).equals("[1, 5, 1]"));
        System.out.println(Arrays.toString(array5) + " = " + Arrays.toString(array5).equals("[2, 3, 1]"));
        System.out.println(Arrays.toString(array6) + " = " + Arrays.toString(array6).equals("[3, 1, 2]"));
        System.out.println(Arrays.toString(array7) + " = " + Arrays.toString(array7).equals("[1, 5, 8, 5, 1, 3, 4, 6, 7]"));
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while (i > 0 && nums[i] <= nums[i - 1]) {
            i--;
        }
        i--;

        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
