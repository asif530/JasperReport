package com.jasperreports.reportgeneration.controllers;


import com.jasperreports.reportgeneration.entities.Product;
import com.jasperreports.reportgeneration.service.GenerateReportService;
import com.jasperreports.reportgeneration.service.IGenerateReportService;
import com.jasperreports.reportgeneration.services.ProductService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.ArrayList;

@Controller
@RequestMapping("product")
public class ProductController {

    private ProductService productService;

    private IGenerateReportService generateReportService;

    public ProductController(ProductService productService, IGenerateReportService generateReportService) {
        this.productService = productService;
        this.generateReportService = generateReportService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        return "product/index";
    }


    @GetMapping("allProduct/")
    @ResponseBody
    public ArrayList<Product> getAllProduct(){
        return productService.getAllProduct();
    }

    @RequestMapping(value = "report", method = RequestMethod.GET)
    public void report(HttpServletResponse response) throws Exception {
        response.setContentType("text/html");
        HtmlExporter exporter = generateReportService.exportReportInHTML();
        exporter.setExporterOutput(new SimpleHtmlExporterOutput(response.getWriter()));
        exporter.exportReport();
    }

    @RequestMapping(value = "reportPDF", method = RequestMethod.GET)
    public ResponseEntity<byte[]> reportPDF(HttpServletResponse response) throws Exception {

        // Generate PDF report
        byte[] pdfContent = generateReportService.exportReportInPDF();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("filename", "report.pdf");

        // Return the PDF as a response
        return ResponseEntity.ok().headers(headers).body(pdfContent);
    }

}
