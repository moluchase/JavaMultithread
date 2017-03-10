package chapterOne.t12;

import java.io.FileOutputStream;

public class Run {

	public static void main(String[] args) {
		FileOutputStream fo;
		try {
			fo=new FileOutputStream("console.txt");
			MyThread thread=new MyThread();
			//启动一个新线程，新线程会执行相应的run()方法，start()不能被重复调用
			//调用run()方法，可以被重复调用，会在当前线程中执行run()，不会启动新线程
			thread.start();
			Thread.sleep(1000);
			//interrupt()中断的是thread线程
			thread.interrupt();
			String str1="interrupted:";
			String str2="isinterrupted:";
			/*
			 * thread.interruptted()判断的是当前的线程，而不是指thread本身（静态方法）
			 * 当前线程，既然是在main中执行的该语句，则当前线程就是main线程，主要是看该语句在哪执行
			 * 使用Thread.currentThread().interrupt()中断的是当前的线程
			 * 使用thread.isinterruptted()判断的是thread线程本身，（不是静态方法）
			 */
			//执行isInterrupted()后不会消除中断标志位
			System.out.println(thread.isInterrupted());
			System.out.println(thread.isInterrupted());
			str1+=thread.interrupted();
			str2+=thread.interrupted();
			Thread.currentThread().interrupt();
			//执行interrupted()后如果有中断位，当执行后会消除该中断位，那么第二次执行时会返回false
			System.out.println(thread.interrupted());
			System.out.println(thread.interrupted());
			byte[] bs=str1.getBytes();
			fo.write(bs);
			bs=str2.getBytes();
			fo.write(bs);
			fo.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
