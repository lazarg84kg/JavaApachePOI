package com.employeesalary.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.employeesalary.abs.Constants;
import com.employeesalary.main.Devops;
import com.employeesalary.main.Employee;
import com.employeesalary.main.Programer;
import com.employeesalary.write.WriteData;

public class TestWriteData {

	public static void main(String args[]) throws IOException {

		Constants.workbook = new XSSFWorkbook();
		Constants.sheet = Constants.workbook.createSheet("Employee");

//		WriteData wd = new WriteData();
//
//		wd.insertEmployeesData();

		Row headerRow = Constants.sheet.createRow(0);

		FileOutputStream fileOut = new FileOutputStream(Constants.OUTPUT);

		String[] columns = { "Ime", "Pozicija", "Broj Radnih Sati", "Cena Radnog Sata", "Prekovremeni Rad", "Bonus" };
		List<Employee> empList = new ArrayList<Employee>();
		Scanner scan = new Scanner(System.in);
		boolean isRunning = true;
		System.out.println("Please enter your name in the account(q to exit program):\n");
		while (isRunning) {

			System.out.println("Unesi ime:\n");
			String ime = scan.next();
			if (ime.equalsIgnoreCase("q")) {
				break;
			}
			System.out.println("Unesi poziciju:");
			String pozicija = scan.next();

			System.out.println("Unesi broj radnih sati: ");

			double brojRadnihSati = scan.nextDouble();

			System.out.println("Unesi cenu radnog sata:");
			double cenaRadnogSata = scan.nextDouble();
			// if (pozicija.equalsIgnoreCase("devops")) {
			// double bonus = scan.next();
			// }
			System.out.println("Unesi bonus:");
			double bonus = scan.nextDouble();

			System.out.println("Unesi prekovremeni rad:");

			double prekovremeni = scan.nextDouble();

			if (pozicija.equalsIgnoreCase("programer")) {

				Employee p = new Programer(ime, pozicija, brojRadnihSati, cenaRadnogSata, bonus, prekovremeni);
				empList.add(p);
			} else if (pozicija.equalsIgnoreCase("devops")) {
				Employee d = new Devops(ime, pozicija, brojRadnihSati, cenaRadnogSata, bonus);
				empList.add(d);
			}
			System.out.println("Next entry, or q to quit!");
		}
		scan.close();

		int rowNum = 1;
		for (Employee employee : empList) {
			Row row = Constants.sheet.createRow(rowNum++);

			if (employee instanceof Programer) {
				row.createCell(0).setCellValue(employee.getIme());

				row.createCell(1).setCellValue(employee.getPozicija());

				row.createCell(2).setCellValue(employee.getBrojRadnihSati());
				row.createCell(3).setCellValue(employee.getCenaRadnogSata());
				row.createCell(4).setCellValue(((Programer) employee).getPrekovremeniRad());
				row.createCell(5).setCellValue(((Programer) employee).getBonus());
			}

			else if (employee instanceof Devops) {
				row.createCell(0).setCellValue(employee.getIme());

				row.createCell(1).setCellValue(employee.getPozicija());

				row.createCell(2).setCellValue(employee.getBrojRadnihSati());
				row.createCell(3).setCellValue(employee.getCenaRadnogSata());
				row.createCell(5).setCellValue(((Devops) employee).getBonus());
			}

		}

		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);

		}
		for (int i = 0; i < columns.length; i++) {
			Constants.sheet.autoSizeColumn(i);
		}

		Constants.workbook.write(fileOut);
		fileOut.close();

		// Closing the workbook
		Constants.workbook.close();
		System.out.println("OK");

	}
}
