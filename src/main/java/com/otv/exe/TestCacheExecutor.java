package com.otv.exe;

import java.util.Iterator;

import org.apache.log4j.Logger;

import com.otv.TestCache;
import com.otv.user.User;

/**
 * @author onlinetechvision.com
 * @since 9 Oct 2011
 * @version 1.0.0
 *
 */
public class TestCacheExecutor implements Runnable {
	
	private static Logger log = Logger.getLogger(TestCacheExecutor.class);
	
	public static void main(String[] args) {
		try {
			TestCacheExecutor testCacheExecutor = new TestCacheExecutor();
			while (true) {
				testCacheExecutor.run();
				Thread.sleep(10000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		execute();
	}
	
	public void execute() {
		//Entries which will be inserted via first member of the cluster so before the project is built 
		// in order to deploy first member of the cluster, this code block should be opened...
		User firstUser = new User("Bruce", "Willis");
		User secondUser = new User("Clint", "Eastwood");
		TestCache.getInstance().addToCache("user1", firstUser);
		TestCache.getInstance().addToCache("user2", secondUser);		

		//Entries which will be inserted via second member of the cluster so before the project is built 
		// in order to deploy second member of the cluster, this code block should be opened...
//		User firstUser = new User("Anna", "Kornikova");
//		User secondUser = new User("Natalie", "Portman");
//		TestCache.getInstance().addToCache("user3", firstUser);
//		TestCache.getInstance().addToCache("user4", secondUser);
		
		Iterator it = TestCache.getInstance().getCache().values().iterator();
		log.debug("***************************************");
		while(it.hasNext()){
			User user = (User)it.next();
			log.debug("1. Cache Content : "+user);
		}
		log.debug("***************************************");
	}
	
}
