package fr.ensim.dp.cache;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FactoryCacheTest {
	static IFactoryCache factory;
	@BeforeAll
	static void init() {
		factory = FactoryCache.getInstance();
	}

	@Test
	void memoryCacheTest() {
		assertEquals(MemoryCache.getInstance(),factory.memoryCache());
	}

	@Test
	void diskCacheTest() {
		assertEquals(DiskCache.getInstance("test"),factory.diskCache("test"));
	}
}
