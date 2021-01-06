//给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values
//[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。 
//
// 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj =
// ? 的结果作为答案。 
//
// 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。 
//
// 
//
// 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"]
//,["b","a"],["a","e"],["a","a"],["x","x"]]
//输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
//解释：
//条件：a / b = 2.0, b / c = 3.0
//问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
//结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
// 
//
// 示例 2： 
//
// 
//输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], quer
//ies = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
//输出：[3.75000,0.40000,5.00000,0.20000]
// 
//
// 示例 3： 
//
// 
//输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a
//","c"],["x","y"]]
//输出：[0.50000,2.00000,-1.00000,-1.00000]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= equations.length <= 20 
// equations[i].length == 2 
// 1 <= Ai.length, Bi.length <= 5 
// values.length == equations.length 
// 0.0 < values[i] <= 20.0 
// 1 <= queries.length <= 20 
// queries[i].length == 2 
// 1 <= Cj.length, Dj.length <= 5 
// Ai, Bi, Cj, Dj 由小写英文字母与数字组成 
// 
// Related Topics 并查集 图 
// 👍 377 👎 0

package leetcode.editor.cn;

import java.util.*;

//Java：除法求值
public class P399EvaluateDivision {
  public static void main(String[] args) {
    Solution solution = new P399EvaluateDivision().new Solution();
    // TO TEST
    System.out.println();
  }

  //leetcode submit region begin(Prohibit modification and deletion)
// 定义邻接节点类
  class Node {
    // 邻接节点代表的字符串
    public String id;
    // 到达邻接节点所需的倍数
    public double num;

    public Node(String i, double n) {
      id = i;
      num = n;
    }
  }

  class Solution {
    // 构造一个map用于存储图
    Map<String, List<Node>> map;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
      int n = equations.size();
      map = new HashMap<>();
      double[] res = new double[queries.size()];

      // 将节点都放到图中
      for (int i = 0; i < n; i++) {
        // 获取被除数和除数的节点名称
        String dividend = equations.get(i).get(0);
        String divisor = equations.get(i).get(1);

        // 如果map中不包含某个节点的字符串，那就添加一个键值对
        if (!map.containsKey(dividend)) {
          map.put(dividend, new ArrayList<>());
        }
        if (!map.containsKey(divisor)) {
          map.put(divisor, new ArrayList<>());
        }
        // 除数和被除数都要放进去，这是一个有向图
        // 除数和被除数的倍数值是倒数关系的
        map.get(dividend).add(new Node(divisor, values[i]));
        map.get(divisor).add(new Node(dividend, 1 / values[i]));
      }

      int cnt = 0;
      // 遍历问题
      for (List<String> q : queries) {
        // 深搜，初始倍数就是1
        res[cnt] = dfs(q.get(0), q.get(1), 1.0, new HashSet<>());
        cnt++;
      }

      return res;
    }

    // 深搜其中参数cur表示当前节点，dest表示目标节点，knerl表示之前计算的倍数，set保存已经走过的节点
    private double dfs(String cur, String dest, double knerl, Set<String> set) {
      // 如果map不包含当前的节点或者已经走过当前节点了，说明这条路不会产生答案
      if (!map.containsKey(cur) || set.contains(cur)) {
        return -1.0;
      }
      // 走到了终点，那就返回已经计算了的倍数
      if (cur.equals(dest)) return knerl;
      // 集合中添加当前走过的节点，防止绕圈
      set.add(cur);

      // 遍历当前节点的邻接节点
      for (Node node : map.get(cur)) {
        // 继续深搜，倍数需要乘上下个一个节点的倍数
        double temp = dfs(node.id, dest, knerl * node.num, set);
        // 如果搜到了答案，就直接返回答案
        if (temp != -1.0) return temp;
      }

      // 没有搜到答案，返回-1
      return -1.0;
    }
  }
//leetcode submit region end(Prohibit modification and deletion)

}