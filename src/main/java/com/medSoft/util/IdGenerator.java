package com.medSoft.util;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IdGenerator implements IdentifierGenerator {

	private static final String YYYY_MM_DD_HH_MM_SS = "yyyyMMddHHmmss";

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		Date date = new Date();
		String id="";
		try {
			SimpleDateFormat format = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
			id = format.format(date);
		} catch (Exception e) {
			log.error("unable to fetch new Id having error :()", e.getMessage());
		}
		return Integer.valueOf(id);
	}
}
