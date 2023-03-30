package blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemo
{
  public static void main(String[] args)
  {
    // BlockingQueue is an interface.
    BlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(3);

    try
    {
      arrayBlockingQueue.put("element1");
      arrayBlockingQueue.put("element2");
      arrayBlockingQueue.put("element3");
      //arrayBlockingQueue.put("element4"); // if this is uncommented it will be blocked until
      // an element to be dequeued
    }
    catch (InterruptedException e)
    {
      System.out.println("Interrupted");
    }

    try
    {
      String element1 = arrayBlockingQueue.take();
      System.out.println(element1);
      String element2 = arrayBlockingQueue.take();
      System.out.println(element2);
      String element3 = arrayBlockingQueue.take();
      System.out.println(element3);
      //String element4 = arrayBlockingQueue.take();  // if this is uncommented it will be blocked until
      // any element is enqueued into the queue
    }
    catch (InterruptedException e)
    {
      throw new RuntimeException(e);
    }
  }
}
