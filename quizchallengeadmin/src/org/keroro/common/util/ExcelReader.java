package org.keroro.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Getter
public class ExcelReader {
	private int lastRowNum;
	private Sheet sheet;

	private String fileName;
	private File file;
	
	public ExcelReader(String fileName) {
		this.fileName = fileName;
		init();
	}
	
	
	private void init() {
		String version = "xlsx";

		Workbook workbook = getWorkbook(fileName, version);

		sheet = workbook.getSheetAt(0);
		
		lastRowNum = sheet.getLastRowNum() + 1;
	}

	private Workbook getWorkbook(String filename, String version) {

		try (FileInputStream stream = new FileInputStream(filename)) {

			if ("xls".equals(version)) {
				return new HSSFWorkbook(stream);
				
			} else if ("xlsx".equals(version)) {
				return new XSSFWorkbook(stream);
			}
			throw new NoClassDefFoundError();
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}

	}

	public String getCellString(int rowNum, int cellNum) {
		Cell cell = getCell(rowNum, cellNum);
		String result = getCell(rowNum, cellNum).getStringCellValue();
		return result;
	}
	
	public int getCellInt(int rowNum, int cellNum) {
		Cell cell = getCell(rowNum, cellNum);
		
		if(null == cell) {
			return 0;
		}
		
		CellType type = cell.getCellType();
		
		if("NUMERIC" != type.name()) {
			return 0;
		}
		
		int result = (int)(getCell(rowNum, cellNum).getNumericCellValue());
		return result;
	}
	
	public Cell getCell(int rowNum, int cellNum) {
		Row row = getRow(sheet, rowNum);
		
		return getCell(row, cellNum);
	}
	

	private Cell getCell(Row row, int cellNum) {
		Cell cell = row.getCell(cellNum);

		return cell;
	}


	private Row getRow(Sheet sheet, int rowNum) {
		Row row = sheet.getRow(rowNum);

		return row;
	}

}
