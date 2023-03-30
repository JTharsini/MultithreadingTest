package deadlock.prevention;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockReorderingDemo
{
  public static void main(String[] args)
  {
    Lock lock1 = new ReentrantLock();
    Lock lock2 = new ReentrantLock();

    Runnable1LockReordering runnable1LockReordering = new Runnable1LockReordering(lock1, lock2);
    Runnable2LockReordering runnable2LockReordering = new Runnable2LockReordering(lock1, lock2);

    new Thread(runnable1LockReordering).start();
    new Thread(runnable2LockReordering).start();
  }
}
