package fr.ensim.dp.cache;

public class FactoryCache implements IFactoryCache {
	private FactoryCache() {
		// TODO Auto-generated constructor stub
	}
	
	private static FactoryCache singleton = new FactoryCache();
	
	public static FactoryCache getInstance() {
		return singleton;
	}

	@Override
	public ICache memoryCache() {
		// TODO Auto-generated method stub
		return MemoryCache.getInstance();
	}

	@Override
	public ICache diskCache(String type){
		// TOsDO Auto-generated method stub
		return DiskCache.getInstance(type);
	}

}
