package com.czw.algorithms.util;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: czw
 * @CreateTime: 2020-04-13 15:14
 * @UpdeteTime: 2020-04-13 15:14
 * @Description:
 */
public class VolatileTest {
	public static volatile int race = 0;

	public static synchronized void increase() {
		race++;
	}

	public static void main(String[] args) {
		//Thread[] threads = new Thread[2];
		//threads[0] = new Thread(() -> {
		//	for (int j = 0; j < 10000; j++)
		//		increase();
		//});
		//threads[0].start();
		//
		//threads[1] = new Thread(() -> {
		//	for (int j = 0; j < 10000; j++)
		//		increase();
		//});
		//threads[1].start();
		//
		//while (Thread.activeCount() > 1)
		//	Thread.yield();
		//System.out.println(race);
	}
}
