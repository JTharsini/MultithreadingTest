package deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockDemoByLocks
{
  public static void main(String[] args)
  {
    Lock lock1 = new ReentrantLock();
    Lock lock2 = new ReentrantLock();

    Runnable1WithLocks runnable1WithLocks = new Runnable1WithLocks(lock1, lock2);
    Runnable2WithLocks runnable2WithLocks = new Runnable2WithLocks(lock1, lock2);

    new Thread(runnable1WithLocks).start();
    new Thread(runnable2WithLocks).start();
  }
}
