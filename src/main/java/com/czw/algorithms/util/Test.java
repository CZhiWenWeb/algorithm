package com.czw.algorithms.util;


import com.sun.net.httpserver.HttpServer;

/**
 * @Author: czw
 * @CreateTime: 2019-11-19 17:18
 * @UpdeteTime: 2019-11-19 17:18
 * @Description:
 */
public class Test{

	private static int calculateSize(int numElements) {
		int initialCapacity = 8;
		// Find the best power of two to hold elements.
		// Tests "<=" because arrays aren't kept full.
		if (numElements >= initialCapacity) {
			initialCapacity = numElements;
			initialCapacity |= (initialCapacity >>> 1);
			initialCapacity |= (initialCapacity >>> 2);
			initialCapacity |= (initialCapacity >>> 4);
			initialCapacity |= (initialCapacity >>> 8);
			initialCapacity |= (initialCapacity >>> 16);
			initialCapacity++;

			if (initialCapacity < 0)   // Too many elements, must back off
				initialCapacity >>>= 1;// Good luck allocating 2 ^ 30 elements
		}
		return initialCapacity;
	}

	public boolean hasGroupsSizeX(int[] deck) {
		int[] temp = new int[10001];
		for (int d : deck)
			temp[d]++;

		int first = 0, last;
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] != 0) {
				first = temp[i];
				for (int j = i + 1; j < temp.length; j++) {
					if (first==1||temp[j]==1){
						return false;
					}else if (temp[j] != 0) {
						last=temp[j];
						int rem=first%last;
						while (rem != 0) {
							first=last;
							last=rem;
							rem=first%last;
						}
						first=last;
					}
				}
				break;
			}
		}
		return first!=1;
	}

	public static void main(String[] args) {
		Test t = new Test();
	}

}
