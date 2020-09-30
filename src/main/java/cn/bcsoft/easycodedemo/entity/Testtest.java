package cn.bcsoft.easycodedemo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 测试库(Testtest)实体类
 *
 * @author blackchen
 * @since 2020-09-10 14:12:22
 */
public class Testtest implements Serializable {
	private static final long serialVersionUID = -55285669979624532L;
	/**
	 * id
	 */
	private Integer testId;
	/**
	 * 名字
	 */
	private String name;
	/**
	 * 文字描述
	 */
	private String text;
	/**
	 * 最后修改时间
	 */
	private Date date;


	public Integer getTestId() {
		return testId;
	}

	public void setTestId(Integer testId) {
		this.testId = testId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}