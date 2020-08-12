package cn.com.lacus.www;

import java.util.*;

public class LC652 {

    /**
     * 这时的2不算是子树
     * 1
     * / \
     * 2   3
     * /   / \
     * 2   2   4
     * /
     * 4
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

    class subSolution extends Solution {

        @Override
        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            if (root == null) return new ArrayList<>();
            int[] a = changeTree(root);

            int left_i,right_i;
            int left_j,right_j;
            for (int i = a.length-1; i > 0; i--) {
                for (int j = i -1 ; j > 0 ; j--) {
                    while (j < a.length && a[i] != a[j]) j++;
                    left_i = 2*i;right_i = left_i+1;
                    left_j = 2*j;right_j = left_j+1;

                }
            }
            return null;
        }

        private int[] changeTree(TreeNode root) {

            LinkedList<Object> a = new LinkedList<>();
            LinkedList<Integer> result = new LinkedList<>();
            TreeNode tmp;
            Integer tmpI;

            a.addLast(new Integer(1));
            a.addLast(root);
            result.add(0);

            while (a.size() != 0) {
                tmpI = (Integer) a.removeFirst();
                tmp = (TreeNode) a.removeFirst();
                if (tmp == null) {
                    if (tmpI == result.size()) result.add(-1);
                    else {
                        while (tmpI == result.size()) result.add(-1);
                    }
                } else {
                    a.addLast(new Integer(2 * tmpI));
                    a.addLast(tmp.left);
                    a.addLast(new Integer(2 * tmpI + 1));
                    a.addLast(tmp.right);
                    result.add(tmp.val);
                }
            }

            while (result.peekLast() == -1) result.removeLast();

            return result.stream().mapToInt(Integer::intValue).toArray();
        }

    }

    public static void main(String[] args) {
        LC652 App = new LC652();
        subSolution sol = App.new subSolution();
        TreeNode a = App.new TreeNode(1);
        TreeNode b = App.new TreeNode(0);
        TreeNode c = App.new TreeNode(2);
        TreeNode d = App.new TreeNode(0);
        TreeNode e = App.new TreeNode(3);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;

        Arrays.stream(sol.changeTree(a)).forEach(System.out::println);

    }
}
