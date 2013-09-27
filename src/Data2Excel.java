import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * 将mongodb导出到excel
 * 
 * @author Huang
 * @date 2013-6-29 下午4:36:05
 */
public class Data2Excel {

	/**
	 * @author Huang
	 * @date 2013-6-29 下午4:36:01
	 * @return void
	 * @throws IOException
	 */

	public static void main(String[] args) throws IOException {

		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet("test-data");
		
		DUserTest dUserTest =new DUserTest();
		dUserTest.setId(10001);
		dUserTest.setUsername("hzd10001");
		dUserTest.setPassword("hzd10001");
		
		try {
			MySheet.addRow(sheet, dUserTest);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		FileOutputStream fileOut = new FileOutputStream("E:\\test-data.xls");
		wb.write(fileOut);
		fileOut.close();
	}

}
