package com.umi.studentservice.service;

import com.umi.studentservice.entity.Student;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ExcelUploadService {
    public static boolean isValidExcelFile(MultipartFile file){
        return Objects.equals(file.getContentType(), "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" );
    }

    public static List<Student> getStudentsDataFromExcel(InputStream inputStream){

        List<Student> students = new ArrayList<>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            int rowIndex = 0;
            for (Row row : sheet){
                if (rowIndex == 0){
                    rowIndex++;
                    continue;
                }
                Iterator<Cell> cellIterator = row.iterator();
                int cellIndex = 0;
                Student student = new Student();
                student.setId(null);  // Set id to null for each student
                student.setCreated_at(null);  // Set created_at to null for each student
                student.setUpdated_at(null);  // Set updated_at to null for each student
                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()){
                        case STRING:
                            if (cellIndex == 0) {
                                student.setFirstname(cell.getStringCellValue());
                            } else if (cellIndex == 1) {
                                student.setLastname(cell.getStringCellValue());
                            } else if (cellIndex == 2) {
                                student.setEmail(cell.getStringCellValue());
                            } else if (cellIndex == 3) {
                                student.setCne(cell.getStringCellValue());
                            } else if (cellIndex == 4) {
                                student.setCni(cell.getStringCellValue());
                            }
                            break;
                        default:
                            // Handle other cell types if necessary
                            break;
                    }
                    cellIndex++;
                }
                students.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }

}
