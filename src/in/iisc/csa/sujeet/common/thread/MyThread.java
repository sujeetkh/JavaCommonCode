package in.iisc.csa.sujeet.common.thread;

class MyThread extends Thread {
	static String message[] = { "Java", "is", "hot,", "aromatic,", "and", "invigorating." };

	public MyThread(String id) {
		super(id);
	}

	public void run() {
		String name = getName();
		for (int i = 0; i < message.length; ++i) {
			randomWait();
			System.out.println(name + message[i]);
			System.out.println("Active Count: "+activeCount());
		}
	}

	void randomWait() {
		try {
			sleep((long) (3000 * Math.random()));
		} catch (InterruptedException x) {
			System.out.println("Interrupted!");
		}
	}
}