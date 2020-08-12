package cn.com.lacus.www;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC652 {

    /** 这时的2不算是子树
     *         1
     *        / \
     *       2   3
     *      /   / \
     *     2   2   4
     *        /
     *       4
     */

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {


        int t;
        Map<String, Integer> trees;
        Map<Integer, Integer> count;
        List<TreeNode> ans;

        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            t = 1;
            trees = new HashMap();
            count = new HashMap();
            ans = new ArrayList();
            lookup(root);
            return ans;
        }

        public int lookup(TreeNode node) {
            if (node == null) return 0;
            String serial = node.val + "," + lookup(node.left) + "," + lookup(node.right);
            int uid = trees.computeIfAbsent(serial, x -> t++);
            count.put(uid, count.getOrDefault(uid, 0) + 1);
            if (count.get(uid) == 2)
                ans.add(node);
            return uid;
        }
    }

    class subSolution extends Solution{

        @Override
        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            return super.findDuplicateSubtrees(root);
        }
    }
}
