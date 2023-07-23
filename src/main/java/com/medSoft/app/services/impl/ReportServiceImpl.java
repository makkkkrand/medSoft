package com.medSoft.app.services.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;

public class ReportServiceImpl implements ReportService {

	/**
	 * generates report in prescribed format 
	 * format supported: pdf, xml, html
	 * @throws FileNotFoundException 
	 */
	@Override
	public String generateReport(Map<String, Object> params) throws FileNotFoundException {
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
				case "xls":
					reportUrl = tmpDir.getAbsolutePath() + File.separator + params.get("reportName") + ".xls";
					SimpleXlsxReportConfiguration reportConfigXLS = new SimpleXlsxReportConfiguration();
			        reportConfigXLS.setSheetNames(new String[] { "sheet1" });
			        JRXlsxExporter exporter = new JRXlsxExporter();
			        exporter.setConfiguration(reportConfigXLS);
			        exporter.setExporterInput(new SimpleExporterInput(print));
			        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(new FileOutputStream(new File(reportUrl))));
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
