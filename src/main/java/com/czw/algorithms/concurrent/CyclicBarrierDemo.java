package com.czw.algorithms.concurrent;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author: czw
 * @CreateTime: 2020-04-15 16:21
 * @UpdeteTime: 2020-04-15 16:21
 * @Description:
 */
public class CyclicBarrierDemo {
	public static class Soldier implements Runnable{
		private String soldier;
		private final CyclicBarrier cyclic;

		public Soldier(CyclicBarrier cyclic,String soldierName) {
			this.cyclic=cyclic;
			this.soldier=soldierName;
		}
		@Override
		public void run() {
			try{
				cyclic.await();
				doWork();
				cyclic.await();
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		void doWork(){
			try{
				Thread.sleep(Math.abs(new Random().nextInt()%10000));
			}catch (InterruptedException e){
				e.printStackTrace();
			}
			System.out.println(soldier+":任务完成");
		}
	}
	public static class BarrierRun implements Runnable{
		boolean flag;
		int N;
		public BarrierRun(boolean flag,int N){
			this.flag=flag;
			this.N=N;
		}
		@Override
		public void run() {
			if (flag){
				System.out.println("士兵["+N+"个任务完成]");
			}else {
				System.out.println("士兵["+N+"个集合]");
				flag=true;
			}
		}
	}

	public static void main(String[] args) {
		final int N=10;
		Thread[] allSoldier=new Thread[N];
		boolean flag=false;
		CyclicBarrier cyclic=new CyclicBarrier(N,new BarrierRun(flag,N));
		System.out.println("集合");
		for (int i=0;i<N;i++){
			System.out.println("士兵"+i);
			allSoldier[i]=new Thread(new Soldier(cyclic,"士兵"+i));
			allSoldier[i].start();
		}
	}
}
