package chapterOne.t15;

public class Run {

	public static void main(String[] args) {
		try {
			MyThread thread=new MyThread();
			thread.start();
			Thread.sleep(200);
			/*
			 * 1.main�̺߳�thread�߳�ִ��sleep��main�̻߳����ѹ�����Ȼ��ִ��������ж����
			 * ���µĽ���ǣ�thread����˯��ʱ����main�̸߳��ж���
			 * ���׳��ж��쳣
			 * 2.��thread�Ѿ��ж��ˣ�Ȼ��������ִ��sleep()��ͬ���ᷢ���ж��쳣
			 * ������ǵ��ж�λΪtrueʱ��sleep�ͻ����ж��쳣
			 */
			thread.interrupt();
		} catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("main catch");
			e.printStackTrace();
		}
	}
}
