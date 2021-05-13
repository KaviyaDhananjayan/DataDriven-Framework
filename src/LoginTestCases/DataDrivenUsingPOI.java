package LoginTestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenUsingPOI {
	
	static List<String> userNameList = new ArrayList<String>();
	static List<String> passwordList = new ArrayList<String>();

	public void readDatafromExcel() throws IOException {
		FileInputStream excel = new FileInputStream("C:\\Users\\kaviya.dhananjayan\\Desktop\\TestDataPoi.xlsx");
		Workbook book= new XSSFWorkbook(excel);
		Sheet sheet=book.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();

		while(rowIterator.hasNext()) {
			Row rowValue = rowIterator.next();
			Iterator<Cell> columnIterator = rowValue.iterator();
			int i=2;
			while(columnIterator.hasNext()) {
				if(i%2==0) {
					userNameList.add(columnIterator.next().getStringCellValue());
				}
				else {
					passwordList.add(columnIterator.next().getStringCellValue());
				}
				i++;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		DataDrivenUsingPOI usingPOI = new DataDrivenUsingPOI();
		usingPOI.readDatafromExcel();
		System.out.println("Username List="+userNameList);
		System.out.println("Password List="+passwordList);

	}

}
