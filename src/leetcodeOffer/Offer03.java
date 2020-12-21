package leetcodeOffer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author
 * @creat2020-11-06-23:36
 */
public class Offer03 {
    public static void main(String[] args) {

    }

    class Solution {
        public int findRepeatNumber(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                if (set.contains(num))
                    return num;
                set.add(num);
            }
            return -1;
        }
    }
}
