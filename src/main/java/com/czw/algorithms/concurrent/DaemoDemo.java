package com.czw.algorithms.concurrent;

/**
 * @Author: czw
 * @CreateTime: 2020-04-14 16:36
 * @UpdeteTime: 2020-04-14 16:36
 * @Description:
 */
public class DaemoDemo {
	private static class DaemonT extends Thread{
		@Override
		public void run(){
			while (true){
				System.out.println("I am alive");
				try{
					Thread.sleep(100);
				}catch (InterruptedException e){

				}
			}
		}
	}
	public static void main(String[] args) throws Exception{
		Thread t=new DaemonT();
		t.setDaemon(true);
		t.start();
		Thread.sleep(2000);
	}
}
