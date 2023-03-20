package executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SubmitWithCallable
{
  public static void main(String[] args)
  {
    ExecutorService fixedThreadPool = Executors.newFixedThreadPool(1);
    Future<String> future = fixedThreadPool.submit(newCallable("Task1.1"));
    System.out.println(future.isDone()); // once task is done, future.isDone() will become true

    try
    {
      System.out.println(future.get());
    }
    catch (InterruptedException | ExecutionException e)
    {
      e.printStackTrace();
    }
    System.out.println(future.isDone());
    fixedThreadPool.shutdown();
  }

  private static Callable<String> newCallable(String message)
  {
    return () -> message + " : " + Thread.currentThread().getName();
  }
}
