package fr.ensim.dp.cache;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import fr.ensim.dp.util.FileUtil;

public class DiskCache implements ICache {
	private DiskCache(String type) throws IOException {
		repertory = "./Maps/"+type+"/";
		Files.createDirectories(Paths.get(repertory));
		// repertory en file drectement --> file.mkdir() et FIles(file,key) pour le reste
	}
	
	private static HashMap<String, DiskCache> diskMaps = new HashMap<String, DiskCache>();
	
	public static DiskCache getInstance(String type) throws IOException {
		if(diskMaps.containsKey(type)) {
			return diskMaps.get(type);
		}
		diskMaps.put(type, new DiskCache(type));
		return diskMaps.get(type);
	}
	
	private String repertory;

	@Override
	public long size() {
		return FileUtil.dirLength(new File(repertory));
	}

	@Override
	public boolean add(String key, byte[] buf) {
		return FileUtil.copy(new ByteArrayInputStream(buf), new File(repertory+key));
	}

	@Override
	public byte[] retreive(String key) {
		try {
			return FileUtil.readFile(new File(repertory+key));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void clear() {
		FileUtil.deleteDirectory(new File(repertory));
	}

}
