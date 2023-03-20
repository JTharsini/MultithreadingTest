package executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class InvokeAll
{
  public static void main(String[] args)
  {
    ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);

    List<Callable<String>> callables = new ArrayList<>();
    callables.add(newCallable("Task1.1"));
    callables.add(newCallable("Task2.1"));
    callables.add(newCallable("Task3.1"));

    List<Future<String>> future = null;
    try
    {
      future = fixedThreadPool.invokeAll(callables);

      for (Future<String> temp : future)
      {
        System.out.println(temp.get());
      }
    }
    catch (InterruptedException | ExecutionException e)
    {
      throw new RuntimeException(e);
    }

    fixedThreadPool.shutdown();
  }

  private static Callable<String> newCallable(String message)
  {
    return () -> message + " : " + Thread.currentThread().getName();
  }
}
