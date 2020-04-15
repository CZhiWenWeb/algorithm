package com.czw.algorithms.util;

import java.io.IOException;

/**
 * @Author: czw
 * @CreateTime: 2020-03-27 10:12
 * @UpdeteTime: 2020-03-27 10:12
 * @Description:
 */
public class Test2 {
	public static void createBusyThread(){
		Thread thread=new Thread(()->{
			while (true)
				;
		},"busyThread");
		thread.start();
	}
	public static void createLockThread(final Object lock){
		Thread thread=new Thread(()->{
			synchronized (lock){
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"lockThread");
	}

	public static void main(String[] args) throws InterruptedException, IOException {

		createBusyThread();
		Object obj=new Object();
		createLockThread(obj);
	}

	void exch(int i,int j,int[] num){
		if (i==j)
			return;
		num[i]=num[i]^num[j];
		num[j]=num[i]^num[j];
		num[i]=num[i]^num[j];
	}
	void exch2(int i,int j,int[] num){
		int a=num[i];
		num[i]=num[j];
		num[j]=a;
	}
}



