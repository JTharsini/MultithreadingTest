package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockUsage
{
  public static void main(String[] args)
  {
    // Lock is an interface
    Lock lock = new ReentrantLock();
    Lock fairLock = new ReentrantLock(true);
    lock.lock();

    // do something

    lock.unlock();
  }
}
