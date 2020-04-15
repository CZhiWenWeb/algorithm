package com.czw.algorithms.concurrent;

/**
 * @Author: czw
 * @CreateTime: 2020-04-15 09:56
 * @UpdeteTime: 2020-04-15 09:56
 * @Description:
 */
public class BadLockOnInteger {
	static Integer i=0;
	void add(){
		i++;
	}

	public static void main(String[] args) {

	}
}
