package cn.bcsoft.easycodedemo.dao;

import cn.bcsoft.easycodedemo.entity.ExcelDemoData;

import java.util.List;

/**
 * @ClassName ExcelDemoDao
 * @Description 假设这个是你的DAO存储。当然还要这个类让spring管理，当然你不用需要存储，也不需要这个类。
 * Created by blackchen on 2020/10/10 14:27
 */
public class ExcelDemoDao {
	public void save(List<ExcelDemoData> list) {
		// 如果是mybatis,尽量别直接调用多次insert,自己写一个mapper里面新增一个方法batchInsert,所有数据一次性插入
	}
}
