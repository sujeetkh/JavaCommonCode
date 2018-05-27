package in.iisc.csa.sujeet.common.thread;

public class TestParallel {
	public static void main(String args[]) {
		// MyThread thread1 = new MyThread("thread1: ");
		// MyThread thread2 = new MyThread("thread2: ");
		Thread thread1 = new Thread(new MyClass("thread1: "));
		Thread thread2 = new Thread(new MyClass("thread2: "));
		thread1.start();
		thread2.start();
		boolean thread1IsAlive = true;
		boolean thread2IsAlive = true;
		do {
			if (thread1IsAlive && !thread1.isAlive()) {
				thread1IsAlive = false;
				System.out.println("Thread 1 is dead.");
			}
			if (thread2IsAlive && !thread2.isAlive()) {
				thread2IsAlive = false;
				System.out.println("Thread 2 is dead.");
			}
		} while (thread1IsAlive || thread2IsAlive);
	}
}
