package cn.bcsoft.easycodedemo.File_IO;

import cn.bcsoft.easycodedemo.entity.ExcelDemoData;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @ClassName WriteExcel
 * @Description TODO
 * Created by blackchen on 2020/10/9 15:38
 */
public class WriteExcel {
	public static void main(String[] args) {
		simpleEasyExcelWrite();
	}

	private static List<ExcelDemoData> data() {
		List<ExcelDemoData> list = new ArrayList<ExcelDemoData>();
		for (int i = 0; i < 10; i++) {
			ExcelDemoData data = new ExcelDemoData();
			data.setString("字符串" + i);
			data.setDate(new Date());
			data.setDoubleData(0.56+i);
			list.add(data);
		}
		return list;
	}

	public static void simpleEasyExcelWrite(){
		// 写法1
		String fileName = "FileTest/" + "simpleWrite1.xlsx";
		// 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
		// 如果这里想使用03 则 传入excelType参数即可
		EasyExcel.write(fileName, ExcelDemoData.class).sheet("模板").doWrite(data());

		// 写法2
		fileName = "FileTest/" + "simpleWrite2.xlsx";
		// 这里 需要指定写用哪个class去写
		ExcelWriter excelWriter = null;
		try {
			excelWriter = EasyExcel.write(fileName, ExcelDemoData.class).build();
			WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
			excelWriter.write(data(), writeSheet);
		} finally {
			// 千万别忘记finish 会帮忙关闭流
			if (excelWriter != null) {
				excelWriter.finish();
			}
		}
	}

//	public void jxlWrite (){
//		//1:创建excel文件
//		File file=new File("FileTest/excelTest.xls");
//		file.createNewFile();
//
//		//2:创建工作簿
//		WritableWorkbook workbook = Workbook.createWorkbook(file);
//		//3:创建sheet,设置第二三四..个sheet，依次类推即可
//		WritableSheet sheet = workbook.createSheet("用户管理", 0);
//		//4：设置titles
//		String[] titles={"编号","账号","密码"};
//		//5:单元格
//		Label label=null;
//		//6:给第一行设置列名
//		for(int i=0;i<titles.length;i++){
//			//x,y,第一行的列名
//			label=new Label(i,0,titles[i]);
//			//7：添加单元格
//			sheet.addCell(label);
//		}
//		//8：模拟数据库导入数据
//		for(int i=1;i<10;i++){
//			//添加编号，第二行第一列
//			label=new Label(0,i,i+"");
//			sheet.addCell(label);
//
//			//添加账号
//			label=new Label(1,i,"10010"+i);
//			sheet.addCell(label);
//
//			//添加密码
//			label=new Label(2,i,"123456");
//			sheet.addCell(label);
//		}
//
//		//写入数据，一定记得写入数据，不然你都开始怀疑世界了，excel里面啥都没有
//		workbook.write();
//		//最后一步，关闭工作簿
//		workbook.close();
//	}
}
