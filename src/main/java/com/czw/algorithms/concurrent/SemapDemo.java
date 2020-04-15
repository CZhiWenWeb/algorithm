package com.czw.algorithms.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author: czw
 * @CreateTime: 2020-04-15 15:04
 * @UpdeteTime: 2020-04-15 15:04
 * @Description:
 */
public class SemapDemo implements Runnable {
	final Semaphore semp = new Semaphore(5);

	@Override
	public void run() {
		try {
			semp.acquire();
			Thread.sleep(2000);
			System.out.println(Thread.currentThread().getId()+":done!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			semp.release();
		}
	}

	public static void main(String[] args) {
		ExecutorService exe= Executors.newFixedThreadPool(20);
		final SemapDemo demo=new SemapDemo();
		for (int i=0;i<20;i++)
			exe.submit(demo);
	}
}
