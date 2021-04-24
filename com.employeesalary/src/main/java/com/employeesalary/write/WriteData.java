package com.employeesalary.write;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.employeesalary.abs.Constants;
import com.employeesalary.main.Devops;
import com.employeesalary.main.Employee;
import com.employeesalary.main.Programer;;

public class WriteData {
	private String[] columns = {"Ime", "Pozicija", "Broj Radnih Sati", "Cena Radnog Sata", "Bonus", "Prekovremeni Rad" };
	 
	Workbook workbook = new XSSFWorkbook();
	Sheet sheet = workbook.createSheet("Employee");
	Row headerRow = sheet.createRow(0);
	 private ArrayList<Employee> ac = new ArrayList<Employee>();

	 public void insertEmployeesData() {
		Scanner scan = new Scanner(System.in);
		boolean isRunning = true;
			
			while (isRunning) {
				System.out.println("Please enter your name in the account(q to exit program):\n");

				System.out.println("Unesi ime:\n");
				String ime = scan.next();
				if (ime.equalsIgnoreCase("q")) {
					break;
				}
				System.out.println("Unesi poziciju:\n");
				String pozicija = scan.next();
			
				System.out.println("Unesi broj radnih sati\n ");
				
				double brojRadnihSati= scan.nextDouble();

				System.out.println("Unesi cenu radnog sata:\n");
				double cenaRadnogSata = scan.nextDouble();
				System.out.println("Unesi bonus:\n");
				double bonus = scan.nextDouble();
				System.out.println("Unesi prekovremeni rad:\n");
				double prekovremeni = scan.nextDouble();
				
				if (pozicija.equalsIgnoreCase("programer")) {

					Employee p = new Programer(ime, pozicija, brojRadnihSati, cenaRadnogSata, bonus, prekovremeni);
					ac.add(p);
				} else if (pozicija.equalsIgnoreCase("devops")) {
					Employee d = new Devops(ime, pozicija, brojRadnihSati, cenaRadnogSata, bonus);
					ac.add(d);
				}

			}
			scan.close();
		 
	
	
		 for (int i = 0; i < columns.length; i++) {
				Cell cell = headerRow.createCell(i);
				cell.setCellValue(columns[i]);

			}
	 
	
		 for(int i = 0; i < columns.length; i++) {
	            sheet.autoSizeColumn(i);
	        }
	 
	 
		 int rowNum = 1;
			for (Employee employee : ac) {
				Row row = sheet.createRow(rowNum++);

				row.createCell(0).setCellValue(employee.getIme());

				row.createCell(1).setCellValue(employee.getPozicija());

				row.createCell(2).setCellValue(employee.getBrojRadnihSati());
				row.createCell(3).setCellValue(employee.getCenaRadnogSata());
				//row.createCell(4).setCellValue(employee.getPrekovremeniRad());
				//row.createCell(5).setCellValue(employee.getBonus());
				

			}
			
	 }

	

		// Initializing employees data to insert into the excel file
//	    static {
//	       
//	        employees.add(new Programer("Rajeev Singh", "rajeev@example.com",1200000.0, 200, 40, 0));
//
//	       
//	        employees.add(new Programer("Thomas cook", "thomas@example.com", 1500000.0,250,40,1000));
//
//	        
//	        employees.add(new Devops("Steve Maiden", "steve@example.com",1800000.0,200,60));
//	    }
//	 
// 
//	public void writeExcel(List<Employee> listEmp, String excelFilePath) throws IOException {
//		Workbook workbook = new XSSFWorkbook();
//		Sheet sheet = workbook.createSheet();
//
//		int rowCount = 0;
//	
//		for (Employee aBook : listEmp) {
//			Row row = sheet.createRow(++rowCount);
//		
//			writeBook(aBook, row);
//		}
//
//		try (FileOutputStream output = new FileOutputStream(excelFilePath)) {
//			workbook.write(output);
//		}
//	}
//
//	private void writeBook(Employee aBook, Row row) {
//		
//	
//		
//		Cell cell = row.createCell(1);
//		
//	
//		
//		cell.setCellValue(aBook.getPozicija());
//		cell = row.createCell(2);
//		cell.setCellValue(aBook.getIme());
//
//		cell = row.createCell(3);
//		cell.setCellValue(aBook.getBrojRadnihSati());
//		cell = row.createCell(4);
//		cell.setCellValue(aBook.getCenaRadnogSata());
//		
//		
//	}
//
//	public List<Employee> getListBook() {
//		Employee book1 = new Programer("Programer", "Lazar", 123, 200, 0, 0);
//		Employee book2 = new Programer("Programer", "Joshua Bloch", 36, 250, 0, 12300);
//		Employee book3 = new Devops("Devops", "Robert Martin", 42, 240, 0);
//		Employee book4 = new Devops("Devops", "Bruce Eckel", 35, 180, 0);
//
//		List<Employee> listBook = Arrays.asList(book1, book2, book3, book4);
//
//		return listBook;
//	}
}
