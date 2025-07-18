package api_utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviders {
	 // ✅ DataProvider to get all data from Excel (except header row)
	   
	 @DataProvider(name = "Data")
	    public String[][] getAllData() throws IOException {
	        String path = System.getProperty("user.dir") + "/testData/UserData.xlsx";
	        XLUtility xl = new XLUtility(path);

	        int rownum = xl.getRowCount("Sheet1");
	        int colcount = xl.getCellCount("Sheet1", 1); // Assuming row 0 is header

	        String[][] apidata = new String[rownum][colcount];

	        // i = 1 to skip header, apidata[i-1][j] aligns with array index
	        for (int i = 1; i <= rownum; i++) {
	            for (int j = 0; j < colcount; j++) {
	                apidata[i - 1][j] = xl.getCellData("Sheet1", i, j);
	            }
	        }

	        return apidata;
	    }

	    // ✅ DataProvider to get only username column from Excel
	    @DataProvider(name = "userName")
	    public String[] getUserName() throws IOException {
	        String path = System.getProperty("user.dir") + "/testData/UserData.xlsx";
	        XLUtility xl = new XLUtility(path);

	        int rownum = xl.getRowCount("Sheet1"); // Excluding header
	        String[] apidata = new String[rownum];

	        for (int i = 1; i <= rownum; i++) {
	            apidata[i - 1] = xl.getCellData("Sheet1", i, 1); // Column 1 = username
	        }

	        return apidata;
	    }

	   
	    

}
