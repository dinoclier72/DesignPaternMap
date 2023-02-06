package fr.ensim.dp.cache;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import fr.ensim.dp.cache.filter.IFilterCache;
import fr.ensim.dp.util.FileUtil;

class DiskCache implements ICache {
	private DiskCache(String type){
		repertory = "./Maps/"+type+"/";
		try {
			Files.createDirectories(Paths.get(repertory));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// repertory en file drectement --> file.mkdir() et FIles(file,key) pour le reste
	}
	
	private static HashMap<String, DiskCache> diskMaps = new HashMap<String, DiskCache>();
	
	public static DiskCache getInstance(String type){
		if(diskMaps.containsKey(type)) {
			return diskMaps.get(type);
		}
		diskMaps.put(type, new DiskCache(type));
		return diskMaps.get(type);
	}
	
	private String repertory;
	private IFilterCache filter = null;

	@Override
	public long size() {
		return FileUtil.dirLength(new File(repertory));
	}

	@Override
	public boolean add(String key, byte[] buf) {
		if(filter != null) {
			filter.doAdd(key, buf);
		}
		return FileUtil.copy(new ByteArrayInputStream(buf), new File(repertory+key));
	}

	@Override
	public byte[] retreive(String key) {
		byte[] buf;
		try {
			buf =  FileUtil.readFile(new File(repertory+key));
			if(filter != null) {
				filter.doRetreive(key, buf);
			}
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

	@Override
	public void setFilterCache(IFilterCache filter) {
		// TODO Auto-generated method stub
		this.filter  = filter;
	}

}
