package blockingQueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable
{
  private BlockingQueue<String> blockingQueue;

  public Consumer(BlockingQueue<String> blockingQueue)
  {
    this.blockingQueue = blockingQueue;
  }

  @Override
  public void run()
  {
    while (true)
    {
      try
      {
        String element = this.blockingQueue.take();
        System.out.println(element);
      }
      catch (InterruptedException e)
      {
        System.out.println("Consumer was interrupted");
      }
      sleep(1000);
    }
  }

  private void sleep(long millis)
  {
    try
    {
      Thread.sleep(millis);
    }
    catch (InterruptedException e)
    {
      System.out.println("Interrupted while sleeping");
    }
  }
}
