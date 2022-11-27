package msh.task;

import java.util.concurrent.locks.ReentrantLock;

public class Philosophers {
    public static void main(String[] args) throws Exception {
    	
        Philosopher[] philosophers = new Philosopher[5];
        ReentrantLock[] forks = new ReentrantLock[philosophers.length];
        
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new ReentrantLock();
        }
        for (int i = 0; i < philosophers.length; i++) {
        	ReentrantLock leftFork = forks[i];
        	ReentrantLock rightFork = forks[(i + 1) % forks.length];
            philosophers[i] = new Philosopher(leftFork, rightFork);
            Thread t = new Thread(philosophers[i], "Philosopher " + (i + 1));
            t.start();
        }
    }
    static class Philosopher implements Runnable {

        private final ReentrantLock leftFork;
        private final ReentrantLock rightFork;

        public Philosopher(ReentrantLock leftFork, ReentrantLock rightFork) {
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
                    doAction(System.nanoTime() + ": Thinking");
                    leftFork.tryLock();
                    try {
						doAction(System.nanoTime() + ": Picked up left fork");                        
						doAction(System.nanoTime() + ": Put down left fork. Back to thinking");
					} finally {
						 leftFork.unlock();
					} 
                    rightFork.tryLock();
                    try {
						doAction(System.nanoTime() + ": Picked up right fork - eating");
						doAction(System.nanoTime() + ": Put down right fork");
					} finally {
						rightFork.unlock();
					} 
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

