package amzon.Utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Utilities {
	
	

	public static Object[][] readDataFromExcel(String sheetname) throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\testData\\TestData.xlsx");

		Workbook workbook = WorkbookFactory.create(fis);

		Sheet sheet = workbook.getSheet(sheetname);
		int TotalRow = sheet.getLastRowNum();
		int TotalColumn = sheet.getRow(0).getLastCellNum();
		DataFormatter formatter = new DataFormatter();
		// object[][] data = new object[TotalRow][TotalColumn];
		Object[][] testData = new Object[TotalRow][TotalColumn];

		for (int i = 1; i <= TotalRow; i++) {

			for (int j = 0; j < TotalColumn; j++) {
				testData[i - 1][j] = formatter.formatCellValue(sheet.getRow(i).getCell(j));
			}
		}

		workbook.close();
		return testData;
	}

	public static void main(String[] args) {
		try {
			Object[][] testData = readDataFromExcel("RamSize");

			for (Object[] row : testData) {
				for (Object cell : row) {
					System.out.print(cell + "\t");
				}
				System.out.println(); // Move to the next line for a new row

			}

			System.out.println(testData.length);
		} catch (IOException | EncryptedDocumentException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	

}
