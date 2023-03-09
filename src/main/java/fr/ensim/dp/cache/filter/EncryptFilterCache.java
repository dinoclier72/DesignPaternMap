package fr.ensim.dp.cache.filter;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class EncryptFilterCache implements IFilterCache {
	IFilterCache next = null;
	Cipher cipher;

	@Override
	public byte[] doAdd(String key, byte[] buf) {
		SecretKeySpec localKey = new SecretKeySpec(key.getBytes(),"AES");
		try {
			cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE,localKey);
			buf = cipher.doFinal(buf);
		} catch (InvalidKeyException e) {
			throw new RuntimeException(e);
		} catch (IllegalBlockSizeException e) {
			throw new RuntimeException(e);
		} catch (BadPaddingException e) {
			throw new RuntimeException(e);
		} catch (NoSuchPaddingException e) {
			throw new RuntimeException(e);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		if(next != null){
			return next.doAdd(key,buf);
		}
		return buf;
	}

	@Override
	public byte[] doRetreive(String key, byte[] buf) {
		if(next != null){
			buf = next.doRetreive(key,buf);
		}

		SecretKeySpec localKey = new SecretKeySpec(key.getBytes(),"AES");
		try {
			cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE,localKey);
			buf =  cipher.doFinal(buf);
		} catch (InvalidKeyException e) {
			throw new RuntimeException(e);
		} catch (IllegalBlockSizeException e) {
			throw new RuntimeException(e);
		} catch (BadPaddingException e) {
			throw new RuntimeException(e);
		} catch (NoSuchPaddingException e) {
			throw new RuntimeException(e);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		return buf;
	}

	@Override
	public IFilterCache setNext(IFilterCache next) {
		this.next = next;
		return next;
	}

}
