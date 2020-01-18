package com.czw.algorithms.第二章.排序;


import static com.czw.algorithms.util.Common.*;

/**
 * @Author: czw
 * @CreateTime: 2019-09-17 13:43
 * @UpdeteTime: 2019-09-17 13:43
 * @Description:
 */
public class MergeBU {
	//辅助数组
	private static Comparable[] aux;

	public static void sort(Comparable[] a) {
		int n = a.length;
		aux = new Comparable[n];
		//len子数组长度
		for (int len = 1; len < n; len *= 2) {
			//lo子数组索引
			for (int lo = 0; lo < n-len; lo += len+len) {
				int mid  = lo+len-1;
				int hi = Math.min(lo+len+len-1, n-1);
				merge(a, aux, lo, mid, hi);
			}
		}
		assert isSorted(a);
	}

	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {

		// copy to aux[]
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}

		// merge back to a[]
		int i = lo, j = mid+1;
		for (int k = lo; k <= hi; k++) {
			if      (i > mid)              a[k] = aux[j++];  // this copying is unneccessary
			else if (j > hi)               a[k] = aux[i++];
			else if (less(aux[j], aux[i])) a[k] = aux[j++];
			else                           a[k] = aux[i++];
		}

	}

	public static void main(String[] args) {
		Comparable[] a=gennerateArray(0,20,15);
		out(a);
		sort(a);
		out(a);
	}
}
