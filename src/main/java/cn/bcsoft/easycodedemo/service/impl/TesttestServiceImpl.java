package cn.bcsoft.easycodedemo.service.impl;

import cn.bcsoft.easycodedemo.dao.TesttestDao;
import cn.bcsoft.easycodedemo.entity.Testtest;
import cn.bcsoft.easycodedemo.service.TesttestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 测试库(Testtest)表服务实现类
 *
 * @author blackchen
 * @since 2020-09-10 14:12:22
 */
@Service("testtestService")
public class TesttestServiceImpl implements TesttestService {
	@Resource
	private TesttestDao testtestDao;

	/**
	 * 通过ID查询单条数据
	 *
	 * @param testId 主键
	 * @return 实例对象
	 */
	@Override
	public Testtest queryById(Integer testId) {
		return this.testtestDao.queryById(testId);
	}

	/**
	 * 查询多条数据
	 *
	 * @param offset 查询起始位置
	 * @param limit  查询条数
	 * @return 对象列表
	 */
	@Override
	public List<Testtest> queryAllByLimit(int offset, int limit) {
		return this.testtestDao.queryAllByLimit(offset, limit);
	}

	/**
	 * 新增数据
	 *
	 * @param testtest 实例对象
	 * @return 实例对象
	 */
	@Override
	public Testtest insert(Testtest testtest) {
		this.testtestDao.insert(testtest);
		return testtest;
	}

	/**
	 * 修改数据
	 *
	 * @param testtest 实例对象
	 * @return 实例对象
	 */
	@Override
	public Testtest update(Testtest testtest) {
		this.testtestDao.update(testtest);
		return this.queryById(testtest.getTestId());
	}

	/**
	 * 通过主键删除数据
	 *
	 * @param testId 主键
	 * @return 是否成功
	 */
	@Override
	public boolean deleteById(Integer testId) {
		return this.testtestDao.deleteById(testId) > 0;
	}
}