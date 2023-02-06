package fr.ensim.dp.cache;

import java.util.HashMap;
import java.util.Map;

import fr.ensim.dp.cache.filter.IFilterCache;

class MemoryCache implements ICache {
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
	private IFilterCache filter = null;

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
		if(filter != null) {
			filter.doAdd(key, buf);
		}
		return (stockage.put(key, buf) != null);
	}

	@Override
	public byte[] retreive(String key) {
		byte[] buf = stockage.get(key);
		if(filter != null) {
			filter.doRetreive(key, buf);
		}
		return buf;
	}

	@Override
	public void clear() {
		stockage.clear();
	}

	@Override
	public void setFilterCache(IFilterCache filter) {
		// TODO Auto-generated method stub
		this.filter = filter;
	}

}
