package cn.bcsoft.easycodedemo.File_IO;

import cn.bcsoft.easycodedemo.entity.Person;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @ClassName ReadWriterTest
 * @Description 高效缓存流
 * Created by blackchen on 2020/10/9 12:06
 */
public class ReadWriterTest {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
//		1.字符输入流
		FileReader fr =new FileReader("FileTest/Hello.txt");
		int c;
		while ((c = fr.read()) != -1){//读取一个完整的字符，如果返回-1表示到达文件末尾
			System.out.print((char) c);
		}

//		字符输出流
		File file = new File("FileTest/Hello1.txt");
		FileWriter fw = new FileWriter(file);
		fw.write("你好你好");
		fw.write('a');
		fw.close();

//		3.拷贝

//		4.转换流--仍然是字符流，只不过是能通过指定的编码表在字节和字符之间转换
		File f = new File("FileTest/Hello3.txt");
////		字节流到字符流的转换
//		InputStreamReader isr = new InputStreamReader(new FileInputStream(f),"Gbk");
////		字符流到字节流的转换
//		OutputStreamWriter osr = new OutputStreamWriter(new FileOutputStream("FileTest/hello5.txt"),"utf-8");
////		GBK编码形式的文本文档转换成了UTF-8形式。
//		int n;
//		while ((n = isr.read()) != -1){
//			osr.write(n);
//		}
//
//		isr.close();
//		osr.close();

//		5.内存输出流 ByteArrayOutputStream
//1、是OutputStream的子类，可以直接使用字节输出流的全部方法
//2、本身是内存中的流，不算真正意义上的I/O
//3、本质：用于缓存不完整字节信息的一个缓冲区
//		FileInputStream fis = new FileInputStream(f);
//		ByteOutputStream bos = new ByteOutputStream();
//
//		byte[] b = new byte[3];
//
//		int len;
//		while ((len = fis.read(b)) != -1){
//			bos.write(b,0,len);
//		}
//
//		System.out.println("ByteOutputStream:"+bos.toString());
//		System.out.println(Arrays.toString(bos.toByteArray()));

//		6.对象操作流--可以直接写出和读取对象的流
//		Person p = new Person("xiaoming",12);
//		Person p2 = new Person("xiaohong",13);
//		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));//对象输出流
//		oos.writeObject(p);//分别将两个对象写入文件
//		oos.writeObject(p2);
//		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));//对象输入流
//
//		Object o = ois.readObject();//读取对象，读取为Object类型
//		System.out.println("writeObject:"+o.toString());//因为子类重写了toString方法
//		oos.close();
//		ois.close();
//
////		序列化
		f = new File("FileTest/Hello6.txt");
//		oos = new ObjectOutputStream(new FileOutputStream(f));//对象输出流
//		ois = new ObjectInputStream(new FileInputStream(f));//对象输入流
//		ArrayList<Person> al = new ArrayList<>();
//		Collections.addAll(al, new Person("xiaoming",10),
//							   new Person("xiaohong",20));
//
//		oos.writeObject(al);
//		oos.close();
//
////		反序列化
//		o = ois.readObject();
//	 	al = (ArrayList<Person>) o ;
//
//		System.out.println("反序列化:"+al.get(0).toString());
//		System.out.println("反序列化1:"+al.get(1).toString());
//
//		ois.close();

////		7.随机读写流-RandomAccessFile 1、不属于流的体系 2、不仅可以读，还可以写 3、支持随机读写
//		f = new File("FileTest/Hello7.txt");
//		RandomAccessFile rf = new RandomAccessFile(f,"rw");
//		rf.seek(0);//随机的设定要访问的文件位置
//		int n = rf.read();
//		System.out.println("随机读写流:"+(char) n);
//
//		rf.seek(20);
//		rf.write('A');
//		System.out.println("随机读写流:"+(char) n);
//
//		rf.close();

//		8.打印流
		/**
		 * PrintStream是字节流，没有缓冲区，PrintWriter是Writer的子类，因此具有缓冲区，有了刷新的操作；
		 * PrintWriter具有自动刷新的功能：
		 * 1、使用具有刷新功能的构造方法：
		 * PrintWriter(OutputStream os, boolean autoFlush)
		 * PrintWriter(Writer w, boolean autoFlush)
		 * 可以将一个普通的字节输出流或者字符输出流，加强为一个具有自动刷新 功能的打印流对象（第二个参数必须为：true）
		 * 2、使用带有自动刷新的写出方法
		 * Println
		 */
		PrintStream ps = System.out;
		ps.println("sout:"+97);
//		打印字节流
		PrintStream ps2 = new PrintStream("FileTest/c.txt");
		ps2.write(108);
		ps2.println(97);
		ps2.close();
//		打印字符流
		PrintWriter pw = new PrintWriter(new FileOutputStream("FileTest/d.txt"), true);
		pw.write("abc");
		pw.print("def");
		pw.println("xyz");
	}
}
