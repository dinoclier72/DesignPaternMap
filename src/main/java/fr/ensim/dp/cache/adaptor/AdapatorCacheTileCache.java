package fr.ensim.dp.cache.adaptor;

import fr.ensim.dp.cache.ICache;
import org.jdesktop.swingx.mapviewer.TileCache;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

public class AdapatorCacheTileCache extends TileCache {
    ICache cache;
    public AdapatorCacheTileCache(ICache cache){
        this.cache = cache;
    }

    public BufferedImage get(URI key){
        byte[] buf = cache.retreive(String.valueOf(key.hashCode()));
        InputStream is = new ByteArrayInputStream(buf);
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return bi;
    }

    public void put (URI key,byte[] bimg,BufferedImage img){
        cache.add(String.valueOf(key.hashCode()),bimg);
    }
}
