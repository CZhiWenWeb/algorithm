package com.czw.algorithms.第二章.排序;

import com.czw.algorithms.util.Common;

import static com.czw.algorithms.util.Common.exch;
import static com.czw.algorithms.util.Common.gennerateArray;

/**
 * @Author: czw
 * @CreateTime: 2020-02-29 15:30
 * @UpdeteTime: 2020-02-29 15:30
 * @Description:选择其中最小值的优先队列
 */
public class MinPQ<Key extends Comparable<Key>> {
	//完全二叉树为层级结构，用数组存储
	private Key[] keys;
	//存储的数据个数
	private int N;

	public MinPQ() {
		//初始容量为10，keys[0]不使用
		this.keys = (Key[]) new Comparable[11];
		this.N = 0;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public void insert(Key key) {
		keys[++N] = key;
		swim(N);
		checkLength();
	}

	public Key delMin() {
		if (N == 0)
			return null;
		Key min = keys[1];
		exch(keys, 1, N--);
		keys[N + 1] = null;
		sink(1);
		checkLength();
		return min;
	}

	private void swim(int index) {
		while (index > 1 && Common.less(keys[index], keys[index / 2])) {
			Common.exch(keys, index, index / 2);
			index = index / 2;
		}
	}

	private void sink(int index) {
		while (2 * index <= N) {
			int j = 2 * index;
			if (j < N && Common.less(keys[j + 1], keys[j]))
				j++;
			if (!Common.less(keys[j], keys[index]))
				break;
			Common.exch(keys, j, index);
			index = j;
		}
	}

	private void checkLength() {
		if (keys.length - N == 1) {
			Key[] newKeys = (Key[]) new Comparable[1 + N * 2];
			if (keys.length - 1 >= 0)
				System.arraycopy(keys, 1, newKeys, 1, keys.length - 1);
			this.keys = newKeys;
		} else if (N > 10 && N == (keys.length - 1) / 4) {
			Key[] newKeys = (Key[]) new Comparable[1 + N * 2];
			System.arraycopy(keys, 1, newKeys, 1, keys.length - 1);
			this.keys = newKeys;
		}
	}

	public static void main(String[] args) {
		MinPQ minPQ = new MinPQ();
		Integer[] a = gennerateArray(1, 15, 15);
		for (Integer i : a
		) {
			minPQ.insert(i);
		}
		while (minPQ.N > 0) {
			System.out.println(minPQ.delMin());
		}
		System.out.println(minPQ.isEmpty());
	}
}
