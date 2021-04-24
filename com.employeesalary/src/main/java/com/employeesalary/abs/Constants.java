package com.employeesalary.abs;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Constants {

	// klasa koja sadrzi konstante iz projekta

	public static FileInputStream file;

	public static XSSFWorkbook workbook;

	public static XSSFSheet sheet;

	//public static final String EXCEL_FILE_PATH = "src/main/resources/output.xlsx";

	public static FileOutputStream output;
	public static final String OUTPUT = "src/main/resources/output.xlsx";
	
	
}
