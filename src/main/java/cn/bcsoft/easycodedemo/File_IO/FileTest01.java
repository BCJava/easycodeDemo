package cn.bcsoft.easycodedemo.File_IO;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @ClassName FileTest01
 * @Description File练习。
 * Created by blackchen on 2020/10/9 10:15
 */
public class FileTest01 {
	public static void main(String[] args) throws IOException {
		File file = new File("FileTest");//文件夹路径
//		1.创建一个文件或文件夹
//		不取决于路径名称,取决于调用的什么方法去创建
//		file.mkdir(); //创建文件夹，如果父级路径不存在，则文件夹创建失败
		file.mkdirs(); //创建文件夹，如果父级路径不存在，则自动创建父级路径，再创建子级路径

//		2.创建文件
		File file1 = new File(file, "HelloWorld.txt");
		file1.createNewFile();

//		3.删除
//		File_IO.delete();//既可以删除文件，也可以删除文件夹 注意事项： 1、删除的时候不走回收站，直接删除 2、不能删除非空文件夹
//
//		4.重命名
		File dest = new File(file, "Hello.txt");
		//		注意事项： 1、方法的调用者，是一个File对象，方法的参数是另外一个File对象
//		2、调用者是当前修改之前的路径对象，参数是要修改为的路径对象
//		3、如果改了父级路径，就是剪切，如果不改父级路径就是重命名
		file1.renameTo(dest);

//		5.判断功能
		System.out.println(file.exists());//判断调用者路径是否存在
		System.out.println(file.isFile());//判断调用者是否是一个文件
		System.out.println(file.isDirectory());//判断调用者是否是一个文件夹

//		6.获取功能
/**
 * 1、获取路径三个方法：
 * 	getName()
 *  	 	获取最短的那个文件或者文件夹名称
 *  	getPath()
 *  	 	获取相对路径，构造方法中传入的那个字符串
 *  	getAbsolutePath()
 *  	 	获取绝对路径

 * 2、获取文件或者文件夹属性的方法
 * 	length()
 *  	 	获取文件的字节个数
 *  	 	只能针对文件使用，不能针对文件夹使用
 *  	lastModified()
 *  	 	获取文件的最后修改时间

 * 3、获取文件夹中内容的方法
 *  	String[] list()
 *  	 	返回文件夹中的所有内容的名称（不包含子文件夹中的内容）
 *  	File[] listFiles()
 *  	 	返回文件夹中的所有内容的File对象（不包含子文件夹中的内容）
 *  	注意事项：
 *  	 	这两个方法只能针对文件夹使用，不能针对文件使用
 */

//		练习：定义一个方法：键盘录入一个字符串，表示一个文件夹路径，如果不是文件夹路径则提示重新录入
		Scanner sc = new Scanner(System.in);
		String path = sc.next();
		File f = new File(path);
		if (f.isDirectory() && f.exists()){
			System.out.println("录入成功");
		}else {
			System.out.println("请重新录入");
		}
	}
}
