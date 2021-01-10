package arraysAndStrings;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacter {

    public static void main(String[] args) {

        String input = "pwwkew";
        int ans =  getLongestSlidingWindow(input);

        System.out.println(ans);
    }

    private static int getLongestSlidingWindow(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;

    }
}
