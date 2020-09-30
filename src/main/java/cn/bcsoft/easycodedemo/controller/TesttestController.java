package cn.bcsoft.easycodedemo.controller;

import cn.bcsoft.easycodedemo.entity.Testtest;
import cn.bcsoft.easycodedemo.service.TesttestService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 测试库(Testtest)表控制层
 *
 * @author blackchen
 * @since 2020-09-10 14:12:22
 */
@RestController
@RequestMapping("testtest")
public class TesttestController {

	@GetMapping("ss")
	public String ss (){
		return "asdasdasda";
	}
	/**
	 * 服务对象
	 */
	@Resource
	private TesttestService testtestService;

	/**
	 * 通过主键查询单条数据
	 *
	 * @param id 主键
	 * @return 单条数据
	 */
	@GetMapping("selectOne")
	public String selectOne(Integer id) {

		if (id == null){
			return "{\"code\":201,\"message\":\"id为空\"}";
		}
		System.out.println("aaaaaaaaaaaa"+id);
		Testtest t = this.testtestService.queryById(id);
		return t == null ? "{\"code\":202,\"message\":\"查询结果为空\"}" : JSONObject.toJSONString(t);
	}

}