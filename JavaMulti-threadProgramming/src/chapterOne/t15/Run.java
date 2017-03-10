package chapterOne.t15;

public class Run {

	public static void main(String[] args) {
		try {
			MyThread thread=new MyThread();
			thread.start();
			Thread.sleep(200);
			/*
			 * 1.main线程和thread线程执行sleep后，main线程会先醒过来，然后执行下面的中断语句
			 * 导致的结果是，thread正在睡眠时，被main线程给中断了
			 * 会抛出中断异常
			 * 2.当thread已经中断了，然后在其中执行sleep()，同样会发生中断异常
			 * 其机理是当中断位为true时，sleep就会抛中断异常
			 */
			thread.interrupt();
		} catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("main catch");
			e.printStackTrace();
		}
	}
}
