package chapterOne.t12;

import java.io.FileOutputStream;

public class Run {

	public static void main(String[] args) {
		FileOutputStream fo;
		try {
			fo=new FileOutputStream("console.txt");
			MyThread thread=new MyThread();
			//����һ�����̣߳����̻߳�ִ����Ӧ��run()������start()���ܱ��ظ�����
			//����run()���������Ա��ظ����ã����ڵ�ǰ�߳���ִ��run()�������������߳�
			thread.start();
			Thread.sleep(1000);
			//interrupt()�жϵ���thread�߳�
			thread.interrupt();
			String str1="interrupted:";
			String str2="isinterrupted:";
			/*
			 * thread.interruptted()�жϵ��ǵ�ǰ���̣߳�������ָthread������̬������
			 * ��ǰ�̣߳���Ȼ����main��ִ�еĸ���䣬��ǰ�߳̾���main�̣߳���Ҫ�ǿ����������ִ��
			 * ʹ��Thread.currentThread().interrupt()�жϵ��ǵ�ǰ���߳�
			 * ʹ��thread.isinterruptted()�жϵ���thread�̱߳��������Ǿ�̬������
			 */
			//ִ��isInterrupted()�󲻻������жϱ�־λ
			System.out.println(thread.isInterrupted());
			System.out.println(thread.isInterrupted());
			str1+=thread.interrupted();
			str2+=thread.interrupted();
			Thread.currentThread().interrupt();
			//ִ��interrupted()��������ж�λ����ִ�к���������ж�λ����ô�ڶ���ִ��ʱ�᷵��false
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
