package com.umi.studentservice.service;

import com.umi.studentservice.entity.Student;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.List;

public class ExportExcelService {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Student> studentList;

    public ExportExcelService(List<Student> studentList) {
        this.studentList = studentList;
        workbook = new XSSFWorkbook();
    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style){
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer){
            cell.setCellValue((Integer) value);
        }else if (value instanceof Double){
            cell.setCellValue((Double) value);
        }else if (value instanceof Boolean){
            cell.setCellValue((Boolean) value);
        }else if (value instanceof Long) {
            cell.setCellValue((Long) value);
        }else if (value instanceof java.sql.Timestamp){  // Check if value is a Timestamp
                cell.setCellValue(((java.sql.Timestamp) value).toLocalDateTime().toString());  // Format Timestamp as String
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void createHeaderRow(){
        sheet   = workbook.createSheet("Students Informations");
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();


        row = sheet.createRow(0);
        font.setBold(true);
        font.setFontHeight(12);
        style.setFont(font);
        createCell(row, 0, "ID", style);
        createCell(row, 1, "First Name", style);
        createCell(row, 2, "Last Name", style);
        createCell(row, 3, "Email", style);
        createCell(row, 4, "Cne", style);
        createCell(row, 5, "Cni", style);
    }

    private void writeStudentData(){
        int rowCount = 1;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(12);
        style.setFont(font);

        for (Student student : studentList){
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, student.getId(), style);
            createCell(row, columnCount++, student.getFirstname(), style);
            createCell(row, columnCount++, student.getLastname(), style);
            createCell(row, columnCount++, student.getEmail(), style);
            createCell(row, columnCount++, student.getCne(), style);
            createCell(row, columnCount++, student.getCni(), style);
        }

    }

    public void exportDataToExcel(HttpServletResponse response) throws IOException {
        createHeaderRow();
        writeStudentData();
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
