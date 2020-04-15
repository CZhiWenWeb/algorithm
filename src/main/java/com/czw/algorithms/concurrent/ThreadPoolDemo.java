package com.czw.algorithms.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: czw
 * @CreateTime: 2020-04-15 16:54
 * @UpdeteTime: 2020-04-15 16:54
 * @Description:
 */
public class ThreadPoolDemo {
	public static class MyTask implements Runnable{

		@Override
		public void run() {
			System.out.println(System.currentTimeMillis()+"Thread ID:"+
					Thread.currentThread().getId());
			try{
				Thread.sleep(10);
			}catch (InterruptedException e){
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		MyTask task=new MyTask();
		ExecutorService es= Executors.newFixedThreadPool(3);
		for (int i=0;i<10;i++)
			es.submit(task);
	}
}
