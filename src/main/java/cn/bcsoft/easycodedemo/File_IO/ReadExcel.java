package cn.bcsoft.easycodedemo.File_IO;

import cn.bcsoft.easycodedemo.entity.ExcelDemoData;
import cn.bcsoft.easycodedemo.entity.ExcelDemoListener;
import cn.bcsoft.easycodedemo.util.ExcelUtil;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import javafx.scene.control.Cell;
import com.alibaba.excel.EasyExcel;

import java.io.File;
import java.util.List;

/**
 * @ClassName ReadExcel
 * @Description TODO
 * Created by blackchen on 2020/10/9 15:41
 */
public class ReadExcel {
	public static void main(String[] args) throws Exception{
		readEasyExcel();
	}

	public static void readEasyExcel(){
		// 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
		// 写法1：
		String fileName = "FileTest/" + "simpleWrite1.xlsx";
		// 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
		EasyExcel.read(fileName, ExcelDemoData.class, new ExcelDemoListener(null)).sheet().doRead();

//		 写法2：
		fileName = "FileTest/" + "simpleWrite2.xlsx";
		ExcelReader excelReader = null;
		try {
			excelReader = EasyExcel.read(fileName, ExcelDemoData.class, new ExcelDemoListener(null)).build();
			ReadSheet readSheet = EasyExcel.readSheet(0).build();
			excelReader.read(readSheet);
		} finally {
			if (excelReader != null) {
				// 这里千万别忘记关闭，读的时候会创建临时文件，到时磁盘会崩的
				excelReader.finish();
			}
		}
	}

	public void readJXL (){
		//		//1:创建workbook
//		Workbook workbook=Workbook.getWorkbook(new File("test.xls"));
//		//2:获取第一个工作表sheet
//		Sheet sheet=workbook.getSheet(0);
//		//3:获取数据
//		System.out.println("行："+sheet.getRows());
//		System.out.println("列："+sheet.getColumns());
//		for(int i=0;i<sheet.getRows();i++){
//			for(int j=0;j<sheet.getColumns();j++){
//				Cell cell=sheet.getCell(j,i);
//				System.out.print(cell.getContents()+" ");
//			}
//			System.out.println();
//		}
//
//		//最后一步：关闭资源
//		workbook.close();
	}
}
