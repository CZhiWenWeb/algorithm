package com.czw.algorithms.concurrent;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: czw
 * @CreateTime: 2020-04-15 09:15
 * @UpdeteTime: 2020-04-15 09:15
 * @Description:
 */
public class HashMapMultiThread {
	static Map<Integer,String> map=new HashMap<>();
	public static class AddThread implements Runnable{
		int start=0;
		public AddThread(int start){
			this.start=start;
		}
		@Override
		public void run() {
			for (int i=start;i<100000;i+=2){
				map.put(i,Integer.toBinaryString(i));
			}
		}
	}

	public static void main(String[] args) throws InterruptedException{
		Thread t1=new Thread(new HashMapMultiThread.AddThread(0),"t1");
		Thread t2=new Thread(new HashMapMultiThread.AddThread(1),"t2");
		t1.start();t2.start();
		t1.join();t2.join();
		System.out.println(map.size());
	}
}
