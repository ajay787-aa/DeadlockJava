public class Main {
    public static void main(String[] args) {
        Object lock1=new Object();
        Object lock2=new Object();
        Thread t= new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock1){
                    System.out.println("we have lock 1");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("waiting for lock 2");
                    synchronized (lock2){
                        System.out.println("we have lock 2");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        });
        t.start();
        Thread t2= new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock2){
                    System.out.println("we have lock 2");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("waiting for lock 1");
                    synchronized (lock1){
                        System.out.println("we have lock 1");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        });
        t2.start();

    }
}
