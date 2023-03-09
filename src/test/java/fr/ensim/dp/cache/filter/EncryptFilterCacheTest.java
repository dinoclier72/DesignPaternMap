package fr.ensim.dp.cache.filter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EncryptFilterCacheTest {

    @Test
    void doAdd() {
        byte[] b = {1, 2, 3};
        String key = "yflsebvaseuqrdvm";
        EncryptFilterCache filter = new EncryptFilterCache();
        assertArrayEquals(b,filter.doRetreive(key,filter.doAdd(key,b)));
    }
}