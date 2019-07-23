/**
 * 
 */
package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author jal
 *
 */
public class MainThread {

	public static void main(String[] args) {
/*
		for (int i = 0; i < 5; i++) {
			Thread t = new Thread(new LiftOff());
			if (i % 2 == 0)
				t.setPriority(Thread.MAX_PRIORITY);
			else
				t.setPriority(Thread.NORM_PRIORITY);
			t.start();
		}*/

		ExecutorService exec = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 5; i++)
			exec.execute(new LiftOff(20));
		exec.shutdown();

		// Thread t = new Thread(new LiftOff(10));
		// t.start();
	}
}
