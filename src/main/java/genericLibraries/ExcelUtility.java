package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	private Workbook workbook;
	public void excelInit(String excelPath) {
		FileInputStream fis=null;
		try {
			fis = new FileInputStream(excelPath);
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook=WorkbookFactory.create(fis);
			
		}catch(EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}
	}
	public Map<String,String> getData(String sheetName,String expectedTest){
		Map<String, String> map=new HashMap<String,String>();
		DataFormatter df=new DataFormatter();
		Sheet sheet=workbook.getSheet(sheetName);
		for (int i = 0; i <=sheet.getLastRowNum(); i++) {
			if(df.formatCellValue(sheet.getRow(i).getCell(1)).equals(expectedTest))
			{
				for (int j = i; j <= sheet.getLastRowNum(); j++) {
					String key=df.formatCellValue(sheet.getRow(j).getCell(2));
					String value=df.formatCellValue(sheet.getRow(j).getCell(3));
					map.put(key,value);
					if(key.equals("####"))
						break;
			

					
				}
				break;
			}
			
		}
		return map;
		
				
	}

}
