package blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class EnqueueMethodsDemo
{
  public static void main(String[] args)
  {
    BlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(3);
    EnqueueMethods.enqueMethods(arrayBlockingQueue, true);
  }
}
