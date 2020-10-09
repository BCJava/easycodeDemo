package cn.bcsoft.easycodedemo.entity;

import java.io.Serializable;

/**
 * @ClassName Person
 * @Description
 * 1、概念：
 * 序列化：对象，从内存到其他设备的过程
 * 反序列化：对象，从其他设备到内存的过程
 *
 * 2、条件：
 * 无论序列化和反序列化，都需要实现Serializable接口
 *
 * 3、Serializable接口：
 * 3.1、是一个标记性接口，没有任何需要实现的抽象方法
 * 3.2、标记性接口：一旦实现某个接口，就相当于属于了这个类型
 * Created by blackchen on 2020/10/9 14:02
 */
public class Person implements Serializable {
	private static final long serialVersionUID = 7188899827739954982L;

	private String name;
	private Integer age;

	public Person(String name, Integer age){
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
