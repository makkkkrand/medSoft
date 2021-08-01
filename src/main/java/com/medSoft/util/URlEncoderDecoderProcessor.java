package com.medSoft.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.springframework.stereotype.Service;

@Service
public class URlEncoderDecoderProcessor {

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(URlEncoderDecoderProcessor.class);

	public String decode(String url) {
		try {
			String decodeURL = URLDecoder.decode(url, "UTF-8");
			log.info("Encoded URL", decodeURL);
			return decodeURL;
		} catch (UnsupportedEncodingException e) {
			return "Issue while decoding" + e.getMessage();
		}
	}

	public String encode(String url) {
		try {
			String encodeURL = URLEncoder.encode(url, "UTF-8");
			log.info("Encoded URL", encodeURL);
			return encodeURL;
		} catch (UnsupportedEncodingException e) {
			return "Issue while encoding" + e.getMessage();
		}
	}

}
