package executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecuteVsSubmitWithRunnable
{
  public static void main(String[] args)
  {
    ExecutorService fixedThreadPool = Executors.newFixedThreadPool(1);
    fixedThreadPool.execute(() -> System.out.println("execute"));

    Future<?> future = fixedThreadPool.submit(newRunnable("Task1.1"));
    System.out.println(future.isDone()); // once task is done, future.isDone() will become true

    try
    {
      future.get();
    }
    catch (InterruptedException | ExecutionException e)
    {

    }
    System.out.println(future.isDone());
    fixedThreadPool.shutdown();
  }

  private static Runnable newRunnable(String message)
  {
    return () -> System.out.println(message + " : " + Thread.currentThread().getName());
  }
}
