package com.seed.world.test2020_1;

import java.util.ArrayList;

public class App2 {

	public static class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}	
	}

	public static  ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> list = new ArrayList<>();
		addNode(list,listNode);
		
		return list;
	}

	private static void addNode(ArrayList<Integer> list, ListNode listNode) {
		if(listNode == null) return ;
		if(listNode.next == null) {
			list.add(listNode.val);
			return;
		}
		addNode(list,listNode.next);
		list.add(listNode.val);
	}
	
	public static void main(String[] args) {
		ListNode a = new ListNode(0);
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(6);
		ListNode a4 = new ListNode(4);
		ListNode a5 = new ListNode(5);
		a.next = a1;
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		for(Integer one : printListFromTailToHead(a)) {
			System.out.println(one);
		}
	}
}
