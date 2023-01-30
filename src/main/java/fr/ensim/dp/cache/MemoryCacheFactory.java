package fr.ensim.dp.cache;

public class MemoryCacheFactory implements IFactoryCache {
	private static MemoryCacheFactory singleton = new MemoryCacheFactory();
	
	private MemoryCacheFactory() {
		
	}
	
	private static MemoryCacheFactory getInstance() {
		return singleton;
	}

	@Override
	public ICache createCache() {
		return MemoryCache.getInstance();
	}

}
