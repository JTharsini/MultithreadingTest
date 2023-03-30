package blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class AdditionalMethodsDemo
{
  public static void main(String[] args)
  {
    BlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
    EnqueueMethods.enqueMethods(arrayBlockingQueue, false);

    System.out.println(arrayBlockingQueue.size());
    System.out.println(arrayBlockingQueue.remainingCapacity());
    System.out.println(arrayBlockingQueue.contains("element1"));
    System.out.println(arrayBlockingQueue.contains("Element1"));
  }
}
