package com.medSoft.util;

//Java program to demonstrate the creation of Encryption and Decryption with Java AES

import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;

class EncryptionUtil {

	@Value("${secret.key}")
	private String secretKey;

	@Value("${secret.salt}")
	private String salt;
	
	private final byte[] iv = { 'M','Y','S','E','C','R','E','T','S','P','E','C' };

	public String encrypt(String strToEncrypt) {
		try {
			IvParameterSpec ivspec = new IvParameterSpec(iv);
			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
			KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), salt.getBytes(), 65536, 256);
			SecretKey tmp = factory.generateSecret(spec);
			SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
			return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8)));
		} catch (Exception e) {
			System.out.println("Error while encrypting: " + e.toString());
		}
		return null;
	}

	public String decrypt(String strToDecrypt) {
		try {
			
			IvParameterSpec ivspec = new IvParameterSpec(iv);
			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
			KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), salt.getBytes(), 65536, 256);
			SecretKey tmp = factory.generateSecret(spec);
			SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
			return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
		} catch (Exception e) {
			System.out.println("Error while decrypting: " + e.toString());
		}
		return null;
	}
	
//	public static void main(String[] args) {
//		EncryptionUtil encryptionUtil = new EncryptionUtil();
//		String encrypt = encryptionUtil.encrypt("Welcome123");
//		System.out.println("Encryption:"+encrypt);
//		
//		String decrypt = encryptionUtil.decrypt(encrypt);
//		System.out.println("Decryption:"+decrypt);
//		
//		
//	}
	
}