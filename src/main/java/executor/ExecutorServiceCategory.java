package executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceCategory
{
  public static void main(String[] args)
  {
    int corePoolSize = 10; // pool is created with corePoolSize number of threads
    int maxPoolSize = 20; // pool can be extended with maxPoolSize when there are more tasks
    long keepAliveTime = 3000; // idle threads which were created extra after initial size will be
    // alive until this time

    ArrayBlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(128);
    ExecutorService threadPoolExecutor =
      new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, TimeUnit.MILLISECONDS, workQueue);

    threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
    threadPoolExecutor.execute(newRunnable("Task 1"));
    threadPoolExecutor.execute(newRunnable("Task 2"));
    threadPoolExecutor.execute(newRunnable("Task 3"));

    threadPoolExecutor.shutdown();

    ExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(corePoolSize);

    // ScheduledExecutorService extends ExecutorService
    ScheduledExecutorService scheduledExecutorService2 = new ScheduledThreadPoolExecutor(corePoolSize);
  }

  private static Runnable newRunnable(String message)
  {
    return () -> {
      String com = Thread.currentThread().getName() + ":" + message;
      System.out.println(com);
    };
  }
}
