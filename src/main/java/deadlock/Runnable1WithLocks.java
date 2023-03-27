package deadlock;

import java.util.concurrent.locks.Lock;

public class Runnable1WithLocks implements Runnable
{
  private Lock lock1 = null;
  private Lock lock2 = null;

  public Runnable1WithLocks(Lock lock1, Lock lock2)
  {
    this.lock1 = lock1;
    this.lock2 = lock2;
  }

  @Override
  public void run()
  {
    String threadName = Thread.currentThread().getName();
    System.out.println(threadName + " attempting to lock lock1");
    lock1.lock();
    System.out.println(threadName + " locked lock1");

    try
    {
      Thread.sleep(3000);
    }
    catch (InterruptedException e)
    {
      // ignore
    }

    System.out.println(threadName + " attempting to lock lock2");
    lock2.lock();
    System.out.println(threadName + " locked lock2");
  }
}
