package fr.ensim.dp.cache;

import java.util.HashMap;
import java.util.Map;

public class MemoryCache implements ICache {
	private MemoryCache() {
		
	}
	
	private static MemoryCache singleton;
	
	public static MemoryCache getInstance() {
		if(singleton == null) {
			synchronized (MemoryCache.class) {
				if(singleton == null) {
					singleton = new MemoryCache();
				}
			}
		}
		return singleton;
	}
	
	private HashMap<String, byte[]> stockage = new HashMap<String,byte[]>();

	@Override
	public long size() {
		long size = 0;
		for(Map.Entry<String, byte[]> entry : stockage.entrySet()) {
			size += entry.getValue().length;
		}
		return size;//stockage.values().stream().mapToLong(v -> v.length).sum()
	}

	@Override
	public boolean add(String key, byte[] buf) {
		return (stockage.put(key, buf) != null);
	}

	@Override
	public byte[] retreive(String key) {
		return stockage.get(key);
	}

	@Override
	public void clear() {
		stockage.clear();
	}

}
