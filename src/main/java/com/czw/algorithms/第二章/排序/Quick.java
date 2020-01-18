package com.czw.algorithms.第二章.排序;

import com.czw.algorithms.util.Common;

/**
 * @Author: czw
 * @CreateTime: 2019-09-17 14:27
 * @UpdeteTime: 2019-09-17 14:27
 * @Description:
 */
public class Quick {
	public static void sort(Comparable[] a){
		Common.shuffle(a);
		sort(a,0,a.length-1);
	}



	private static void sort(Comparable[] a,int lo,int hi){
		if (hi<=lo)
			return;
		int j=partition(a,lo,hi);
		sort(a,lo,j-1);
		sort(a,j+1,hi);
	}

	private static int partition(Comparable[] a,int lo,int hi){
	//	将数组切分为a[lo..i-1],a[i],a[i+1..hi]
		int i=lo,j=hi+1;
		//切分元素
		Comparable v=a[lo];
		while (true){
		//	扫描左右，检查扫描是否结束并交换元素
			while (Common.less(a[++i],v)){
				if (i==hi)break;
			}
			while (Common.less(v,a[--j])){
				if (j==lo)break;
			}
			if (i>=j)break;
			Common.exch(a,i,j);
		}
		Common.exch(a,lo,j);
		return j;
	}

	public static void main(String[] args) {
		Comparable[] comparables=Common.gennerateArray(0,20,20);
		Common.out(comparables);
		sort(comparables);
		Common.out(comparables);
	}
}
