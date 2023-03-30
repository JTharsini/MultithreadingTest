package blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class DequeueMethodsDemo
{
  public static void main(String[] args)
  {
    BlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
    EnqueueMethods.enqueMethods(arrayBlockingQueue, false);
    try
    {
      String take = arrayBlockingQueue.take();
      System.out.println(take);
      System.out.println(arrayBlockingQueue.take());
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }

    String pollReturnValue = arrayBlockingQueue.poll();
    System.out.println(pollReturnValue);
    String pollReturnNull = arrayBlockingQueue.poll();
    System.out.println(pollReturnNull);

    try
    {
      String pollingWithTimeout = arrayBlockingQueue.poll(1000, TimeUnit.MILLISECONDS);
      System.out.println(pollingWithTimeout);
    }
    catch (InterruptedException e)
    {
      System.out.println("no element in blocking queue with the timeout");
    }

    boolean remove = arrayBlockingQueue.remove("element1");
    System.out.println(remove);
  }
}
