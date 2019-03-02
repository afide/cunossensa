class MyThread {
    private static class MyRunnable implements Runnable {
        MyObject o;
        MyRunnable(MyObject o) {
            this.o = o;
        }
        public void run() {
            o.foo();
        }
    }
    private static class MyObject {
        int counter = 0;
        synchronized void foo() {
            try {
                while (counter < 6) {
                    Thread.sleep(500);
                    counter++;
                }
            } catch (InterruptedException ignore) {
                // Ignore
            }
        }
    }
    public static void main(String[] args) {
        // Same reference to obj; only one will be allowed to call foo and the other will be forced to wait
        MyObject obj = new MyObject();
        MyRunnable instance1 = new MyRunnable(obj);
        MyRunnable instance2 = new MyRunnable(obj);
        Thread thread1 = new Thread(instance1);
        Thread thread2 = new Thread(instance2);
        thread1.start();
        thread2.start();
        // Waits until above thread counts to 6 (slowly)
        while (instance1.o.counter != 5) {
            System.out.print(instance1.o.counter);
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (instance2.o.counter != 5) {
            System.out.print(instance2.o.counter);
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}