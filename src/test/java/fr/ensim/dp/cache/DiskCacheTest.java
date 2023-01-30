package fr.ensim.dp.cache;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class DiskCacheTest {
	static DiskCache d;
	static byte[] b = {1,12,3};
	@BeforeAll
	static void init() throws IOException {
		d = DiskCache.getInstance("test");
		//d = new DiskCache("test");
	}
	
	@Test
	void testAll() throws IOException {
		assertEquals(d, DiskCache.getInstance("test"));
		assertTrue(d.add("oui", b));
		assertEquals(3, d.size());
		assertTrue(Arrays.equals(b,d.retreive("oui")));
		d.clear();
		assertEquals(0, d.size());
	}
}
