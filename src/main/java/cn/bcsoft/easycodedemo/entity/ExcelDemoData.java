package cn.bcsoft.easycodedemo.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName ExcelDemoData
 * @Description 表格示例实例
 * Created by blackchen on 2020/10/10 13:48
 */
@Data
public class ExcelDemoData {
	@ExcelProperty("字符串标题")
	private String string;
	@ExcelProperty("日期标题")
	private Date date;
	@ExcelProperty("数字标题")
	private Double doubleData;
	/**
	 * 忽略字段
	 */
	@ExcelIgnore
	private String ignoreStr;
}
