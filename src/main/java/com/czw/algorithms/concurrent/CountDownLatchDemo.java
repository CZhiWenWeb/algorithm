package com.czw.algorithms.concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: czw
 * @CreateTime: 2020-04-15 16:07
 * @UpdeteTime: 2020-04-15 16:07
 * @Description:
 */
public class CountDownLatchDemo implements Runnable{
	static final CountDownLatch end=new CountDownLatch(10);
	//表示需要10个线程完成任务后等待在CountDownLatch上的线程才能执行
	static final CountDownLatchDemo demo=new CountDownLatchDemo();
	@Override
	public void run() {
		try {
			//模拟检查任务
			Thread.sleep(new Random().nextInt(10)*1000);
			System.out.println("check complete");
			end.countDown();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec= Executors.newFixedThreadPool(10);
		for (int i=0;i<22;i++)
			exec.submit(demo);
		end.await();//等待检查
		System.out.println("Fire");
		exec.shutdown();
	}
}
