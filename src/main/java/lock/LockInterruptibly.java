package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockInterruptibly
{
  public static void main(String[] args)
  {
    Lock lock = new ReentrantLock();
    //Thread.currentThread().interrupt(); // thread is interrupted itself
    try
    {
      lock.lockInterruptibly();
      System.out.println("Lock!");
      lock.unlock();
    }
    catch (InterruptedException e)
    {
      System.out.println("Interrupted!");
    }

  }
}
