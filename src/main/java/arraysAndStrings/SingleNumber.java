package arraysAndStrings;

import java.util.HashMap;

public class SingleNumber {
    //Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

    public static void main(String[] args) {
        int[] in = {4,1,2,1,2};

//        int ans = singleNumber(in);
        int ans = singleNumberUsingBitManipulation(in);
        System.out.println(ans);

    }

    static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hash_table = new HashMap<>();

        for (int i : nums) {
            hash_table.put(i, hash_table.getOrDefault(i, 0) + 1);
        }
        for (int i : nums) {
            if (hash_table.get(i) == 1) {
                return i;
            }
        }
        return 0;
    }

    static int singleNumberUsingBitManipulation(int[] nums) {
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }
}
