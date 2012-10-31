package com.otv;

import org.apache.log4j.Logger;

import com.otv.listener.UserMapListener;
import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;

/**
 * @author onlinetechvision.com
 * @since 9 Oct 2011
 * @version 1.0.0
 *
 */
public class TestCache {
	
	private static Logger log = Logger.getLogger(TestCache.class);
	private static TestCache instance = null;
	private NamedCache cache = null;	
	private static final String USER_MAP = "user-map";
	private static final long LOCK_TIMEOUT = -1;
	
	public TestCache() {
		setCache(CacheFactory.getCache(USER_MAP));
		getCache().addMapListener(new UserMapListener());		
	}
	
	public static TestCache getInstance() {
		if(instance == null) {
			instance = new TestCache();
		}
		return instance;
	}

	public static void setInstance(TestCache instance) {
		TestCache.instance = instance;
	}

	public NamedCache getCache() {
		return cache;
	}

	public void setCache(NamedCache cache) {
		this.cache = cache;
	}
	
	public void addToCache(Object key, Object value) {
		// key is locked
		getCache().lock(key, LOCK_TIMEOUT);
		try {
			// application logic
			getCache().put(key, value);
		} finally {
			// key is unlocked
			getCache().unlock(key);
		}
	}

	public void deleteFromCache(Object key) {
		// key is locked
		getCache().lock(key, LOCK_TIMEOUT);
		try {
			// application logic
			getCache().remove(key);
		} finally {
			// key is unlocked
			getCache().unlock(key);
		}
	}		
}
