package fr.ensim.dp.cache.filter;

public class CountFilterCache implements IFilterCache {
	IFilterCache next;
	int addCount = 0;
	int retrieveCount = 0;

	@Override
	public byte[] doAdd(String key, byte[] buf) {
		addCount++;
		if(next != null) {
			return next.doAdd(key, buf);
		}
		return buf;
	}

	@Override
	public byte[] doRetreive(String key, byte[] buf) {
		if(next != null) {
			buf = next.doRetreive(key, buf);
		}
		retrieveCount++;
		return buf;
	}

	@Override
	public IFilterCache setNext(IFilterCache next) {
		this.next = next;
		return this.next;
	}

	public int getAddCount() {
		return addCount;
	}
	
	public int getRetrieveCount() {
		return retrieveCount;
	}
}
