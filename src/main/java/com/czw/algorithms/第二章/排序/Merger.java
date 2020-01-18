package com.czw.algorithms.第二章.排序;

import static com.czw.algorithms.util.Common.*;

/**
 * @Author: czw
 * @CreateTime: 2019-09-17 09:11
 * @UpdeteTime: 2019-09-17 09:11
 * @Description:
 */
public class Merger {
	//辅助数组
	private static Comparable[] aux;

	public static void sort(Comparable[] a) {
		//一次性分配空间
		aux = new Comparable[a.length];
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		//	将数组a[lo,hi]排序
		if (hi <= lo)
			return;
		int mid = lo + (hi - lo) / 2;
		//将左边排序
		sort(a, lo, mid);
		//	将右边排序
		sort(a, mid + 1, hi);
		//	小数组插入
		//if (isSorted(a))
		if (hi - lo < 10) {
			insert(a, lo, hi);
		} else {
			//大数组归并
			merge(a, lo, mid, hi);
		}
	}

	public static void merge(Comparable[] a, int lo, int mid, int hi) {
		//将a[lo..mid]和a[mid+1..hi]归并
		int i = lo, j = mid + 1;
		//将a[lo..hi]复制到aux[lo..hi]
		for (int k = lo; k <= hi; k++)
			aux[k] = a[k];
		//归并回归到a[lo..hi]
		for (int k = lo; k <= hi; k++)
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (less(aux[j], aux[i]))
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
	}

	private static void insert(Comparable[] a, int lo, int hi) {
		int h=lo+1;
		for (int i=h;i<=hi;i++){
			for (int j=i;j>=h&&less(a[j],a[j-1]);j-=1)
				exch(a,j,j-1);
		}
	}

	public static void main(String[] args) {
		Comparable[] a = gennerateArray(0, 20, 30);
		out(a);
		sort(a);
		out(a);
		System.out.println(isSorted(a));
	}
}
