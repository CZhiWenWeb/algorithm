package com.czw.algorithms.concurrent;

import java.util.Vector;

/**
 * @Author: czw
 * @CreateTime: 2020-04-14 16:45
 * @UpdeteTime: 2020-04-14 16:45
 * @Description:
 */
public class PriorityDemo {
	public static class HightPriority extends Thread{
		static int count=0;
		@Override
		public void run(){
			while (true){
				synchronized (PriorityDemo.class){
					count++;
					if (count>100000){
						System.out.println("H complete");
						break;
					}
				}
			}
		}
	}
	public static class LowPriority extends Thread{
		static int count=0;
		@Override
		public void run(){
			while (true){
				synchronized (PriorityDemo.class){
					count++;
					if (count>100000000){
						System.out.println("L complete");
						break;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException{
		Thread h=new HightPriority();
		Thread l=new LowPriority();
		h.setPriority(Thread.MAX_PRIORITY);
		l.setPriority(Thread.MIN_PRIORITY);
		l.start();
		h.start();
	}
}
