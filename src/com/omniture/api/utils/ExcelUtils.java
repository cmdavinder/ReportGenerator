package com.omniture.api.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * The Class ExcelUtils.
 */
public class ExcelUtils {

	/**
	 * Read XLS file.
	 *
	 * @param filePath
	 *            the file path
	 * @return the HSSF workbook
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static HSSFWorkbook readXLSFile(String filePath) throws IOException {
		return new HSSFWorkbook(new FileInputStream(filePath));
	}

	/**
	 * Read XLSX file.
	 *
	 * @param filePath
	 *            the file path
	 * @return the XSSF workbook
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static XSSFWorkbook readXLSXFile(String filePath) throws IOException {
		return new XSSFWorkbook(new FileInputStream(filePath));
	}

	/**
	 * Write XLSX file.
	 *
	 * @param wb
	 *            the wb
	 * @param filePath
	 *            the file path
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static void writeXLSXFile(XSSFWorkbook wb, String filePath) throws IOException {
		FileOutputStream fos = new FileOutputStream(filePath);
		wb.write(fos);
		fos.flush();
		fos.close();
	}
}
