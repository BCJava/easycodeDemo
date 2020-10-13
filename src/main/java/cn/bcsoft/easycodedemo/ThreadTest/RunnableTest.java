package cn.bcsoft.easycodedemo.ThreadTest;

/**
 * @ClassName RunnableTest
 * @Description 实现 Runnable 接口
 * Created by blackchen on 2020/10/13 10:02
 */
public class RunnableTest implements Runnable{ //实现Runnable接口,作为线程的实现类
	private String name;
	public RunnableTest (String name){
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(name + " 运行, i = " + i);
		}
	}

	public static void main(String[] args) {

		RunnableTest test1 = new RunnableTest("线程A");
		RunnableTest test2 = new RunnableTest("线程B");

		Thread t1 = new Thread(test1);
		Thread t2 = new Thread(test2);

		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);

		t1.start();
		t2.start();

	}
}
