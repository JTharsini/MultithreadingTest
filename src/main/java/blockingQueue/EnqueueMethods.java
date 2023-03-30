package blockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class EnqueueMethods
{
  public static void enqueMethods(BlockingQueue<String> arrayBlockingQueue, boolean print)
  {
    try
    {
      arrayBlockingQueue.put("element1");
    }
    catch (InterruptedException e)
    {
      if (print)
      {
        e.printStackTrace();
      }
    }

    try
    {
      arrayBlockingQueue.add("element2");
    }
    catch (IllegalStateException e)
    {
      if (print)
      {
        System.out.println("no space inside blocking queue");
      }
    }

    boolean wasEnqueuedSuccess = arrayBlockingQueue.offer("element3");
    if (print)
    {
      System.out.println(wasEnqueuedSuccess);
    }
    boolean wasEnqueuedFailed = arrayBlockingQueue.offer("element4");
    if (print)
    {
      System.out.println(wasEnqueuedFailed);
    }

    try
    {
      boolean wasEnqueuedWithTimeoutSuccess = arrayBlockingQueue.offer("element5", 1000, TimeUnit.MILLISECONDS);
      if (print)
      {
        System.out.println(wasEnqueuedWithTimeoutSuccess);
      }
    }
    catch (InterruptedException e)
    {
      if (print)
      {
        System.out.println("no space inside blocking queue with the timeout");
      }
    }
  }
}
