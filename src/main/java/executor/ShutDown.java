package executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ShutDown
{
  public static void main(String[] args)
  {
    ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
    Future<String> future = fixedThreadPool.submit(newCallable("Task1.1"));
    fixedThreadPool.shutdown(); // will wait until tasks are done
    try
    {
      System.out.println(future.get());
    }
    catch (InterruptedException | ExecutionException e)
    {
      throw new RuntimeException(e);
    }
  }

  private static Callable<String> newCallable(String message)
  {
    return () -> message + " : " + Thread.currentThread().getName();
  }
}
