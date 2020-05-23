package com.seed.world.test2020_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App_QuickSort {

	public static void main(String args[]) {

		/*
		 * String[] a = {"1","3","8","5","2","0"}; String[] b;
		 * 
		 * List<String> target = new ArrayList<String>(Arrays.asList(a)); a =
		 * target.toArray(new String[0]);
		 */
		int[] a = { 1, 2, 1, 2, 1, 2, 2 };
		List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());
		a = list.stream().mapToInt(Integer::valueOf).toArray();
		System.out.println(list);
		QuickSort(list);
		a = list.stream().mapToInt(Integer::valueOf).toArray();
		System.out.println(list);
		for (int element : a) {
			System.out.println(element);
		}
	}

	private static void QuickSort(List<Integer> list) {
		/**
		 * @author Administrator ----------------- 单list处理 Begin
		 *         -------------------------
		 */
		if (list.size() == 1 || list.isEmpty())
			return;
		// 寻找中间点point
		int point = (int) (Math.random() * (double) list.size());
		System.out.print("point is :");
		System.out.println(point);
		List<Integer> tmp1 = new ArrayList<Integer>();
		List<Integer> tmp2 = new ArrayList<Integer>();
		// error 错误的将=号加入，导致point错误的加入队列中
		//写错了，这个位置没有等于号会有问题，有相等的数字死循环
		for (Integer one : list) {
			if (one < list.get(point)) {
				tmp1.add(one);
			} else if (one > list.get(point)) {
				tmp2.add(one);
			}
		}
		tmp1.add(list.get(point));

		/**
		 * ----------------- 单list处理 End -------------------------
		 */

		QuickSort(tmp1);
		QuickSort(tmp2);
		list.clear();
		list.addAll(tmp1);
		list.addAll(tmp2);
	}
}
