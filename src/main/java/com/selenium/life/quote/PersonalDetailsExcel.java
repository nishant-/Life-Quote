package com.selenium.life.quote;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PersonalDetailsExcel {

	public static List<Person> getPersonalDetailsAsList(String workBookName, String sheetName)
			throws FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream(workBookName);
		List<Person> personList = new ArrayList<>();
		XSSFWorkbook workBook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workBook.getSheet(sheetName);
		int numOfRows = sheet.getPhysicalNumberOfRows();
		for (int i = 1; i < numOfRows; i++) {
			Person p = new Person();
			Row row = sheet.getRow(i);
			if (row.getCell(0) != null) {
				for (int j = 0; j < 5; j++) {
					setPersonalDetailsFromExcel(p, row, j);
				}
				personList.add(p);
			}

		}
		return personList;
	}

	public static void createExcelWithQuote(List<Person> pList) throws Exception {

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("QUOTE");
		createTitleRow(sheet);
		int rowCount = 1;
		for (Person p : pList) {
			Row r = sheet.createRow(rowCount);
			int colCount = 0;
			r.createCell(colCount++).setCellValue(p.getAge());
			r.createCell(colCount++).setCellValue(p.getGender());
			r.createCell(colCount++).setCellValue(p.getOccupationCategory());
			r.createCell(colCount++).setCellValue(p.getState());
			r.createCell(colCount++).setCellValue(p.getEmail());
			r.createCell(colCount).setCellValue(p.getPremiumAmount());
			rowCount++;
		}
		String fileName = "GeneratedQuote_"+new java.util.Date().getTime()+".xlsx";
		FileOutputStream fos = new FileOutputStream(fileName);
		workbook.write(fos);
	}

	private static void createTitleRow(XSSFSheet sheet) {

		Row r = sheet.createRow(0);
		r.createCell(0).setCellValue("Age");
		r.createCell(1).setCellValue("Gender");
		r.createCell(2).setCellValue("Occupation Category");
		r.createCell(3).setCellValue("State");
		r.createCell(4).setCellValue("Email");
		r.createCell(5).setCellValue("Quote");

	}

	private static boolean setPersonalDetailsFromExcel(Person p, Row row, int j) {
		Cell cell = row.getCell(j);
		switch (j) {
		case 0:
			p.setAge((int) cell.getNumericCellValue());
			break;
		case 1:
			p.setGender(cell.getStringCellValue());
			break;
		case 2:
			p.setOccupationCategory(cell.getStringCellValue());
			break;
		case 3:
			p.setState(cell.getStringCellValue());
			break;
		case 4:
			p.setEmail(cell.getStringCellValue());
			break;
		default:
			break;
		}
		return true;
	}

}
