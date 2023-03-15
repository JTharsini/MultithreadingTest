package lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLock
{
  public static void main(String[] args)
  {
    Lock lock = new ReentrantLock();
    try
    {
      //boolean success = lock.tryLock();
      boolean success = lock.tryLock(1000, TimeUnit.MILLISECONDS);
      System.out.println("try lock: " + success);
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
}
