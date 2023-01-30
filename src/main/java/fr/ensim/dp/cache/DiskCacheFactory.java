package fr.ensim.dp.cache;

public class DiskCacheFactory implements IFactoryCache {
	private static DiskCacheFactory singleton = new DiskCacheFactory();
	
	private DiskCacheFactory() {
		
	}
	
	private static DiskCacheFactory getInstance() {
		return singleton;
	}

	@Override
	public ICache createCache() {
		return 
	}

}
