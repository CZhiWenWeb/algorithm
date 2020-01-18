package com.czw.algorithms.第二章.排序;

import static com.czw.algorithms.util.Common.*;

/**
 * @Author: czw
 * @CreateTime: 2019-09-17 11:15
 * @UpdeteTime: 2019-09-17 11:15
 * @Description:
 */
public class Shell {
	public static void sort(Comparable[] a){
		int N=a.length;
		int h=1;
		while (h<N/3)
			h=3*h+1;
		while (h>=1){
		//	使用插入排序将数组变为h有序
			for (int i=h;i<N;i++){
				for (int j=i;j>=h&&less(a[j],a[j-h]);j-=h)
					exch(a,j,j-h);
			}
			h=h/3;
		}
	}

	public static void main(String[] args) {
		Comparable[] a=gennerateArray(0,20,15);
		out(a);
		sort(a);
		out(a);
	}
}
