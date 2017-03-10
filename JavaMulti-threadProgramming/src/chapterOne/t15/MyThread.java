package chapterOne.t15;

public class MyThread extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			System.out.println("run begin");
			Thread.sleep(20000);//当前的线程进行睡眠
			System.out.println("run end");
		} catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("在沉睡中被停止");
		}
	}
}
