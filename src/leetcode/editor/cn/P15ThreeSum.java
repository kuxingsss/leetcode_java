//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2702 👎 0

package leetcode.editor.cn;

import sun.java2d.pipe.AAShapePipe;

import java.util.*;

//Java：三数之和
public class P15ThreeSum {
    public static void main(String[] args) {
        Solution solution = new P15ThreeSum().new Solution();
        // TO TEST
        List<List<Integer>> myList = new ArrayList<>();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        myList = solution.threeSum(nums);
        System.out.println("==================================");
        System.out.println(myList);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) {
                if (i >= 1 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int midIndex = i + 1, endIndex = nums.length - 1;
                while (endIndex > midIndex) {
                    if (nums[i] + nums[midIndex] + nums[endIndex] == 0) {
                        res.add(new ArrayList<>(Arrays.asList(nums[i], nums[midIndex], nums[endIndex])));
                        while (endIndex > midIndex && nums[endIndex] == nums[endIndex - 1]) {
                            endIndex--;
                        }
                        while (endIndex > midIndex && nums[midIndex] == nums[midIndex + 1]) {
                            midIndex++;
                        }
                        midIndex++;
                        endIndex--;
                    } else if (nums[i] + nums[midIndex] + nums[endIndex] > 0) {
                        endIndex--;
                    } else {
                        midIndex++;
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
//public List<List<Integer>> threeSum(int[] nums) {
//    HashSet<List<Integer>> resList = new HashSet<>();
//    Arrays.sort(nums);
//    for (int i = 0; i < nums.length - 2; i++) {
//        if (i >= 1 && nums[i] == nums[i - 1]) {
//            continue;
//        }
//        HashMap<Integer, Integer> myMap = new HashMap<>();
//        for (int x = i + 1; x < nums.length; x++) {
//            if (!myMap.containsKey(nums[x])) {
//                myMap.put(- nums[i] - nums[x], 1);
//            }
//            else {
//                resList.add(new ArrayList<>(Arrays.asList(nums[i], - nums[i] - nums[x], nums[x])));
//            }
//        }
//    }
//    return new ArrayList<>(resList);
//}
}