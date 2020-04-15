package com.czw.algorithms.concurrent;

import com.czw.algorithms.util.In;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: czw
 * @CreateTime: 2020-04-15 10:20
 * @UpdeteTime: 2020-04-15 10:20
 * @Description:
 */
public class IntLock implements Runnable{
	public static final ReentrantLock lock1=new ReentrantLock();
	public static final ReentrantLock lock2=new ReentrantLock();
	int lock;

	public IntLock(int lock){
		this.lock=lock;
	}

	@Override
	public void run() {
		if (lock==1){
			synchronized (lock1){
				try {
					Thread.sleep(500);
					synchronized (lock2){
						System.out.println("111111");
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}else {
			synchronized (lock2){
				try {
					Thread.sleep(500);
					synchronized (lock1){
						System.out.println("22222");
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		//try{
		//	if (lock==1){
		//		lock1.lockInterruptibly();
		//		Thread.sleep(500);
		//		lock2.lockInterruptibly();
		//	}else {
		//		lock2.lockInterruptibly();
		//		Thread.sleep(500);
		//		lock1.lockInterruptibly();
		//	}
		//}catch (InterruptedException e){
		//	e.printStackTrace();
		//}finally {
		//	if (lock1.isHeldByCurrentThread())
		//		lock1.unlock();
		//	if (lock2.isHeldByCurrentThread())
		//		lock2.unlock();
		//	System.out.println(Thread.currentThread().getId()+":线程退出");
		//}
	}

	public static void main(String[] args) throws InterruptedException {
		IntLock r1=new IntLock(1);
		IntLock r2=new IntLock(2);
		Thread t1=new Thread(r1);
		Thread t2=new Thread(r2);
		t1.start();t2.start();
		Thread.sleep(1000);
		t2.interrupt();
	}
}
