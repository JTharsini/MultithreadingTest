package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo
{
  public static void main(String[] args)
  {
    lockBasics();
  }

  private static void lockBasics()
  {
    Lock lock = new ReentrantLock(true);
    Runnable runnable = () -> lockSleepUnlock(lock, 1000);

    Thread thread1 = new Thread(runnable, "Thread1");
    Thread thread2 = new Thread(runnable, "Thread2");
    Thread thread3 = new Thread(runnable, "Thread3");

    thread1.start();
    thread2.start();
    thread3.start();
  }

  private static void lockSleepUnlock(Lock lock, long timeMillis)
  {
    try
    {
      lock.lock();
      printThreadMsg("hold the lock.");
      Thread.sleep(timeMillis);
    }
    catch (InterruptedException e)
    {
      throw new RuntimeException(e);
    }
    finally
    {
      lock.unlock();
    }
  }

  private static void printThreadMsg(String message)
  {
    System.out.println(Thread.currentThread().getName() + message);
  }
}
