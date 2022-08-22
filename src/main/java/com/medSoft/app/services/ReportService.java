package com.medSoft.app.services;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface ReportService {
	public String generateReport(Map<String,Object> params);
}
