package leetcodeOffer;

/**
 * @author
 * @creat2020-11-07-12:49
 */
public class Offer05 {
    public static void main(String[] args) {
        Solution solution = new Offer05().new Solution();
        System.out.println(solution.replaceSpace("We are happy."));
    }
    class Solution {
        public String replaceSpace(String s) {
            return s.replaceAll(" ", "%20");
        }
    }
}
