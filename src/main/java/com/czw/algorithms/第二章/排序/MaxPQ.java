package com.czw.algorithms.第二章.排序;


import static com.czw.algorithms.util.Common.*;

/**
 * @Author: czw
 * @CreateTime: 2019-09-24 10:20
 * @UpdeteTime: 2019-09-24 10:20
 * @Description:优先队列的意义在于总数据量过大无法排序时，去选择其中的最大（最小）元素
 */
public class MaxPQ<Key extends Comparable<Key>> {
	//基于堆的完全二叉树
	private Key[] pq;
	//存储与pq[1..N]中，pq[0]没有使用
	private int N=0;
	public MaxPQ(int maxN){
		pq= (Key[]) new Comparable[maxN+1];
	}
	public boolean isEmpty(){
		return N==0;
	}
	public int size(){
		return N;
	}
	public void insert(Key v){
		pq[++N]=v;
		swim(N);
	}
	public Key deleteMax(){
		// 最大元素为[1]，[0]不使用,用分式求父节点，0不方便计算
		Key max=pq[1];
		// 交换首尾，然后将N减小1
		exch(pq,1,N--);
		// 去除尾部元素，key的长度减1
		pq[N+1]=null;
		// 下沉
		sink(1);
		return max;
	}
	// 上浮
	private void swim(int k){
		while (k>1&&less(pq[k/2],pq[k])){
			exch(pq,k/2,k);
			k=k/2;
		}
	}
	// 下沉
	private void sink(int k){
		while (2*k<=N){
			int j=2*k;
			if (j<N&&less(pq[j],pq[j+1]))
				j++;
			if (!less(pq[k],pq[j]))
				break;
			exch(pq,k,j);
			k=j;
		}
	}

	public static void main(String[] args) {
		MaxPQ maxPQ=new MaxPQ(11);
		Integer[] a=gennerateArray(1,15,10);
		for (Integer i:a
		     ) {
			maxPQ.insert(i);
		}
		while (maxPQ.N>0){
			System.out.println(maxPQ.deleteMax());
		}
	}
}
