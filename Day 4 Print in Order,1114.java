import java.util.concurrent.CountDownLatch;

class Foo {
    private final CountDownLatch latch1;
    private final CountDownLatch latch2;

    public Foo() {
        // Initialize latches with a count of 1
        latch1 = new CountDownLatch(1);
        latch2 = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        
        // Decrement the count, releasing any thread waiting on latch1
        latch1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        // Wait until latch1 is counted down to 0 (after first() runs)
        latch1.await();
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        
        // Decrement the count, releasing any thread waiting on latch2
        latch2.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        // Wait until latch2 is counted down to 0 (after second() runs)
        latch2.await();
        
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
