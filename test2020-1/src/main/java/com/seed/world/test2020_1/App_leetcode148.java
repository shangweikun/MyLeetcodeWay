package com.seed.world.test2020_1;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	@Override
	public String toString() {
		return "ListNode [val=" + val + ", next=" + next + "]";
	}
	
	
}

public class App_leetcode148 {

	public ListNode sortList(ListNode head) {
		/**
		 * split List Period
		 */
		if (head == null || head.next == null) {
			return head;
		}
		ListNode slow = head;
		ListNode fast = head.next;
		while(fast!=null && fast.next !=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode middle = slow.next;
		slow.next = null;
		//递推算法
		ListNode left = sortList(head);
		ListNode right = sortList(middle);
		
		/**
		 * merger List period
		 */
		ListNode h =new ListNode(0);
		//记录头的开始，并返回结果
		ListNode resultNode = h;
		while(left != null && right != null) {
			if(left.val < right.val) {
				h.next = left;
				left = left.next;
//				h = h.next;
			}else{
				h.next = right;
				right = right.next;
//				h = h.next;
			}
			h = h.next;
		}
		h.next = left !=null?left:right;
		return resultNode.next;
	}

	public static void main(String args[]) {
		ListNode a1 = new ListNode(4);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(3);
		ListNode a4 = new ListNode(1);
		a1.next =a2;
		a2.next = a3;
		a3.next = a4;
		(new App_leetcode148()).sortList(a1);
		System.out.println(a1.toString());

	}
	
}
