package com.jasperreports.reportgeneration.service;

import net.sf.jasperreports.engine.export.HtmlExporter;

public interface IGenerateReportService {
    HtmlExporter exportReportInHTML() throws Exception;

    byte[] exportReportInPDF() throws Exception;
}
