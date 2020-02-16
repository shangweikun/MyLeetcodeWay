package com.seed.world.test2020_1;

import java.util.Arrays;

public class App3_ForRebuildBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
         if(pre.length == 0 || in.length ==0) {
        	return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        
        for(int i = 0 ;i<in.length;i++) {
        	if(in[i] == pre[0]) {
        		root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in, 0, i));
        		//pre.length-in.length+i+1 == i+1
        		root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,pre.length-in.length+i+1,pre.length),Arrays.copyOfRange(in, i+1, in.length));
        	}
        }
		
    	return root;
    }

	public static void main(String[] args) {

	}
}
