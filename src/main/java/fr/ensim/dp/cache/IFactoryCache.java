package fr.ensim.dp.cache;

public interface IFactoryCache {
	ICache memoryCache();
	ICache diskCache(String type);
}
