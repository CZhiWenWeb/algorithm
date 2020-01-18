package com.czw.algorithms.util;

import java.util.Random;

/**
 * @Author: czw
 * @CreateTime: 2019-09-17 10:04
 * @UpdeteTime: 2019-09-17 10:04
 * @Description:
 */
public class Common {

	private Common(){
	//	禁止实例化
	}

	//生成随机数组
	public static Integer[] gennerateArray(int min, int max, int len){
		Integer[] a=new Integer[len];
		Random random=new Random();
		for(int i=0;i<len;i++)
			a[i]=random.nextInt(max)%(max-min+1)+min;
		return a;
	}
	//输出数组
	public static void out(Comparable[] a){
		for (int i=0;i<a.length;i++)
			System.out.print(a[i]+"  ");
		System.out.println();
	}
	//比较Comparable，左边小于右边返回true
	public static boolean less(Comparable a,Comparable b){
		if (a.compareTo(b)<0)
			return true;
		else
			return false;
	}
	//交换位置
	public static void exch(Comparable[] a,int i,int j){
		Comparable t=a[i];
		a[i]=a[j];
		a[j]=t;
	}
	//是否升序
	public static boolean isSorted(Comparable[] a){
		for (int i=0;i<a.length-1;i++){
			if (less(a[i+1],a[i]))
				return false;
		}
		return true;
	}
	//洗牌
	public static void shuffle(Object[] a){
		Random random=new Random();
		int n=a.length;
		for (int i=0;i<n;i++){
			int r=i+random.nextInt(n-i);
			Object temp=a[i];
			a[i]=a[r];
			a[r]=temp;
		}
	}

	//public static void main(String[] args) {
	//	Comparable[] a=gennerateArray(0,20,15);
	//	out(a);
	//	shuffle(a);
	//	out(a);
	//}
}
