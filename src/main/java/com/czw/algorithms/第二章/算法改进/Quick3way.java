package com.czw.algorithms.第二章.算法改进;

import com.czw.algorithms.util.Common;
import com.czw.设计模式.命令模式.command.Command;

/**
 * @Author: czw
 * @CreateTime: 2020-02-27 14:07
 * @UpdeteTime: 2020-02-27 14:07
 * @Description:
 * 三向切分，将数组切分为小于，等于和大于切分元素的数组元素
 */
public class Quick3way {
	//cutoff to insertion sort
	private static final int CUTOFF=15;
	//do not instantiate
	private Quick3way(){}

	public static void sort(Comparable[] a){
		Common.shuffle(a);

		sort(a,0,a.length-1);
	}

	//quick the subarray a[lo..hi] using 3-way partitioning
	private static void sort(Comparable[] a,int lo,int hi){
		if (hi<=lo)
			return;
		int lt=lo,gt=hi;
		Comparable v=a[lo];
		int i=lo+1;
		//保证a[lo..lt-1]<v=a[lt..gt]<a[gt+1..hi]
		while (i<=gt){
			int cmp=a[i].compareTo(v);
		//a[i]小于v时，交换lt与i；此时左边小于v，继续由lt向右比较
			if (cmp<0)
				Common.exch(a,lt++,i++);
			//a[i]大于v时，交换gt与i；此时右边大于v，继续由gt向左比较
			else if (cmp>0)
				Common.exch(a,i,gt--);
			//a[i]等与v时，i向右移动
			else
				i++;
		}

		//左边>v，右边<v；所以当左右两边有序时，数组自然有序

		//大于15时继续quick切分,小数组使用insertion排序
		if (lo-(lt-1)>CUTOFF)
			sort(a,lo,lt-1);
		else
			insertion(a,lo,lt-1);
		if (gt+1-hi>CUTOFF)
			sort(a,gt+1,hi);
		else
			insertion(a,gt+1,hi);
	}

	private static void insertion(Comparable[] a,int lo,int hi){
		//左边第一位自然有序，从第二个开始插入
		for (int i=lo+1;i<=hi;i++){
			for (int j=i;j>lo&&Common.less(a[j],a[j-1]);j--){
				Common.exch(a,j,j-1);
			}
		}
	}
	public static void main(String[] args) {
		Comparable[] comparables=Common.gennerateArray(0,20,20);
		Common.out(comparables);
		sort(comparables);
		Common.out(comparables);
	}
}
