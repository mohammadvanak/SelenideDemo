package Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	public static List<String> readExcel(String filePath,String fileName,String sheetName) throws IOException{


	    File file = new File(filePath+"\\"+fileName);

	    FileInputStream inputStream = new FileInputStream(file);

	    XSSFWorkbook Workbook = null;

	    String fileExtensionName = fileName.substring(fileName.indexOf("."));
	    if(fileExtensionName.equals(".xlsx")){

	    	Workbook = new XSSFWorkbook(inputStream);

	    }
	    
	    XSSFSheet Sheet = Workbook.getSheet(sheetName);

	    int rowCount = Sheet.getLastRowNum()-Sheet.getFirstRowNum();
	    List<String> data=new ArrayList<String>();
	    DataFormatter formatter = new DataFormatter();
	    for (int i = 1; i < rowCount+1; i++) {

	        Row row = Sheet.getRow(i);

	        for (int j = 0; j < row.getLastCellNum(); j++) {
	        	data.add(formatter.formatCellValue(row.getCell(j)));
	            //System.out.print(row.getCell(j).getStringCellValue()+"|| ");

	        }
	    } 
	    return data;
	    }
	}
