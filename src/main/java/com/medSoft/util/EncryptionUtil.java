package com.medSoft.util;

//Java program to demonstrate the creation of Encryption and Decryption with Java AES

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
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

	private static final String AES = "AES";

	private static final String PBKDF2_WITH_HMAC_SHA256 = "PBKDF2WithHmacSHA256";

	private static final String AES_CBC_PKCS5PADDING = "AES/CBC/PKCS5Padding";

	@Value("${secret.key}")
	private String secretKey;

	@Value("${secret.salt}")
	private String salt;

	private final byte[] iv = { 'M', 'Y', 'S', 'E', 'C', 'R', 'E', 'T', 'S', 'P', 'E', 'C' };

	public String encrypt(String strToEncrypt) {
		try {
			IvParameterSpec ivspec = new IvParameterSpec(iv);
			SecretKeySpec secretKey = extractSecretKey();
			Cipher cipher = Cipher.getInstance(AES_CBC_PKCS5PADDING);
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
			SecretKeySpec secretKey = extractSecretKey();
			Cipher cipher = Cipher.getInstance(AES_CBC_PKCS5PADDING);
			cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
			return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
		} catch (Exception e) {
			System.out.println("Error while decrypting: " + e.toString());
		}
		return null;
	}

	private SecretKeySpec extractSecretKey() throws NoSuchAlgorithmException, InvalidKeySpecException {
		SecretKeyFactory factory = SecretKeyFactory.getInstance(PBKDF2_WITH_HMAC_SHA256);
		KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), salt.getBytes(), 65536, 256);
		SecretKey tmp = factory.generateSecret(spec);
		SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), AES);
		return secretKey;
	}

}