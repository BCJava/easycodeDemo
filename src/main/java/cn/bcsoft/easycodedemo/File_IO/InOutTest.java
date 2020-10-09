package cn.bcsoft.easycodedemo.File_IO;

import java.io.*;
import java.util.Arrays;

/**
 * @ClassName InOutTest
 * @Description 字节输入输出流
 * Created by blackchen on 2020/10/9 10:50
 */
public class InOutTest {
	public static void main(String[] args) throws IOException {
		//InputStream: 抽象类，不能直接创建对象；根据不同的设备，有不同的具体子类
		//FileInputStream: 用于和磁盘交互的字节输入流
		FileInputStream stream = new FileInputStream("FileTest/Hello.txt");//定义一个输入字节流。

		System.out.println("available:"+stream.available());

		byte[] b = new byte[6];
		int n = stream.read(b);

		System.out.println("read:"+n);
		System.out.println("arrays"+Arrays.toString(b));

		//FileOutputStream: 写出到文件系统的文件的流对象
		File f = new File("FileTest/Hello.txt");

		f.createNewFile();
		FileOutputStream fos = new FileOutputStream(f,true);//创建一个输出到指定文件中的字节输出流，如果指定文件存在，append值为true，

//		fos.write('A');
//		fos.write('B');
//		fos.write('C');
//		fos.write('D');
//
//		byte[] b1 = {'a','b','?',2};
//		fos.write(b1);
//
//		fos.write(b1,2,2);
		//文件拷贝
		stream.close();
		fos.close();

		FileInputStream fis1 = new FileInputStream("FileTest/Hello.txt");

		long start = System.currentTimeMillis();//计时器
		System.out.println("开始:"+start);//输出结果

// 单次读写
//		FileOutputStream fos3 = new FileOutputStream("FileTest/Hello3.txt");
//
//		int n1 ;
//		while ((n1 = fis1.read()) != -1){//如果文件中还存在就写到n，如果不存在就返回-1
//			fos3.write(n1);//把n写入
//		}
//		long end1 = System.currentTimeMillis();
//		fos3.close();
//		System.out.println("n次:"+end1);//输出结果
//	数组读写
		FileOutputStream fos4 = new FileOutputStream("FileTest/Hello4.txt");

		byte[] bbb = new byte[fis1.available()];//准备的数组大小刚好等于文件长度。最合适的方法还是使用长度为1024的正整数倍的小数组来读写
		fis1.read(bbb);
		fos4.write(bbb);
		long end2 = System.currentTimeMillis();
		fos4.close();
		System.out.println("一次:"+end2);//输出结果

		fis1.close();

		FileInputStream fis = new FileInputStream("FileTest/Hello.txt");
		FileOutputStream fos1 = new FileOutputStream("FileTest/Hello1.txt");
/**
 * BufferedInputStream
 * 当调用read方法时，不是只读取了一个字节，而是一次读取了8192个字节，存储在流对象自己内部维护的缓冲区数组中，拿出了其中第一个字节返回给调用者；
 * 如果第二次再调用read方法，不需要再次去磁盘中读取字节信息了，只需要从内存的数组中取出第二个字节返回即可，
 * 减少了和磁盘交互次数8191次，提升了效率
 *
 * BufferedOutputStream
 * 当调用write方法时，不是直接将一个字节写出到磁盘，将该字节写出到BufferedOutputStream自己对象维护的一个私有字节数组中，数组的大小为8192字节，
 * 等到数组被写满，自动将数组中的数据一次性刷新到目标文件去，
 * 减少了和磁盘交互的次数，提升了效率。
 */
		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedOutputStream bos = new BufferedOutputStream(fos1);

		int c ;

		while ((c = bis.read()) != -1){
			bos.write(c);
		}

		bis.close();
		bos.close();
	}
}
