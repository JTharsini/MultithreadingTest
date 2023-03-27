package deadlock;

public class Runnable1WithSynchronized implements Runnable
{
  private final Object object1;
  private final Object object2;

  public Runnable1WithSynchronized(final Object object1, final Object object2)
  {
    this.object1 = object1;
    this.object2 = object2;
  }

  @Override
  public void run()
  {
    String threadName = Thread.currentThread().getName();
    System.out.println(threadName + " attempting to lock lock1");
    synchronized (object1)
    {
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
      synchronized (object2)
      {
        System.out.println(threadName + " locked lock2");
      }
    }
  }
}
