package fr.ensim.dp.cache;


import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class MemoryCacheTest {
	static MemoryCache c;
	static byte [] b = {12,2 ,3};
	
	@BeforeAll
	public static void init() {
		c = MemoryCache.getInstance();
	}
	
	@AfterEach
	public void reinit() {
		c.clear();
	}

	@Test
	public void testSize() {
		c.add("oui", b);
		assertEquals(3,c.size());;
	}

	@Test
	public void testAll() {
		// cle
		// Size vaut0
		// byte [] b = {12,2 ,3} ,
		// add("key1", b)
		// Size vaut 3
		//retreive 
		assertEquals(c, MemoryCache.getInstance());
	}
	@Test
	public void testRetreive() {
		c.add("oui", b);
		assertArrayEquals(b,c.retreive("oui"));
	}

	@Test
	public void testClear() {
		c.clear();
		assertEquals(0, c.size());
	}

}
