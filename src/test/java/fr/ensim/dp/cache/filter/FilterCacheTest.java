package fr.ensim.dp.cache.filter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import fr.ensim.dp.cache.FactoryCache;
import fr.ensim.dp.cache.ICache;

class FilterCacheTest {
	static IFilterCache filter1;
	static IFilterCache filter2;
	static IFilterCache filter3;
	static IFilterCache filter4;
	static ICache cache;
	
	byte[] b = {1,2,3};
	@BeforeAll
	static void init() {
		filter1 = new CountFilterCache();
		filter2 = new CompressFilterCache();
		filter3 = new LogFilterCache();
		filter1.setNext(filter2);
		filter2.setNext(filter3);
		
		cache = FactoryCache.getInstance().memoryCache();
		cache.setFilterCache(filter1);
	}
	@Test
	void testChaine() {
		assertDoesNotThrow(() -> {cache.add("test", b);});
		assertEquals(1, ((CountFilterCache) filter1).getAddCount());
		assertTrue(Arrays.equals(b,cache.retreive("test")));
		assertEquals(1,((CountFilterCache) filter1).getRetrieveCount());
	}
}
