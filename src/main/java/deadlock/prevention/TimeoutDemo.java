package deadlock.prevention;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TimeoutDemo
{
  public static void main(String[] args)
  {
    Lock lock1 = new ReentrantLock();
    Lock lock2 = new ReentrantLock();

    Runnable1Timeout runnable1Timeout = new Runnable1Timeout(lock1, lock2);
    Runnable2Timeout runnable2Timeout = new Runnable2Timeout(lock1, lock2);

    new Thread(runnable1Timeout).start();
    new Thread(runnable2Timeout).start();
  }
}
