package fr.ensim.dp.cache.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.ensim.dp.cache.FactoryCache;
import fr.ensim.dp.cache.ICache;
import fr.ensim.dp.cache.IFactoryCache;

public class LogFilterCache implements IFilterCache {
	Logger log = LogManager.getLogger();
	IFilterCache next = null;

	@Override
	public byte[] doAdd(String key, byte[] buf) {
		log.debug("ajout de donnee");
		if(next != null) {
			return next.doAdd(key, buf);
		}
		return buf;
	}

	@Override
	public byte[] doRetreive(String key, byte[] buf) {
		log.debug("recuperation de la donne");
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
