//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4] 
//
// 
//
// 说明： 
//
// 
// 输出结果中的每个元素一定是唯一的。 
// 我们可以不考虑输出结果的顺序。 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 256 👎 0

package leetcode.editor.cn;

import java.util.*;

//Java：两个数组的交集
public class P349IntersectionOfTwoArrays {
    public static void main(String[] args) {
        Solution solution = new P349IntersectionOfTwoArrays().new Solution();
        // TO TEST
        System.out.println();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> filter = new HashSet<>();
            Set<Integer> resSet = new HashSet<>();
            for (int num : nums1) {
                filter.add(num);
            }
            for (int num : nums2) {
                if (filter.contains(num)) resSet.add(num);
            }
            int[] res = new int[resSet.size()];

            int i = 0;
            for (int num : resSet) {
                res[i++] = num;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}