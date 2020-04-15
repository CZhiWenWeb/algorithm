package com.czw.algorithms.concurrent;

/**
 * @Author: czw
 * @CreateTime: 2020-04-14 16:55
 * @UpdeteTime: 2020-04-14 16:55
 * @Description:
 */
public class AccountingSync implements Runnable {
	static int i = 0;

	@Override
	public void run() {
		for (int j = 0; j < 1000000; j++)
			increase();
	}

	public void increase() {
		synchronized (AccountingSync.class) {
			int temp = i;
			temp++;
			i = temp;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new AccountingSync(), "t1");
		Thread t2 = new Thread(new AccountingSync(), "t2");
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(i);
	}
}
