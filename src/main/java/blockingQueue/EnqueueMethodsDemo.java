package blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class EnqueueMethodsDemo
{
  public static void main(String[] args)
  {
    BlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(3);

    try
    {
      arrayBlockingQueue.put("element1");
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }

    try
    {
      arrayBlockingQueue.add("element2");
    }
    catch (IllegalStateException e)
    {
      System.out.println("no space inside blocking queue");
    }

    boolean wasEnqueuedSuccess = arrayBlockingQueue.offer("element3");
    System.out.println(wasEnqueuedSuccess);

    boolean wasEnqueuedFailed = arrayBlockingQueue.offer("element4");
    System.out.println(wasEnqueuedFailed);

    try
    {
      boolean wasEnqueuedWithTimeoutSuccess = arrayBlockingQueue.offer("element5", 1000, TimeUnit.MILLISECONDS);
      System.out.println(wasEnqueuedWithTimeoutSuccess);
    }
    catch (InterruptedException e)
    {
      System.out.println("no space inside blocking queue with the timeout");
    }
  }
}
