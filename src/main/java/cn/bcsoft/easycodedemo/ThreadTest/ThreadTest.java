package cn.bcsoft.easycodedemo.ThreadTest;

/**
 * @ClassName ThreadTest
 * @Description TODO
 * Created by blackchen on 2020/10/13 10:12
 */
public class ThreadTest extends Thread{
	private String name ;       // 表示线程的名称
	public ThreadTest(String name){
		this.name = name ;      // 通过构造方法配置name属性
	}
	public void run(){  // 覆写run()方法，作为线程 的操作主体
		for(int i=0;i<10;i++){
			System.out.println(name + "运行，i = " + i) ;
		}
	}

	public static void main(String[] args) {
		ThreadTest mt1 = new ThreadTest("线程A ") ;    // 实例化对象
		ThreadTest mt2 = new ThreadTest("线程B ") ;    // 实例化对象
		mt1.start() ;   // 调用线程主体
		mt2.start() ;   // 调用线程主体
	}
}
