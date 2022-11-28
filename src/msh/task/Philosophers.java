package msh.task;

public class Philosophers {
	public static void main(String[] args) throws Exception {

		Philosopher[] philosophers = new Philosopher[5];
		Object[] forks = new Object[philosophers.length];

		for (int i = 0; i < forks.length; i++) {
			forks[i] = new Object();
		}
		
		philosophers[0] = new Philosopher(forks[1], forks[0]);
		Thread t = new Thread(philosophers[0], "Philosopher " + 1);
		t.start();
		
		for (int i = 1; i < philosophers.length; i++) {
			Object leftFork = forks[i];
			Object rightFork = forks[(i + 1) % forks.length];
			philosophers[i] = new Philosopher(leftFork, rightFork);
			t = new Thread(philosophers[i], "Philosopher " + (i + 1));
			t.start();
		}
	}

	static class Philosopher implements Runnable {

		private final Object leftFork;
		private final Object rightFork;

		public Philosopher(Object leftFork, Object rightFork) {
			this.leftFork = leftFork;
			this.rightFork = rightFork;
		}

		private void doAction(String action) throws InterruptedException {
			System.out.println(Thread.currentThread().getName() + " " + action);
			Thread.sleep(((int) (Math.random() * 10)));
		}

		@Override
		public void run() {
			try {
				while (true) {
					// thinking
					doAction(System.nanoTime() + ": Thinking");
					synchronized (leftFork) {
						doAction(System.nanoTime() + ": Picked up left fork");
						synchronized (rightFork) {
							// eating
							doAction(System.nanoTime() + ": Picked up right fork - eating");

							doAction(System.nanoTime() + ": Put down right fork");
						}
						// Back to thinking
						doAction(System.nanoTime() + ": Put down left fork. Back to thinking");
					}
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}
}