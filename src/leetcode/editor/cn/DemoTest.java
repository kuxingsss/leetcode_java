package leetcode.editor.cn;

import java.util.*;

/**
 * @author
 * @creat2020-10-10-22:26
 */
public class DemoTest {
  public static void main(String[] args) {
    int[] nums = new int[]{2, 5, 8, 12, 19};
    System.out.println(Arrays.binarySearch(nums, 15));
    List<Integer> list = new ArrayList<>();
    list.add(3);
    list.add(3);
    list.add(4);
    list.sort(Comparator.reverseOrder());
    int[] num1 = new int[]{1, 3};
    int[] num2 = new int[]{4, 5};
    System.out.println(Arrays.binarySearch(nums, 5));
    PriorityQueue queue = new PriorityQueue<>();
    queue.offer(3);
    queue.offer(5);
    System.out.println(queue);
    System.out.println(queue.peek());
    String S = "123";
    int a = Integer.parseInt(String.valueOf(S.charAt(0)));
    System.out.println(a);
    String s = "012345";
    System.out.println(s.substring(1, 2));
//        System.out.println(Arrays.toString(nums));


//        int[][] arr={{1,4,5},{2,5,3},{1,2,3},{5,4,3},{1,4,3}};
//        //让数组按照这样的顺序排序：优先按第一个元素排，如果第一个元素相等，就按照第二个元素排，如果第二个元素也相等的话，就按照第三个元素排。都要升序。
//        Arrays.sort(arr, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if (o1[0]!=o2[0]){
//                    return o1[0]-o2[0];
//                }else {
//                    if (o1[1]!=o2[1]){
//                        return o1[1]-o2[1];
//                    }else {
//                        return o1[2]-o2[2];
//                    }
//                }
//            }
//        });


//        Map<Integer, Integer> intersection = new HashMap<>();
//        for (int num : nums) {
//            intersection.merge(num, 1, (oldValue, newValue) -> oldValue + newValue);
//            intersection.put(num, intersection.getOrDefault(num, 0) + 1);
//        }
//
//        System.out.println(intersection.get(3));

//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            int num = entry.getKey(), count = entry.getValue();

//
//        }
  }


}
