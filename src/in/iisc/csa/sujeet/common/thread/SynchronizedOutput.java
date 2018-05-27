package in.iisc.csa.sujeet.common.thread;

class SynchronizedOutput {
	public static synchronized void displayList(String name, String list[]) {
		for (int i = 0; i < list.length; ++i) {
			MyThread t = (MyThread) Thread.currentThread();
			t.randomWait();
			System.out.println(name + list[i]);
		}
	}
}
