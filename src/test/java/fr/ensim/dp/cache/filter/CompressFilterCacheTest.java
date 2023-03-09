package fr.ensim.dp.cache.filter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompressFilterCacheTest {

    @Test
    void doAdd() {
        byte[] b = {1, 2, 3};
        CompressFilterCache filter = new CompressFilterCache();
        assertArrayEquals(b, filter.doRetreive("oui", filter.doAdd("oui", b)));
    }
}