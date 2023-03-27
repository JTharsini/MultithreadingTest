package deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockByLocksFixedDemo
{
  public static void main(String[] args)
  {
    Lock lock1 = new ReentrantLock();
    Lock lock2 = new ReentrantLock();

    Runnable1WithLocksFixed runnable1WithLocksFixed = new Runnable1WithLocksFixed(lock1, lock2);
    Runnable2WithLocksFixed runnable2WithLocksFixed = new Runnable2WithLocksFixed(lock1, lock2);

    new Thread(runnable1WithLocksFixed).start();
    new Thread(runnable2WithLocksFixed).start();
  }
}
