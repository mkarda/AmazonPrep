package arraysAndStrings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static void main(String[] args) {

        int[] in = {1,2,3,1};
        boolean b = containsDuplicate(in);
        System.out.println(b);


    }

    static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }

    static boolean containsDuplicateUsingHashTable(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int x: nums) {
            if (set.contains(x)) return true;
            set.add(x);
        }
        return false;
    }


}
