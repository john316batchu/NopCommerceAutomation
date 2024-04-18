package utility;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

	@DataProvider(name="logindata")
	public String[][] loginData() throws IOException {
		
		String filePath=".//testData//LoginTestData.xlsx";
		ExcelUtility util=new ExcelUtility(filePath);
		int row_count=util.getRowCount("Sheet1");
		int cell_count=util.getCellCount("Sheet1", 1);
		
		String data[][]=new String[row_count][cell_count];
		for(int r=1;r<=row_count;r++) {		
			for(int c=0;c<cell_count;c++) {
			data[r-1][c]=util.getCellData("Sheet1", r, c);
				}
			}
		return data;
	}

}
