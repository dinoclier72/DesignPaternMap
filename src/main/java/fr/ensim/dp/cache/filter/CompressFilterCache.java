package fr.ensim.dp.cache.filter;

import java.io.IOException;

import fr.ensim.dp.util.GzipUtil;

public class CompressFilterCache implements IFilterCache {
	IFilterCache next = null;
	
	public CompressFilterCache(){
	}
	
	@Override
	public byte[] doAdd(String key, byte[] buf) {
		try {
			buf = GzipUtil.compress(buf);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(next != null) {
			return next.doAdd(key, buf);
		}
		return buf;
	}

	@Override
	public byte[] doRetreive(String key, byte[] buf) {
		try {
			buf = GzipUtil.uncompress(buf);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(next != null) {
			return next.doRetreive(key, buf);
		}
		return buf;
	}

	@Override
	public IFilterCache setNext(IFilterCache next) {
		this.next = next;
		return this.next;
	}

}
