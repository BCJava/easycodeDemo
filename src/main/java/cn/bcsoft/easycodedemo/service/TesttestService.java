package cn.bcsoft.easycodedemo.service;

import cn.bcsoft.easycodedemo.entity.Testtest;

import java.util.List;

/**
 * 测试库(Testtest)表服务接口
 *
 * @author blackchen
 * @since 2020-09-10 14:12:22
 */
public interface TesttestService {

	/**
	 * 通过ID查询单条数据
	 *
	 * @param testId 主键
	 * @return 实例对象
	 */
	Testtest queryById(Integer testId);

	/**
	 * 查询多条数据
	 *
	 * @param offset 查询起始位置
	 * @param limit  查询条数
	 * @return 对象列表
	 */
	List<Testtest> queryAllByLimit(int offset, int limit);

	/**
	 * 新增数据
	 *
	 * @param testtest 实例对象
	 * @return 实例对象
	 */
	Testtest insert(Testtest testtest);

	/**
	 * 修改数据
	 *
	 * @param testtest 实例对象
	 * @return 实例对象
	 */
	Testtest update(Testtest testtest);

	/**
	 * 通过主键删除数据
	 *
	 * @param testId 主键
	 * @return 是否成功
	 */
	boolean deleteById(Integer testId);

}