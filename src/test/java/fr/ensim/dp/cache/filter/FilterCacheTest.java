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
	static  String key;
	
	byte[] b = {1,2,3};
	@BeforeAll
	static void init() {
		key = "ivrlhjnawlsmlpxx";
		filter1 = new CountFilterCache();
		filter2 = new CompressFilterCache();
		filter3 = new LogFilterCache();
		filter4 = new EncryptFilterCache();
		filter1.setNext(filter4);
		filter4.setNext(filter2);
		filter2.setNext(filter3);
	}
	@Test
	void testChaine() {
		CompressFilterCache filter1 = new CompressFilterCache();
		EncryptFilterCache filter2 = new EncryptFilterCache();
		filter1.setNext(filter2);
		byte[] buf = filter1.doAdd(key, b);
		assertArrayEquals(b,filter1.doRetreive(key,buf));
	}

	@Test
	void testChaine2() {
		byte[] buf = filter1.doAdd(key, b);
		assertArrayEquals(b,filter1.doRetreive(key,buf));
	}
}
