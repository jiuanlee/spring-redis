/**
 * 
 */
package com.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Administrator
 *
 */
public class TaskWithResult implements Callable<String> {

	private String taskId;

	public TaskWithResult(int taskId) {
		this.taskId = "#Id" + taskId;
	}

	@Override
	public String call() throws Exception {
		return "Result of TaskWithResult " + taskId;
	}

	public static void main(String[] args) throws InterruptedException,
			ExecutionException {
		ExecutorService exec = Executors.newCachedThreadPool();
		List<Future<String>> results = new ArrayList<Future<String>>();

		for (int i = 0; i < 10; i++)
			results.add(exec.submit(new TaskWithResult(i)));

		for (Future<String> fs : results) {
			if (fs.isDone())
				System.out.println(fs.get());
		}
	}
}
