package executor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ShutDownNow
{
  public static void main(String[] args)
  {
    ExecutorService fixedThreadPool = Executors.newFixedThreadPool(1);
    fixedThreadPool.submit(newRunnable("Task1.1"));
    List<Runnable> runnables = fixedThreadPool.shutdownNow();
    try
    {
      boolean awaitTermination = fixedThreadPool.awaitTermination(3000L, TimeUnit.MILLISECONDS);
      System.out.println(awaitTermination);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }

  private static Runnable newRunnable(String message)
  {
    return () -> System.out.println(message + " : " + Thread.currentThread().getName());
  }
}
