package blockingQueue;

import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class PeekAndElementMethodsDemo
{
  public static void main(String[] args)
  {
    BlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
    EnqueueMethods.enqueMethods(arrayBlockingQueue, false);

    try
    {
      String peek = arrayBlockingQueue.peek();
      System.out.println(peek);
      BlockingQueue<String> emptyArrayBlockingQueue = new ArrayBlockingQueue<>(3);
      System.out.println(emptyArrayBlockingQueue.peek());
    }
    catch (NoSuchElementException e)
    {
      System.out.println("BlockingQueue is empty");
    }

    try
    {
      String element = arrayBlockingQueue.element();
      System.out.println(element);
      BlockingQueue<String> emptyArrayBlockingQueue = new ArrayBlockingQueue<>(3);
      System.out.println(emptyArrayBlockingQueue.element());
    }
    catch (NoSuchElementException e)
    {
      System.out.println("BlockingQueue is empty");
    }
  }
}
