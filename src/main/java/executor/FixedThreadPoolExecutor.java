package executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FixedThreadPoolExecutor
{
  public static void main(String[] args)
  {
    ExecutorService fixedThreadExecutor = Executors.newFixedThreadPool(3);
    List<CountingTask> taskList = new ArrayList<>();
    for (int i = 0; i < 10; i++)
    {
      int task = i;
      String message = "" + task;
      CountingTask callable = new CountingTask(message);
      taskList.add(callable);
    }

    List<Future<String>> countingTasks = null;
    try
    {
      countingTasks = fixedThreadExecutor.invokeAll(taskList);
    }
    catch (InterruptedException e)
    {
      throw new RuntimeException(e);
    }
    fixedThreadExecutor.shutdown();

    for (Future<String> result : countingTasks)
    {
      try
      {
        System.out.println(result.get());
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }
      catch (ExecutionException e)
      {
        throw new RuntimeException(e);
      }
    }
  }
}

class CountingTask implements Callable<String>
{
  private String message;

  CountingTask(String message)
  {
    this.message = message;
  }

  @Override
  public String call() throws Exception
  {
    return Thread.currentThread().getName() + ": " + message;
  }
}
