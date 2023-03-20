package executor;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Cancel
{
  public static void main(String[] args)
  {
    ExecutorService fixedThreadPool = Executors.newFixedThreadPool(1);
    Future<String> future = fixedThreadPool.submit(newCallable("Task1.1"));
    System.out.println("future.isDone(): " + future.isDone());

    boolean mayInterrupt = true;
    boolean cancel = future.cancel(mayInterrupt);
    System.out.println("future.cancel(mayInterrupt): " + cancel);

    try
    {
      System.out.println("future.get(): " + future.get());
    }
    catch (InterruptedException | ExecutionException e)
    {
      e.printStackTrace();
    }
    catch (CancellationException e)
    {
      System.out.println("Task is cancelled");
    }
    System.out.println("future.isDone(): " + future.isDone());
    System.out.println("future.isCancelled(): " + future.isCancelled());
    fixedThreadPool.shutdown();
  }

  private static Callable<String> newCallable(String message)
  {
    return () -> message + " : " + Thread.currentThread().getName();
  }
}
