/**
 * 
 */
package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Administrator
 *
 */
public class ExecutorPool {

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		ExecutorService exec1 = Executors.newFixedThreadPool(5);

		for (int i = 0; i < 10; i++)
			exec1.execute(new LiftOff());
		exec1.shutdownNow();

	}
}
