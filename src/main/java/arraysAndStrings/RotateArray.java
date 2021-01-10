package arraysAndStrings;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5,6,7};
        int k = 2;

//        rotate(nums, k);

        rotateUsingExtraArray(nums, k);
        Arrays.stream(nums).forEach(x -> System.out.print(x));



    }

    public static void rotateUsingExtraArray(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
}
