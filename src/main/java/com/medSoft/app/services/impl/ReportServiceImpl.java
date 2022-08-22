package com.medSoft.app.services.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Map;

import org.jfree.util.Log;

import com.medSoft.app.services.ReportService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class ReportServiceImpl implements ReportService {

	@Override
	public String generateReport(Map<String, Object> params) {
		String reportUrl = "";
		String reportType="";
		try {
			reportType = (String) params.get("reportType");
			JasperReport report = JasperCompileManager
					.compileReport("classpath:" + "reports/" + params.get("reportName"));
			JasperPrint print = JasperFillManager.fillReport(report, params, (JRBeanCollectionDataSource)params.get("datasourceName"));
			if (checkReportdirectory()) {
				File tmpDir = new File("classpath:generatedReports");
				switch (reportType) {
				case "pdf":
					reportUrl = tmpDir.getAbsolutePath() + File.separator + params.get("reportName") + ".pdf";
					JasperExportManager.exportReportToPdfFile(print, reportUrl);
					break;
				case "html":
					reportUrl = tmpDir.getAbsolutePath() + File.separator + params.get("reportName") + ".html";
					JasperExportManager.exportReportToHtmlFile(print, reportUrl);
					break;
				case "xml":
					reportUrl = tmpDir.getAbsolutePath() + File.separator + params.get("reportName") + ".xml";
					JasperExportManager.exportReportToXmlFile(print, reportUrl, true);
					break;
				}
			}
		} catch (JRException e) {
			e.printStackTrace();
		}

		return reportUrl;
	}

	private boolean checkReportdirectory() {
		File tmpDir = new File("classpath:generatedReports");
		if (!tmpDir.isDirectory()) {
			try {
				Files.createDirectory(tmpDir.toPath()).toFile();
				Files.setPosixFilePermissions(tmpDir.toPath(), PosixFilePermissions.fromString("rwxrwxrwx"));
				return true;
			} catch (IOException e) {
				Log.error("Exception occured while creating Generated Report folder");
				return false;
			}
		} else
			return true;
	}
}
