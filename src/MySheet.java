
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

/**
 * sheet表生成类
 * 
 * @author Huang
 * @date 2013-6-29 下午4:38:15
 */
public class MySheet {

	public static int rowIndex = 0;

	/**
	 * 增加一行
	 * @author Huang
	 * @date 2013-9-27 上午11:45:34
	 * @return void
	 */
	public static void addRow(Sheet sheet, Object obj) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Field[] fields = obj.getClass().getDeclaredFields();
		Row row2 = sheet.createRow(rowIndex);
		int indexCell = 0;
		for (Field f : fields) {
			Method method = obj.getClass().getMethod(field2Method(f.getName()));
			Object value = method.invoke(obj);
			row2.createCell(indexCell++).setCellValue(value.toString());
		}
		rowIndex++;
	}
	/**
	 * 由字段名转换为方法名
	 * @author Huang
	 * @date 2013-9-27 上午11:45:40
	 * @return String
	 */
	public static String field2Method(String field){
		return "get"+field.substring(0, 1).toUpperCase() + field.substring(1);
	}

}
