package blockingQueue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class DrainMethodsDemo
{
  public static void main(String[] args)
  {
    BlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
    EnqueueMethods.enqueMethods(arrayBlockingQueue, false);

    Collection<String> dest = new ArrayList<>();

    arrayBlockingQueue.drainTo(dest, 1);
    for (String s : dest)
    {
      System.out.println(s);
    }
    System.out.println("***************");
    for (String s : arrayBlockingQueue)
    {
      System.out.println(s);
    }
    System.out.println("***************");
    arrayBlockingQueue.drainTo(dest);

    for (String s : dest)
    {
      System.out.println(s);
    }
    System.out.println("***************");
    for (String s : arrayBlockingQueue)
    {
      System.out.println(s);
    }
    System.out.println("***************");
  }
}
