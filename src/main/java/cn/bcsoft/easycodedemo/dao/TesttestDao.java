package cn.bcsoft.easycodedemo.dao;

import cn.bcsoft.easycodedemo.entity.Testtest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 测试库(Testtest)表数据库访问层
 *
 * @author blackchen
 * @since 2020-09-10 14:12:22
 */
@Mapper//加上,不然读不到文件
public interface TesttestDao {

	/**
	 * 通过ID查询单条数据
	 *
	 * @param testId 主键
	 * @return 实例对象
	 */
	Testtest queryById(Integer testId);

	/**
	 * 查询指定行数据
	 *
	 * @param offset 查询起始位置
	 * @param limit  查询条数
	 * @return 对象列表
	 */
	List<Testtest> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


	/**
	 * 通过实体作为筛选条件查询
	 *
	 * @param testtest 实例对象
	 * @return 对象列表
	 */
	List<Testtest> queryAll(Testtest testtest);

	/**
	 * 新增数据
	 *
	 * @param testtest 实例对象
	 * @return 影响行数
	 */
	int insert(Testtest testtest);

	/**
	 * 修改数据
	 *
	 * @param testtest 实例对象
	 * @return 影响行数
	 */
	int update(Testtest testtest);

	/**
	 * 通过主键删除数据
	 *
	 * @param testId 主键
	 * @return 影响行数
	 */
	int deleteById(Integer testId);

}