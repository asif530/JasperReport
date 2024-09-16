package com.jasperreports.reportgeneration.service;

import net.sf.jasperreports.engine.*;

import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;

public class TestReports {
    public static void main(String[] args) {


        //create a HashMap for Passing data to jasper report
        HashMap employeeReportMap = new HashMap<String, Object>();


        employeeReportMap.put("empId", "JK- OOP");
        employeeReportMap.put("name", "J K Saini");
        employeeReportMap.put("company", "NIC New Delhi");
        employeeReportMap.put("designation", "Java/J2EE Developer");
        employeeReportMap.put("salary", "18000 RS");
        employeeReportMap.put("time", new Date());


        try {
            InputStream inputStream = InputStream.class.getResourceAsStream("/reports/report2.jrxml");
            // Give the path of report jrxml file path for complie.
            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);

            //pass data HashMap with compiled jrxml file and a empty data source .
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, employeeReportMap, new JREmptyDataSource());

            // export file to pdf to your local system
            JasperExportManager.exportReportToPdfFile(jasperPrint, "D:/jasperoutput/empReport " + new Date().getTime() + ".pdf");


            System.out.println("Done----------------------");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }


}

