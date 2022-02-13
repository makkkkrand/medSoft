package com.medSoft.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class URlEncoderDecoderProcessor {

	public String decode(String url) {
		String decodeURL ="";
		try {
			decodeURL = URLDecoder.decode(url, "UTF-8");
			log.info("Encoded URL", decodeURL);
			return decodeURL;
		} catch (UnsupportedEncodingException e) {
			log.error("Issue while decoding" , e.getMessage());
		}
		return decodeURL ;
	}

	public String encode(String url) {
		String encodeURL="";
		try {
			encodeURL = URLEncoder.encode(url, "UTF-8");
			log.info("Encoded URL", encodeURL);
			return encodeURL;
		} catch (UnsupportedEncodingException e) {
			log.error("Issue while encoding" + e.getMessage());
			
		}
		return encodeURL;
	}

}
