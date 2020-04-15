package com.czw.algorithms.concurrent;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: czw
 * @CreateTime: 2020-04-15 15:35
 * @UpdeteTime: 2020-04-15 15:35
 * @Description:
 */
public class ReadWriteLockDemo {
	private static Lock lock=new ReentrantLock();
	private static ReentrantReadWriteLock readWriteLock=
			new ReentrantReadWriteLock();
	private static Lock readLock=readWriteLock.readLock();
	private static Lock writeLock=readWriteLock.writeLock();
	private int value;
	public Object handleRead(Lock lock) throws InterruptedException {
		try{
			lock.lock();    //模拟读操作
			Thread.sleep(1000);//耗时
			return value;
		} finally {
			lock.unlock();
		}
	}
	public void handleWrite(Lock lock,int index) throws InterruptedException {
		try{
			lock.lock(); //模拟写操作
			Thread.sleep(1000);
			value=index;
		}finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		final ReadWriteLockDemo demo=new ReadWriteLockDemo();
		Runnable readRun=()->{
			try{
				//demo.handleRead(readLock);
				demo.handleRead(lock);
			}catch (InterruptedException e){
				e.printStackTrace();
			}
		};
		Runnable writeRun=()->{
			try{
				//demo.handleWrite(writeLock,new Random().nextInt());
				demo.handleWrite(lock,new Random().nextInt());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		for (int i=0;i<18;i++)
			new Thread(readRun).start();
		for (int i=18;i<20;i++)
			new Thread(writeRun).start();
	}
}
