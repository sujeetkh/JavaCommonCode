package in.iisc.csa.sujeet.common.thread;

class MyClass implements Runnable {
	static String message[] = { "Java", "is", "hot,", "aromatic,", "and", "invigorating." };
	String name;

	public MyClass(String id) {
		name = id;
	}

	public void run() {
		for (int i = 0; i < message.length; ++i) {
			randomWait();
			System.out.println(name + message[i]);
			System.out.println("Active Count: "+Thread.currentThread().activeCount());
		}
	}

	void randomWait() {
		try {
			Thread.currentThread().sleep((long) (3000 * Math.random()));
		} catch (InterruptedException x) {
			System.out.println("Interrupted!");
		}
	}
}
