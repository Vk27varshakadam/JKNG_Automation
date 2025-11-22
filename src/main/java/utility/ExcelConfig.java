package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelConfig 
{
	public static Workbook workbook;
	public static Sheet sheet;
	
	
	public void LoadExcel(String path,String Sheetname) throws IOException
	{
		
		FileInputStream fis = new FileInputStream(path);
		 workbook = new XSSFWorkbook(fis);
		 sheet=workbook.getSheet(Sheetname);
		 fis.close();
	}

	public static String getCelldata(int row,int column)
	{
		Cell cell = sheet.getRow(row).getCell(column);
		 // return cell.getStringCellValue();
		DataFormatter formatter = new DataFormatter();
		String  cellValue=formatter.formatCellValue(cell);
		return cellValue;
		
	}

	  //  Write value in Excel (for example, in column 0)
    public static void setCelldata(String path, int row, int column, String value) throws IOException
    {
        Row existingRow = sheet.getRow(row);
        if (existingRow == null)
            existingRow = sheet.createRow(row);

        Cell cell = existingRow.getCell(column);
        if (cell == null)
            cell = existingRow.createCell(column);

        cell.setCellValue(value);

        FileOutputStream fos = new FileOutputStream(path);
        workbook.write(fos);
        fos.close();
        workbook.close();
    }
	
}


