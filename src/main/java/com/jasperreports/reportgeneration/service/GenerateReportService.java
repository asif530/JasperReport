package com.jasperreports.reportgeneration.service;

import com.jasperreports.reportgeneration.dao.IProductDao;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Date;

@Service
public class GenerateReportService implements IGenerateReportService {

    private IProductDao productDao;

    public GenerateReportService(IProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public HtmlExporter exportReportInHTML()  throws Exception  {
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(productDao.getAllProductJPA());
        InputStream inputStream = this.getClass().getResourceAsStream("/reports/report.jrxml");
        System.out.println(new Date());
        JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
        System.out.println(new Date());
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);
        HtmlExporter exporter = new HtmlExporter(DefaultJasperReportsContext.getInstance());
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        return exporter;

    }

    @Override
    public byte[] exportReportInPDF()  throws Exception  {
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(productDao.getAllProductJPA());
        InputStream inputStream = this.getClass().getResourceAsStream("/reports/report.jrxml");
        System.out.println(new Date());
        JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
        System.out.println(new Date());
        byte[] pdfContent =  JasperExportManager.exportReportToPdf(JasperFillManager.fillReport(jasperReport, null, dataSource)) ;
        return pdfContent;

    }
}
